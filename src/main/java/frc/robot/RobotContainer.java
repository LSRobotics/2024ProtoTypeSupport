// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


//import edu.wpi.first.cameraserver.CameraServer;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

//import dashboard stuff
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser; 
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Autons.AutonCmd1;
import frc.robot.Autons.AutonCmd2;

//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.commandShoot;
import frc.robot.commands.talonSpinCmd;
import frc.robot.commands.ArmDownCmd;
import frc.robot.commands.ArmUpCmd;
import frc.robot.commands.HandGrabCmd;
import frc.robot.commands.HandReleaseCmd;
import frc.robot.commands.SequenceCmd;
import frc.robot.commands.SequenceCmd2;
//import frc.robot.commands.ParallelCmd;
import frc.robot.subsystems.ArmAssembly;
import frc.robot.subsystems.subShooter;
import frc.robot.subsystems.subTalonTest;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  
  
  // Two Joysticks on USB ports 0 and 1 
  private final XboxController driverJoyStick;  
  private final XboxController operatorJoyStick; 

  //Commands
   private final ArmUpCmd       m_ArmUpCmd        ; 
   private final ArmDownCmd     m_ArmDownCmd      ; 
   private final HandGrabCmd    m_HandGrabCmd     ; 
   private final HandReleaseCmd m_HandReleaseCmd  ; 
   private final AutonCmd1      m_AutonCmd1       ;
   private final AutonCmd2      m_AutonCmd2       ;
   private final SequenceCmd    m_SequenceCmd     ;
   private final SequenceCmd2   m_SequenceCmd2    ;
   private final commandShoot   m_CommandShoot    ;
   private final talonSpinCmd   m_TalonSpinCmd    ;
   
   //Subsystems
  private final ArmAssembly     armAssemblySub     ; 
  private final subShooter      subShooterSub      ;
  private final subTalonTest    subTalonTestSub    ;

  //Others
  //private final double          sp                 ;

  SendableChooser<Command> chooser = new SendableChooser<>();
  //SendableChooser<Command> chooser_SpeedLeft = new SendableChooser<>();
  //SendableChooser<Command> chooser_SpeedRight = new SendableChooser<>();

  public RobotContainer() {

    //Initialize both xbox controlers on USB ports 0 for drive and 1 for operator
    driverJoyStick   = new XboxController(Constants.kUSBPort0);
    operatorJoyStick = new XboxController(Constants.kUSBPort1);
  
    //Initialize my local objects of type subsystem
    armAssemblySub   = new ArmAssembly(); 
    subShooterSub    = new subShooter();
    subTalonTestSub  = new subTalonTest();

    //Initialize my local objects of type Command 
    m_ArmUpCmd       = new ArmUpCmd(armAssemblySub)       ; 
    m_ArmDownCmd     = new ArmDownCmd(armAssemblySub)     ; 
    m_HandGrabCmd    = new HandGrabCmd(armAssemblySub)    ; 
    m_HandReleaseCmd = new HandReleaseCmd(armAssemblySub) ;
    m_CommandShoot   = new commandShoot(subShooterSub)    ;   

    m_AutonCmd1       = new AutonCmd1(armAssemblySub);
    m_AutonCmd2       = new AutonCmd2(armAssemblySub);
    m_SequenceCmd     = new SequenceCmd(armAssemblySub);
    m_SequenceCmd2    = new SequenceCmd2(armAssemblySub);
    m_TalonSpinCmd    = new talonSpinCmd(subTalonTestSub,operatorJoyStick.getRawAxis(0));
 

    // Configure the button bindings

    configureButtonBindings();

    // Add to Choices to SmartDashboard
    SmartDashboard.putData("Autonomous", chooser);
    //SmartDashboard.putData("Left_Speed", chooser);
    //SmartDashboard.putData("Right_Speed", chooser);
    
    // Create a Chooser on the dashboard to pick the Auto Routing
    chooser.addOption("Autonomous Two", m_AutonCmd2);
    chooser.setDefaultOption("Autonomous One", m_AutonCmd1);   
    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
  // Driver JoyStick Triggers and bindings
    Trigger aButton = new JoystickButton(driverJoyStick, XboxController.Button.kA.value);
    Trigger bButton = new JoystickButton(driverJoyStick, XboxController.Button.kB.value);
    Trigger xButton = new JoystickButton(driverJoyStick, XboxController.Button.kX.value);
    Trigger yButton = new JoystickButton(driverJoyStick, XboxController.Button.kY.value);
    Trigger rBumper = new JoystickButton(driverJoyStick, XboxController.Button.kRightBumper.value);
    Trigger lBumper = new JoystickButton(driverJoyStick, XboxController.Button.kLeftBumper.value);
   
    aButton.onTrue(m_ArmUpCmd);
    bButton.onTrue(m_ArmDownCmd);
    xButton.onTrue(m_HandGrabCmd);
    yButton.onTrue(m_HandReleaseCmd); 
    rBumper.onTrue(m_SequenceCmd);
    lBumper.onTrue(m_SequenceCmd2);
    

    //Operator Joystick triggers and Bindings
    
    Trigger aButton_op = new JoystickButton(operatorJoyStick, XboxController.Button.kA.value);
    Trigger bButton_op = new JoystickButton(operatorJoyStick, XboxController.Button.kB.value);
    Trigger yButton_op = new JoystickButton(operatorJoyStick, XboxController.Button.kY.value);
    //Trigger xButton_op = new JoystickButton(operatorJoyStick, XboxController.Button.kX.value);

    //Set the default command for for the Talon Sub to spin this cmd will always be in the schedule
    subTalonTestSub.setDefaultCommand(m_TalonSpinCmd);
            
    aButton_op.onTrue(m_AutonCmd1);
    bButton_op.onTrue(m_SequenceCmd);
    yButton_op.onTrue(m_CommandShoot);       

  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
  
    SmartDashboard.putString("Container", "Starting Auton");
    SmartDashboard.putString("Sequence", "Start");
    
    return chooser.getSelected();
    
  }
}
