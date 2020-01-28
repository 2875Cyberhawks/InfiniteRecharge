
package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.util.IO;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive extends CommandBase {
  
  public Drive() {
    addRequirements(Robot.ds);
  }

  public void initialize() {
    Robot.ds.setSpeed(0, 0);
  }

  public void execute() {
    
  }

  public void end(boolean interrupted) {
    Robot.ds.setSpeed(0, 0);
  }

  public boolean isFinished() {
    return false;
  }
}
