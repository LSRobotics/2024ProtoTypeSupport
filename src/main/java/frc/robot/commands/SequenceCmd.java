

  package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.subTalonTest;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

  
    public class SequenceCmd extends SequentialCommandGroup {

      subTalonTest m_SubTalonTest;

      public  SequenceCmd(subTalonTest tt) {

        SmartDashboard.putString("Sequence", "Entry");

        m_SubTalonTest = tt;
        addRequirements(m_SubTalonTest);

        addCommands(
          new talonSpinCmd(tt,Constants.kTalonSpF),
          new WaitCommand(5),
          new talonSpinCmd(tt,Constants.kTalonSpR)
          );      


      SmartDashboard.putString("Sequence", "Finished");
      }
    }
  
