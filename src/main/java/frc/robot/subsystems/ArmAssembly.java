// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class ArmAssembly extends SubsystemBase {
  

  /** Creates a new ArmAssembly. */

  // Define the object type
  DoubleSolenoid m_doubleSolenoidShoulder; 
  DoubleSolenoid m_doubleSolenoidGraber;
  

  public ArmAssembly() {

    // Create the object
    m_doubleSolenoidShoulder   = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.kArm_Down_port,Constants.kArm_up_port);
    m_doubleSolenoidGraber     = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.kGrabber_in_port,Constants.kGrabber_out_port); 
  
  }

  public void armUp() {
     m_doubleSolenoidShoulder.set(DoubleSolenoid.Value.kReverse);
  }

  public void armDown() {
    m_doubleSolenoidShoulder.set(DoubleSolenoid.Value.kForward);
 }

  public void closeHand() {
    m_doubleSolenoidGraber.set(DoubleSolenoid.Value.kReverse);
}

  public void openHand() {
    m_doubleSolenoidGraber.set(DoubleSolenoid.Value.kForward);
}
 // We Don't want a default command for this subsystem
 // Whatever state the subsystem is in... Keep it...
   
 public void initDefaultCommand() {
  // Set the default command for a subsystem here.
  // setDefaultCommand(new MySpecialCommand());


 }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
