package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.ShootSystem;

public class ShootNum extends CommandBase {
  
  private int numBalls = 0;
  private int shot = 0;
  private Timer time = new Timer();

  public ShootNum(int num) {
    addRequirements(Robot.ss);
    numBalls = num;
  }

  public void initialize() {
  }

  public void execute() {
    Robot.ss.setSetpoint(ShootSystem.SAL_SPD, ShootSystem.NICK_SPD);
    if(Robot.ss.atSetpoint()){
      //feed
      shot++;
    }
  }

  public void end(boolean interrupted) {
    Robot.ss.setSetpoint(0, 0);
  }

  public boolean isFinished() {
    return false;
  }
}
