// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

//import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class subShooter extends SubsystemBase {

  private CANSparkMax m_leftMotor;
  private CANSparkMax m_rightMotor;

  private DigitalInput toplimitSwitch    = new DigitalInput(0);
  private DigitalInput bottomlimitSwitch = new DigitalInput(1);

  public subShooter() {
    
    m_leftMotor = new CANSparkMax(Constants.kCanID10, MotorType.kBrushless);
    m_rightMotor = new CANSparkMax(Constants.kCanID11, MotorType.kBrushless);

    m_leftMotor.restoreFactoryDefaults();
    m_rightMotor.restoreFactoryDefaults();
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
   
  }

  public void runShooter(double m_speed) {

    m_leftMotor.setOpenLoopRampRate(0);
    m_rightMotor.setOpenLoopRampRate(0);

    m_leftMotor.set(m_speed);
    m_rightMotor.set(m_speed);
  }

  public void runShooterLeftMotor(double deploy_speed){

    m_leftMotor.set(deploy_speed);
    SmartDashboard.putBoolean("TopLimit", toplimitSwitch.get());
    SmartDashboard.putBoolean("BottomLimit", bottomlimitSwitch.get());        
  }

  public void runRightMotor(double intake_speed){
    m_rightMotor.set(intake_speed);
  }
  public void runShooterSplit(double r_speed,double l_speed) {
     
      m_leftMotor.setOpenLoopRampRate(0);
      m_rightMotor.setOpenLoopRampRate(0);

      m_leftMotor.set(l_speed);
      m_rightMotor.set(r_speed);
    
}
/* 
public void runLimit(double deploy_speed) {
    if(toplimitSwitch.get() && deploy_speed >= 0){
      m_leftMotor.set(deploy_speed);
    }
    else if(bottomlimitSwitch.get() && deploy_speed <= 0){
      m_leftMotor.set(deploy_speed);
    }
    else{
      m_leftMotor.set(0);
    }
   
}
 */
}