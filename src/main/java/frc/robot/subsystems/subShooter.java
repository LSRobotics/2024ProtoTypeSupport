// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

//import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class subShooter extends SubsystemBase {

  private CANSparkMax m_leftMotor;
  private CANSparkMax m_rightMotor;

  public subShooter() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    m_leftMotor = new CANSparkMax(Constants.kCanID10, CANSparkLowLevel.MotorType.kBrushless);
    m_rightMotor = new CANSparkMax(Constants.kCanID11, CANSparkLowLevel.MotorType.kBrushless);

    m_leftMotor.restoreFactoryDefaults();
    m_rightMotor.restoreFactoryDefaults();
    
  }

    public void runShooter(double m_speed) {

      m_leftMotor.setOpenLoopRampRate(0);
      m_rightMotor.setOpenLoopRampRate(0);

      m_leftMotor.set(m_speed);
      m_rightMotor.set(m_speed);
    }

  
  public void runShooterSplit(double r_speed,double l_speed) {
     
      m_leftMotor.setOpenLoopRampRate(0);
      m_rightMotor.setOpenLoopRampRate(0);

      m_leftMotor.set(l_speed);
      m_rightMotor.set(r_speed);
    
}
}