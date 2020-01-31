

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.util.IO;

public class Shoot extends CommandBase {

  public static final double SAL_SPD = 25;
  public static final double NICK_SPD = 44;
  
  public Shoot() {
    addRequirements(Robot.ss);
  }

  
  public void initialize() {
    Robot.ss.setSetpoint(0, 0);
    Robot.ss.stop();
  }


  public void execute() {
    if(IO.getShoot()){
      Robot.ss.setSetpoint(SAL_SPD, NICK_SPD);
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
