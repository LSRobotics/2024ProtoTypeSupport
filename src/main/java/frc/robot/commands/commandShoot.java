// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.subShooter;

public class commandShoot extends Command {

  subShooter mSubShooter;

  double mLeftSpeed;
  double mRightSpeed;
  
  /** Creates a new ArmUpCmd. */
  public commandShoot(subShooter ss) {
    
    mSubShooter = ss;
    addRequirements(mSubShooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

   mSubShooter.runShooterSplit(mRightSpeed, mLeftSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
        
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}