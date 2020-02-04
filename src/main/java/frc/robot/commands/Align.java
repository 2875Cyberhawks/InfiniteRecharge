package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.util.PixyCam;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import frc.robot.subsystems.DriveSystem;
import edu.wpi.first.wpiutil.math.MathUtil;

public class Align extends CommandBase {
 
  public PixyCam cam;

  public Align(char c) {
    addRequirements(Robot.ds);
    cam = c == 'b' ? Robot.ballPixy : Robot.goalPixy;
  }

  public void initialize() {
  }

  public void execute() {
    Block target = cam.getBlock();
    double error = target.getX() - 160;
    double turn = (DriveSystem.P * error) - (DriveSystem.D * Robot.gyro.getRate());
    double left = MathUtil.clamp(turn, -1, 1);//T_MULT ? 
    double right = MathUtil.clamp(-turn, -1, 1);
    Robot.ds.setSpeed(left, right);
    }
  

  public void end(boolean interrupted) {
    if(!Robot.inAuto)
      CommandScheduler.getInstance().schedule(new Drive());
    System.out.println("aligned");
  }

  public boolean isFinished() {
    return Math.abs(cam.getBlock().getX() - 160) < 5;
  }
}
