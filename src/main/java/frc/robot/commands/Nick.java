package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.util.IO;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Nick extends CommandBase {

  private double speed = Robot.ns.MAX_SPD / 2;
  
  public Nick() {
    addRequirements(Robot.ns);
  }

  public void initialize() {
    Robot.ns.setSetpoint(0);
  }

  public void execute() {

    speed  += IO.getY() && speed < Robot.ns.MAX_SPD ? Robot.ns.MAX_SPD * .05 : (IO.getA() && speed > Robot.ns.MAX_SPD ? -Robot.ns.MAX_SPD * .05 : 0);

    if(IO.getShoot()){
      Robot.ns.setSetpoint(speed);
    }
    else{
      Robot.ns.setSetpoint(0);
    }

    SmartDashboard.putNumber("nick error", Robot.ns.getController().getVelocityError());
  }

  public void end(boolean interrupted) {
    Robot.ns.disable();
  }


  public boolean isFinished() {
    return false;
  }
}