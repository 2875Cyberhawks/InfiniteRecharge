package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;

public class MoveDist extends CommandBase {

  private double goal;
  private double[] init;
  public static final double F = .5;
  private double ang;

  public static final double TOL = .1;

  public MoveDist(double d) {
    addRequirements(Robot.ds);
    goal = d;
  }

  public void initialize() {
    init = Robot.ds.getPositions();
    ang = Robot.getAngle();
  }

  public void execute() {
    double error = Robot.getAngle() - ang;

    if (error < -180)
      error += 360;
    else if (error > 180)
      error -= 360;
    error /= 180;

    double corr = (DriveSystem.P * error) - (DriveSystem.D * Robot.gyro.getRate());

    corr = Math.abs(corr) > DriveSystem.MAX_CORR ? Math.abs(corr) / corr  * DriveSystem.MAX_CORR : corr;
  }

  public void end(boolean interrupted) {
    double[] pos = Robot.ds.getPositions();
    double dist = ((pos[0] - init[0]) + (pos[1] - init[1])) / 2;
    System.out.println("moved: " + dist + "\nGoal: " + goal);
  }

  public boolean isFinished() {
    return false;
  }
}