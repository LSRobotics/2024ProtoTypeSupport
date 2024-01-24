// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.subIntake;

public class intakeUpCmd extends Command {

   subIntake m_SubIntake;

  public intakeUpCmd(subIntake si) {

    m_SubIntake = si;
    addRequirements(m_SubIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
 
  @Override
  public void execute() {

    m_SubIntake.intakeUp();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
