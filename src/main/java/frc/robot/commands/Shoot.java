

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.util.IO;
import frc.robot.subsystems.ShootSystem;

public class Shoot extends CommandBase {
  
  public Shoot() {
    addRequirements(Robot.ss);
  }

  
  public void initialize() {
    Robot.ss.setSetpoint(0, 0);
    Robot.ss.stop();
  }


  public void execute() {
    if(IO.getShoot()){
      Robot.ss.setSetpoint(ShootSystem.SAL_SPD, ShootSystem.NICK_SPD);
    }
    else{
      Robot.ss.setSetpoint(0, 0);
    }
  }

  public void end(boolean interrupted) {
  }

  public boolean isFinished() {
    return false;
  }
}
