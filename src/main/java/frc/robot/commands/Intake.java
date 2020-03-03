package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import frc.robot.subsystems.DriveSystem;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.commands.Drive;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.util.IO;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Intake extends CommandBase {
  public static final SPEED = 1.5;
  public Intake() {
    addRequirements(Robot.is);
  }

  @Override
  public void initialize() {
    Robot.is.setSetpoint(0);
  };

  @Override
  public void execute() {
      if (IO.getX()){
        Robot.is.setSpeed(1);
      }
      if (Robot.IO.getTiltation() != 0)
      {
         Robot.is.moveInc(Robot.IO.getTiltation() * SPEED);
      }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}