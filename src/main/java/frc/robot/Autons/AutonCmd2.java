

  package frc.robot.Autons;

import frc.robot.commands.ArmDownCmd;
import frc.robot.commands.ArmUpCmd;
import frc.robot.commands.HandGrabCmd;
import frc.robot.commands.HandReleaseCmd;
import frc.robot.subsystems.ArmAssembly;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

  
    public class AutonCmd2 extends SequentialCommandGroup {

      //ArmAssembly mArmAssembly;

      public  AutonCmd2(ArmAssembly aa) {

        //mArmAssembly = aa;
        //addRequirements(mArmAssembly);

        addCommands(
          new ArmDownCmd(aa),
          new HandGrabCmd(aa),
          new WaitCommand(3),
          new ArmUpCmd(aa),
          new HandReleaseCmd(aa)
          );      


      SmartDashboard.putString("Auton2", "Finished");
      }
    }
  
