
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSystem;

public class TurnTo extends CommandBase {

  double goal;
  public static final double MULT = 1;
  double error;
  
  public TurnTo(double angle) {
    addRequirements(Robot.ds);
    goal = angle;
  }

  public void initialize() {
  }

  public void execute() {
    error = Robot.getAngle() - goal;
    if (error < -180)
      error += 360;
    else if (error > 180)
      error -= 360;
    error /= 180;
    double turn = (DriveSystem.P * error) - (DriveSystem.D * Robot.gyro.getRate());
    Robot.ds.setSpeed(turn * MULT, -turn * MULT);
  }

  public void end(boolean interrupted) {
    System.out.println("Turned to: " + Robot.getAngle() + "\nGoal: " + goal);
  }

  public boolean isFinished() {
    return Math.abs(error) < 1;
  }
}
