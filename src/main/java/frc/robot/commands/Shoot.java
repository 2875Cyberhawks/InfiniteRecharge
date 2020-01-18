

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.util.IO;

public class Shoot extends CommandBase {
  
  public Shoot() {
    addRequirements(Robot.ss);
  }

  
  public void initialize() {
    Robot.ss.setSetpoint(Robot.ss.MAX_SPD / 2, Robot.ss.MAX_SPD / 2);
    Robot.ss.stop();
  }


  public void execute() {
    double sInc = IO.getY() ? Robot.ss.MAX_SPD * .05 : (IO.getA() ? -Robot.ss.MAX_SPD * .05 : 0);
    double nInc = IO.getB() ? Robot.ss.MAX_SPD * .05 : (IO.getX() ? -Robot.ss.MAX_SPD * .05 : 0);

    Robot.ss.setSetpoint(Robot.ss.setpointS + sInc, Robot.ss.setpointN + nInc);
    
    if(IO.getShoot()){
      Robot.ss.move();
    }
    else{
      Robot.ss.stop();
    }
  }

  public void end(boolean interrupted) {
  }

  public boolean isFinished() {
    return false;
  }
}
