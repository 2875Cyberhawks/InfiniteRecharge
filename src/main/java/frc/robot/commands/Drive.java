
package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.util.IO;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;

public class Drive extends CommandBase {

  public static final double T_MULT = .5;
  public double lastAng = 0; 
  public double gyAng = 0;
  public static final double P = 0;
  public static final double D = 0;

  public Drive() {
    addRequirements(Robot.ds);
  }

  public void initialize() {
    Robot.ds.setSpeed(0, 0);
    Robot.gyro.reset();
    lastAng = Robot.getAngle();
    gyAng = lastAng;
  }

  public void execute() {
    gyAng = Robot.getAngle();

    double turn = IO.getTurn();
    double notPaul = IO.getForward();

    if(turn == 0 && notPaul != 0)
      turn = notPaulDrive();
    else
      lastAng = gyAng;

    double left = MathUtil.clamp(notPaul + turn * T_MULT, -1, 1);
    double right = MathUtil.clamp(notPaul - turn * T_MULT, -1, 1);
    Robot.ds.setSpeed(left, right);
    
    
  }

  public double notPaulDrive() {
    double error = gyAng - lastAng;
    
    if (error < -180)
      error += 360;
    else if (error > 180)
      error -= 360;
    error /= 180;

    return (P * error) - (D * Robot.gyro.getRate());
  }

  public void end(boolean interrupted) {
    Robot.ds.setSpeed(0, 0);
    Robot.gyro.reset();
  }

  public boolean isFinished() {
    return false;
  }
}
