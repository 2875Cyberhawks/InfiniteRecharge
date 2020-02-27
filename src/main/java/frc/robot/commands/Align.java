package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import frc.robot.subsystems.DriveSystem;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.commands.Drive;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Align extends CommandBase {
 
  public boolean highGoal;
  public int noTargets = 0;

  public Align(boolean hg) {
    addRequirements(Robot.ds);
    highGoal = hg;
  }

  public void initialize() {
  }

  public void execute() {
    double error = 0;
    if(highGoal){
      noTargets = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0) == 0 ? noTargets + 1 : 0;
      error = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0) == 0 ? 
      NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0) / 29.8 : Integer.MAX_VALUE;
    }
    else{
      Block target = Robot.ballPixy.getBlock();
      noTargets = target == null ? noTargets + 1 : 0;
      error = target != null ? (target.getX() - 160) / 160 : Integer.MAX_VALUE;
    }
    double turn = error != Integer.MAX_VALUE ? (DriveSystem.P * error) - (DriveSystem.D * Robot.gyro.getRate()) : 0;
    double left = MathUtil.clamp(turn, -1, 1);//T_MULT ? 
    double right = MathUtil.clamp(-turn, -1, 1);
    Robot.ds.setSpeed(left, right);
   }
  

  public void end(boolean interrupted) {
    Robot.ds.setSpeed(0, 0);
    if(!Robot.inAuto)
      CommandScheduler.getInstance().schedule(new Drive());
    System.out.println("aligned");
  }

  public boolean isFinished() {
    if(noTargets > 10)
      return true;
    if(noTargets > 0)
      return false;
    return highGoal ? Math.abs(NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0)) < 1 : Math.abs(Robot.ballPixy.getBlock().getX() - 160) < 5;
  }
}
