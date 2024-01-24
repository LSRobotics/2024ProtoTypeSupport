

  package frc.robot.Autons;

import frc.robot.Constants;
import frc.robot.commands.shootLeftCmd;
import frc.robot.commands.shootRightCmd;
import frc.robot.commands.shootBothCmd;
import frc.robot.commands.talonSpinCmd;

import frc.robot.subsystems.subShooter;
import frc.robot.subsystems.subTalonTest;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

  
    public class AutonCmd2 extends SequentialCommandGroup {

      public  AutonCmd2(subShooter ss, subTalonTest tt) {

         addRequirements(ss);
         addRequirements(tt);

        addCommands(
          new shootLeftCmd(ss),
          new shootRightCmd(ss),
          new WaitCommand(3),
          new shootBothCmd(ss),
          new talonSpinCmd(tt, Constants.kTalonSpF),
          new WaitCommand(3),
          new talonSpinCmd(tt, Constants.kTalonSpR)
          );      


      SmartDashboard.putString("Auton2", "Finished");
      }
    }
  
