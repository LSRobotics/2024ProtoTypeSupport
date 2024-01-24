// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class subIntake extends SubsystemBase {
  
    private CANSparkMax  m_SpinnerMotor1;
    private CANSparkMax  m_SpinnerMotor2;
    private CANSparkMax  m_DeployMotor;

    private DigitalInput toplimitSwitch = new DigitalInput(2);
    private DigitalInput bottomlimitSwitch = new DigitalInput(3);

  public subIntake() {

    m_SpinnerMotor1 = new CANSparkMax(Constants.kCanID13, MotorType.kBrushless);
    m_SpinnerMotor2 = new CANSparkMax(Constants.kCanID14, MotorType.kBrushless);
    m_DeployMotor   = new CANSparkMax(Constants.kCanID15, MotorType.kBrushless);

    }

  @Override
  public void periodic() {
    
      m_DeployMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, true);
      m_DeployMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, true);

      m_DeployMotor.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, 100);
      m_DeployMotor.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, 0);
  }

  public void intakeDown() {

     m_SpinnerMotor1.set(Constants.kintake_speed);
     m_SpinnerMotor2.set(Constants.kintake_speed * -1);

      if (bottomlimitSwitch.get()) {
        m_DeployMotor.set(Constants.kdeploy_speed);
      }
      else {
        m_DeployMotor.set(0);
      }
  }

  public void intakeUp() {

     m_SpinnerMotor1.set(0);
     m_SpinnerMotor2.set(0);

     if (toplimitSwitch.get()) {
        m_DeployMotor.set(Constants.kdeploy_speed * -1);
      }
      else {
        m_DeployMotor.set(0);
      }
  }

  public void intakeDownOverride() {

      m_DeployMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, false);
      m_DeployMotor.set(Constants.kdeploy_speed);
    }

   public void intakeUpOverride() {

      m_DeployMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, false);
      m_DeployMotor.set(Constants.kdeploy_speed * -1);
    }

    public void intakeDownSoftLimit() {

      m_SpinnerMotor1.set(Constants.kintake_speed);
      m_SpinnerMotor2.set(Constants.kintake_speed * -1);
   
      if (bottomlimitSwitch.get()) {
        m_DeployMotor.set(0);
      }
      else {
        m_DeployMotor.set(Constants.kdeploy_speed);
      }
    }

    public void intakeUpSoftLimit() {

      m_SpinnerMotor1.set(0);
      m_SpinnerMotor2.set(0);
   
      if (toplimitSwitch.get()) {
        m_DeployMotor.set(0);
      }
      else {
        m_DeployMotor.set(Constants.kdeploy_speed * -1);
      }
  }
  
}
