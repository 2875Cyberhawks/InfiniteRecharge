
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class MovePath extends CommandBase {

  public MovePath() {
    addRequirements(Robot.ds);
  }

  public void initialize() {
  }

  public void execute() {
  }

  public void end(boolean interrupted) {
  }

  public boolean isFinished() {
    return false;
  }
}
