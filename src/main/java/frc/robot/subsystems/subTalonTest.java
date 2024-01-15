// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;

//import com.ctre.phoenix6.controls.DutyCycleOut;

public class subTalonTest extends SubsystemBase {

    // This talon FX is on Can 15.  It is rio not CANivor
    private final TalonFX m_TalonFX                    = new TalonFX(Constants.kCanID15,"rio");
    private final CurrentLimitsConfigs m_currentLimits = new CurrentLimitsConfigs();
    
    //Constructor
    public subTalonTest()    {

    //Setting up stuff about this Talon FX  

    TalonFXConfiguration toConfigure = new TalonFXConfiguration();

    m_currentLimits.SupplyCurrentLimit = 1;             // Limit to 1 amps
    m_currentLimits.SupplyCurrentThreshold = 4;         // If we exceed 4 amps
    m_currentLimits.SupplyTimeThreshold = 1.0;          // For at least 1 second
    m_currentLimits.SupplyCurrentLimitEnable = true;    // And enable it

    m_currentLimits.StatorCurrentLimit = 20;            // Limit stator to 20 amps
    m_currentLimits.StatorCurrentLimitEnable = true;    // And enable it

    toConfigure.CurrentLimits = m_currentLimits;
   
    m_TalonFX.getConfigurator().apply(toConfigure);

    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
          
  }

    public void runTalonTest(double km_speed) {

      m_TalonFX.set(km_speed);
      
    }

  
  
}