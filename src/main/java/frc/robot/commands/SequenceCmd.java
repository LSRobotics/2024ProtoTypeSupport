

  package frc.robot.commands;

import frc.robot.subsystems.ArmAssembly;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

  
    public class SequenceCmd extends SequentialCommandGroup {

      ArmAssembly mArmAssembly;

      public  SequenceCmd(ArmAssembly aa) {

        SmartDashboard.putString("Sequence", "Entry");

        mArmAssembly = aa;
        addRequirements(mArmAssembly);

        addCommands(
          new ArmDownCmd(mArmAssembly),
          new HandGrabCmd(mArmAssembly)
          );      


      SmartDashboard.putString("Sequence", "Finished");
      }
    }
  
