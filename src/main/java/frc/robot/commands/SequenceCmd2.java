

  package frc.robot.commands;

  import frc.robot.subsystems.subShooter;
  import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
  import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
  
    
      public class SequenceCmd2 extends SequentialCommandGroup {
  
        subShooter m_SubShooter;
  
        public  SequenceCmd2(subShooter ss) {
  
          SmartDashboard.putString("Sequence", "Entry");
  
          m_SubShooter = ss;
          addRequirements(m_SubShooter);
  
          addCommands(
            new shootBothCmd(m_SubShooter),
            new shootBothCmd(m_SubShooter)
            );      
  
  
        SmartDashboard.putString("Sequence", "Finished");
        }
      }
    
  