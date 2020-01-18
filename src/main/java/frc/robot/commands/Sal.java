package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.util.IO;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Sal extends CommandBase {

  private double speed = Robot.ss.MAX_SPD / 2;
  
  public Sal() {
    addRequirements(Robot.ss);
  }

  public void initialize() {
    Robot.ss.setSetpoint(0);
  }

  public void execute() {

    speed  += IO.getY() && speed < Robot.ss.MAX_SPD ? Robot.ss.MAX_SPD * .05 : (IO.getA() && speed > Robot.ss.MAX_SPD ? -Robot.ss.MAX_SPD * .05 : 0);

    if(IO.getShoot()){
      Robot.ss.setSetpoint(speed);
    }
    else{
      Robot.ss.setSetpoint(0);
    }

    SmartDashboard.putNumber("Sal error", Robot.ss.getController().getVelocityError());
  }

  public void end(boolean interrupted) {
    Robot.ss.disable();
  }


  public boolean isFinished() {
    return false;
  }
}
