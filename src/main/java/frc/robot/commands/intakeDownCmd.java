// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.subIntake;

public class intakeDownCmd extends Command {
  
  subIntake m_subIntake;

  public intakeDownCmd(subIntake si) {
   
    m_subIntake = si;
    addRequirements(m_subIntake);
  }

  
  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    m_subIntake.intakeDown();
  }

 
  @Override
  public void end(boolean interrupted) {}

 
  @Override
  public boolean isFinished() {
    return false;
  }
}
