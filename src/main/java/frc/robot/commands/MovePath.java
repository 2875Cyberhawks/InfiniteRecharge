/*
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import java.nio.file.Path;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj2.command.RamseteCommand;

public class MovePath extends CommandBase {

  boolean failed = false;
  private RamseteController ram;
  private Trajectory traj;

  public MovePath(String path) {
    addRequirements(Robot.ds);
    try{
      Path p = Filesystem.getDeployDirectory().toPath().resolve(path);
      traj = TrajectoryUtil.fromPathweaverJson(p);
    }
    catch(Exception e){
      System.out.println("path file failed");
      failed = true;
    }
  }

  public void initialize() {
    if(!failed){
      
    }
  }

  public void execute() {
    if(!failed){

    }
  }

  public void end(boolean interrupted) {
    Robot.ds.setSpeed(0, 0);
  }

  public boolean isFinished() {
    return failed;
  }
}
*/