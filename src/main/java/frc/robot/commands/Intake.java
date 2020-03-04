package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.util.IO;

public class Intake extends CommandBase {

  public static final double SPEED = 4096 * .005;

  public Intake() {
    addRequirements(Robot.is);
  }
  public void initialize() {
    Robot.is.setSetpoint(0);
    Robot.is.setIntake(0);
  }

  public void execute() {
    Robot.is.setIntake(IO.getIntake());

    if (IO.getTilt() != 0)
      Robot.is.moveInc(IO.getTilt() * SPEED);
  }

  public void end(boolean interrupted) {
    Robot.is.setIntake(0);
  }

  public boolean isFinished() {
    return false;
  }
}
