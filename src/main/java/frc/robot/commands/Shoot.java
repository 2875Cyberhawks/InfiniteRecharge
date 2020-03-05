

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.util.IO;

public class Shoot extends CommandBase {
  public static final double FSPEED = .20;
  public Shoot() {
    addRequirements(Robot.ss);
  }

  
  public void initialize() {
    Robot.ss.setSetpoint(0);
    Robot.ss.stop();
  }


  public void execute() {
    int status = IO.getShoot();
    if(status == 1){
      Robot.ss.setSetpoint(sOfD(Robot.getDistance()));
      Robot.ss.setFeed(FSPEED);
      Robot.ss.setBackwards(false);
    }
    else if(status == -1){
      Robot.ss.setBackwards(true);
    }
    else{
      Robot.ss.setBackwards(false);
      Robot.ss.setSetpoint(0);
    }
  }

  public void end(boolean interrupted) {
    Robot.ss.setSetpoint(0);
  }

  public boolean isFinished() {
    return false;
  }

  public double sOfD(double d){
    return 0; //s(d): speed function wrt distance
  }
}
