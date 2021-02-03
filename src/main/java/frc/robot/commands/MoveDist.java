package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;
import edu.wpi.first.wpiutil.math.MathUtil;

public class MoveDist extends CommandBase {

  private double goal;
  private double[] init;
  public final double f = .5;
  private double ang;
  public final double tol = .5;

  public MoveDist(double d, double tol2) {
    addRequirements(Robot.ds);
    goal = d;
  }

  public void initialize() {
    init = Robot.ds.getPositions();
    ang = Robot.getAngle();
  }

  public void execute() {
    double error = (goal - avgDist()) / goal;

    double move = (DriveSystem.P * error) - (DriveSystem.D * Robot.ds.avgSpeed());

    error = Robot.getAngle() - ang;

    if (error < -180)
      error += 360;
    else if (error > 180)
      error -= 360;
    error /= 180;

    double corr = (DriveSystem.P * error) - (DriveSystem.D * Robot.gyro.getRate());

    corr = Math.abs(corr) > DriveSystem.MAX_CORR ? Math.abs(corr) / corr  * DriveSystem.MAX_CORR : corr;

    Robot.ds.setSpeed(MathUtil.clamp(move + corr, -1, 1), MathUtil.clamp(move - corr, -1, 1));
  }

  public void end(boolean interrupted) {
    Robot.ds.setSpeed(0, 0);
    System.out.println("moved: " + avgDist() + "\nGoal: " + goal);
  }

  public boolean isFinished() {
    double error = Robot.getAngle() - ang;
    if (error < -180)
      error += 360;
    else if (error > 180)
      error -= 360;
    error /= 180;
    return Math.abs(goal - avgDist()) <= .5 && Math.abs(error) < 1;
  }

  public double avgDist(){
    double[] pos = Robot.ds.getPositions();
    return ((pos[0] - init[0]) + (pos[1] - init[1])) / 2;
  }
}
