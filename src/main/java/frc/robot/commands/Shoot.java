

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.util.IO;

public class Shoot extends CommandBase {
  
  public Shoot() {
    addRequirements(Robot.ss);
  }

  
  public void initialize() {
    Robot.ss.setSetpoint(0);
    Robot.ss.stop();
  }


  public void execute() {
    if(IO.getShoot()){
      Robot.ss.setSetpoint(sOfD(Robot.getDistance()));
    }
    else{
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
