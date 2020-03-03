package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Succ extends CommandBase {
  
  public Succ() {
    addRequirements(Robot.is); 
  }

  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
    Robot.is.setSpeed(1);
  }

    @Override
  public void end(boolean interrupted) {
    Robot.is.setSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
