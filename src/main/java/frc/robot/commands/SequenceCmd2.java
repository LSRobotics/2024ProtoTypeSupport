

  package frc.robot.commands;

  import frc.robot.subsystems.ArmAssembly;
  import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
  import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
  
    
      public class SequenceCmd2 extends SequentialCommandGroup {
  
        ArmAssembly mArmAssembly;
  
        public  SequenceCmd2(ArmAssembly aa) {
  
          SmartDashboard.putString("Sequence", "Entry");
  
          mArmAssembly = aa;
          addRequirements(mArmAssembly);
  
          addCommands(
            new ArmUpCmd(mArmAssembly),
            new HandReleaseCmd(mArmAssembly)
            );      
  
  
        SmartDashboard.putString("Sequence", "Finished");
        }
      }
    
  