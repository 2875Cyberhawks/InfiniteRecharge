package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.util.IO;

public class Intake extends CommandBase {

  //public static final double SPEED = 4096 * .005;
  private int pos = 0;
  public static final double ESPEED = .5;

  public Intake() {
    addRequirements(Robot.is);
  }
  public void initialize() {
    Robot.is.setSetpoint(0);
    Robot.is.setIntake(0);
  }

  public void execute() {
    Robot.is.setIntake(IO.getIntake());

    pos += IO.getTilt() == 1 && pos < 2 ? 1 : IO.getTilt() == -1 && pos > 0 ? -1 : 0;
    Robot.is.setSetpoint(pos);

    if(IO.getShoot() == 1 && Robot.atSpeed)
      Robot.is.setElevator(ESPEED);
    else if(IO.getShoot() != 1)
      Robot.is.setElevator(IO.getElevator());
  }

  public void end(boolean interrupted) {
    Robot.is.setIntake(0);
  }

  public boolean isFinished() {
    return false;
  }
}
