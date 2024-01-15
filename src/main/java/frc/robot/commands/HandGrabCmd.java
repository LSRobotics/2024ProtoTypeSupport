// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmAssembly;

public class HandGrabCmd extends Command {

  ArmAssembly mArmAssembly;

  /** Creates a new ArmUpCmd. */
  public HandGrabCmd(ArmAssembly as) {
    
    mArmAssembly = as;
    addRequirements(mArmAssembly);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    SmartDashboard.putString("HandG", "In")    ;
    mArmAssembly.closeHand();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //SmartDashboard.putString("HandG", "Hand Grabbing (exe)")    ;
    //mArmAssembly.closeHand();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
    SmartDashboard.putString("HandG", "Out")    ;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}