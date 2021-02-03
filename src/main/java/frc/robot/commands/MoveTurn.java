/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import edu.wpi.first.wpiutil.math.MathUtil;



public class MoveTurn extends CommandBase {
  private double distance;
  private double turn;
  public final double T_MULT = .3;
  private double[] init;
  public final double ACCEPTED_ERROR = .5;
 //check for turn inputs!!!
  public MoveTurn(double t, double d) {
    addRequirements(Robot.ds);
    distance = d;
    turn = t; 
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    init = Robot.ds.getPositions();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double left = -MathUtil.clamp(turn * T_MULT, -1, 1);
    double right = MathUtil.clamp(-turn * T_MULT, -1, 1);
    Robot.ds.setSpeed(left, right);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.ds.setSpeed(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(distance - avgDist()) < ACCEPTED_ERROR; 
  }

  public double avgDist(){
    double[] pos = Robot.ds.getPositions();
    return ((pos[0] - init[0]) + (pos[1] - init[1])) / 2;
  }
}
