package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Succ extends CommandBase {

  public static final double SPEED = .5;
  
  public Succ() {
    addRequirements(Robot.is); 
  }

  public void initialize() {
  }

  public void execute() {
    Robot.is.setIntake(SPEED);
  }

  public void end(boolean interrupted) {
    Robot.is.setIntake(0);
  }

  public boolean isFinished() {
    return false;
  }
}
