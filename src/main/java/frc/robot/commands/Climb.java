
package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.util.IO;


import edu.wpi.first.wpilibj2.command.CommandBase;

public class Climb extends CommandBase {

  public static final double SPEED = .6;

  public Climb() {
    addRequirements(Robot.cs);
  }

  public void initialize() {
      Robot.cs.stop();
    }

  public void execute() {
    if (IO.getDPadUp())
      Robot.cs.setSpeed(SPEED);
    else if (IO.getDPadDown())
      Robot.cs.setSpeed(-SPEED);
      
    if (IO.getA()){
      Robot.cs.toggle();
    }      
  }

  public void end(boolean interrupted) {
  }

  public boolean isFinished() {
    return false;
  }
}
