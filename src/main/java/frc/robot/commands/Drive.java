
package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.util.IO;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.subsystems.DriveSystem;
import frc.robot.commands.Align;

public class Drive extends CommandBase {

  public static final double T_MULT = .5;
  public double lastAng = 0; 
  public double gyAng = 0;

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
    /*if(IO.getA())
      CommandScheduler.getInstance().schedule(new Align('a'));
    else if(IO.getB())
      CommandScheduler.getInstance().schedule(new Align('b'));
    else if(turn == 0 && notPaul != 0)
      turn = notPaulDrive();
    else
      lastAng = gyAng;*/

    double left = -MathUtil.clamp(notPaul + turn * T_MULT, -1, 1);
    double right = MathUtil.clamp(notPaul - turn * T_MULT, -1, 1);
    Robot.ds.setSpeed(left, right);
    
    
  }

  public double notPaulDrive() {
    return 0;
    /*double error = gyAng - lastAng;

    if (error < -180)
      error += 360;
    else if (error > 180)
      error -= 360;
    error /= 180;

    double corr = (DriveSystem.P * error) - (DriveSystem.D * Robot.gyro.getRate());

    return Math.abs(corr) > DriveSystem.MAX_CORR ? Math.abs(corr) / corr  * DriveSystem.MAX_CORR : corr;*/
  }

  public void end(boolean interrupted) {
    Robot.ds.setSpeed(0, 0);
    Robot.gyro.reset();
  }

  public boolean isFinished() {
    return false;
  }
}
