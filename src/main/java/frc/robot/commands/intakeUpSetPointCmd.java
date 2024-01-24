
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.subIntake;

public class intakeUpSetPointCmd extends Command {
  
  subIntake m_subIntake;

  public intakeUpSetPointCmd(subIntake si) {
          
    m_subIntake = si;
    addRequirements(m_subIntake);
  }


  @Override
  public void initialize() {}

 
  @Override
  public void execute() {
    m_subIntake.intakeUpSoftLimit();
  }

 
  @Override
  public void end(boolean interrupted) {}


  @Override
  public boolean isFinished() {
    return false;
  }
}
