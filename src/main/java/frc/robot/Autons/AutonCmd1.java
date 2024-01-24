
package frc.robot.Autons;


import frc.robot.subsystems.subTalonTest;
import frc.robot.Constants;
import frc.robot.commands.shootLeftCmd;
import frc.robot.commands.talonSpinCmd;
import frc.robot.subsystems.subShooter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

  public class AutonCmd1 extends SequentialCommandGroup {

    //ArmAssembly mArmAssembly;

    public  AutonCmd1(subTalonTest tt, subShooter ss) {
 
      //mArmAssembly = aa;
      //addRequirements(mArmAssembly);

      //addRequirements(aa);

      SmartDashboard.putString("Auton1", "Starting");

      addCommands(
        new talonSpinCmd(tt, Constants.kTalonSpR),
        new WaitCommand(2),
        new talonSpinCmd(tt, Constants.kTalonSpF),
        new WaitCommand(2),
        new shootLeftCmd(ss)        
        );

        SmartDashboard.putString("Auton1", "Finished");  
    }
  }
