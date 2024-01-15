// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmAssembly;

public class HandReleaseCmd extends Command {

  ArmAssembly mArmAssembly;

  /** Creates a new ArmUpCmd. */
  public HandReleaseCmd(ArmAssembly as) {
    
    mArmAssembly = as;
    addRequirements(mArmAssembly);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    SmartDashboard.putString("HandR", "In")    ;
    mArmAssembly.openHand();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //SmartDashboard.putString("HandR", "Hand Release (Exec)")    ;
    //mArmAssembly.openHand();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    SmartDashboard.putString("HandR", "Out")    ;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
