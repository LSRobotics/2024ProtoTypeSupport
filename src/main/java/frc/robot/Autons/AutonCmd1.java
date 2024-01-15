
package frc.robot.Autons;

import frc.robot.commands.ArmDownCmd;
import frc.robot.commands.ArmUpCmd;
import frc.robot.commands.HandGrabCmd;
import frc.robot.commands.HandReleaseCmd;
import frc.robot.subsystems.ArmAssembly;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

  public class AutonCmd1 extends SequentialCommandGroup {

    //ArmAssembly mArmAssembly;

    public  AutonCmd1(ArmAssembly aa) {
 
      //mArmAssembly = aa;
      //addRequirements(mArmAssembly);

      //addRequirements(aa);

      SmartDashboard.putString("Auton1", "Starting");

      addCommands(
        new ArmUpCmd(aa),
        new WaitCommand(2),
        new HandGrabCmd(aa),
        new WaitCommand(2),
        new ArmDownCmd(aa),
        new WaitCommand(2),
        new HandReleaseCmd(aa),
        new WaitCommand(2),
        new ArmUpCmd(aa),
        new WaitCommand(2),
        new HandGrabCmd(aa),
        new WaitCommand(2),
        new ArmDownCmd(aa),
        new WaitCommand(2),
        new HandReleaseCmd(aa)
        
        );

        SmartDashboard.putString("Auton1", "Finished");  
    }
  }
