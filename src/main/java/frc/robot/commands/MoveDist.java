package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;

public class MoveDist extends CommandBase {

  private double goal;
  private double[] init;
  private double speed = .5;
  private double ang;

  public static final double TOL = .1;

  public MoveDist(double d) {
    addRequirements(Robot.ds);
    goal = d;
  }

  public MoveDist(double d, double s){
    addRequirements(Robot.ds);
    goal = d;
    speed = s;
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
  }

  public boolean isFinished() {
    return false;
  }
}
