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

import frc.robot.commands.shootBothCmd;
import frc.robot.commands.talonSpinCmd;
import frc.robot.commands.SequenceCmd;
import frc.robot.commands.SequenceCmd2;
import frc.robot.commands.shootRightCmd;
import frc.robot.commands.shootLeftCmd;
import frc.robot.commands.intakeDownCmd;
import frc.robot.commands.intakeUpCmd;
import frc.robot.commands.intakeDownSetPointCmd;
import frc.robot.commands.intakeUpSetPointCmd;

import frc.robot.subsystems.subShooter;
import frc.robot.subsystems.subTalonTest;
import frc.robot.subsystems.subIntake;

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
   private final AutonCmd1      m_AutonCmd1       ;
   private final AutonCmd2      m_AutonCmd2       ;
   private final SequenceCmd    m_SequenceCmd     ;
   private final SequenceCmd2   m_SequenceCmd2    ;

   private final shootBothCmd   m_shootBothCmd    ;
   private final shootLeftCmd   m_shootLeftCmd    ;
   private final shootRightCmd  m_shootRightCmd   ;

   private final talonSpinCmd   m_TalonSpinCmd_F  ;
   private final talonSpinCmd   m_TalonSpinCmd_R  ;
   private final talonSpinCmd   m_TalonSpinCmd_A  ;

   private final intakeDownCmd  m_intakeDownCmd   ;
   private final intakeUpCmd    m_intakeUpCmd     ;

   private final intakeDownSetPointCmd  m_intakeDownSetPointCmd   ;
   private final intakeUpSetPointCmd    m_intakeUpSetPointCmd     ;
   
   //Subsystems
   private final subShooter      m_subShooter      ;
   private final subTalonTest    m_subTalonTest    ;
   private final subIntake       m_SubIntake       ;

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
    m_subShooter    = new subShooter();
    m_subTalonTest  = new subTalonTest();
    m_SubIntake     = new subIntake();

    //Initialize my local objects of type Command 

    m_shootBothCmd     = new shootBothCmd(m_subShooter)    ;
    m_shootLeftCmd     = new shootLeftCmd(m_subShooter)    ;
    m_shootRightCmd    = new shootRightCmd(m_subShooter)   ;

    m_intakeDownCmd    = new intakeDownCmd(m_SubIntake)    ;
    m_intakeUpCmd      = new intakeUpCmd(m_SubIntake)      ;

    m_intakeDownSetPointCmd = new intakeDownSetPointCmd(m_SubIntake)  ;
    m_intakeUpSetPointCmd   = new intakeUpSetPointCmd(m_SubIntake)    ;

    m_TalonSpinCmd_F   = new talonSpinCmd(m_subTalonTest, Constants.kTalonSpF);
    m_TalonSpinCmd_R   = new talonSpinCmd(m_subTalonTest, Constants.kTalonSpR);
    m_TalonSpinCmd_A   = new talonSpinCmd(m_subTalonTest,operatorJoyStick.getRawAxis(0));

    m_AutonCmd1       = new AutonCmd1(m_subTalonTest, m_subShooter);
    m_AutonCmd2       = new AutonCmd2(m_subShooter, m_subTalonTest);

    m_SequenceCmd     = new SequenceCmd(m_subTalonTest);
    m_SequenceCmd2    = new SequenceCmd2(m_subShooter);
    

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

    aButton.onTrue(m_intakeDownCmd);
    bButton.onTrue(m_intakeUpCmd);
   
    rBumper.onTrue(m_SequenceCmd);
    lBumper.onTrue(m_SequenceCmd2);

    xButton.onTrue(m_TalonSpinCmd_F);
    yButton.onTrue(m_TalonSpinCmd_R);   
  
    //Operator Joystick triggers and Bindings
    
    Trigger aButton_op = new JoystickButton(operatorJoyStick, XboxController.Button.kA.value);
    Trigger bButton_op = new JoystickButton(operatorJoyStick, XboxController.Button.kB.value);
    Trigger yButton_op = new JoystickButton(operatorJoyStick, XboxController.Button.kY.value);
    Trigger xButton_op = new JoystickButton(operatorJoyStick, XboxController.Button.kX.value);
    Trigger rBumper_op = new JoystickButton(driverJoyStick, XboxController.Button.kRightBumper.value);
    Trigger lBumper_op = new JoystickButton(driverJoyStick, XboxController.Button.kLeftBumper.value);

    //Set the default command for for the Talon Sub to spin.  This cmd will always be in the schedule
    //subTalonTest.setDefaultCommand(TalonSpinCmd);

    m_subTalonTest.setDefaultCommand(m_TalonSpinCmd_A); 
            
    aButton_op.onTrue(m_AutonCmd1);
    bButton_op.onTrue(m_SequenceCmd);

    bButton_op.onTrue(m_shootBothCmd);
    xButton_op.onTrue(m_shootRightCmd);
    yButton_op.onTrue(m_shootLeftCmd);   
    
    rBumper_op.onTrue(m_intakeDownSetPointCmd);
    lBumper_op.onTrue(m_intakeUpSetPointCmd);
    
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

