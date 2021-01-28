
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import java.nio.file.Path;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj2.command.RamseteCommand;

// public class MovePath extends CommandBase {

//   boolean failed = false;
//   private RamseteCommand ramCom;
//   private Trajectory traj;
//   public static final double B = 0;
//   public static final double ZETA = 0;

//   public MovePath(String path) {
//     addRequirements(Robot.ds);
//     try{
//       Path p = Filesystem.getDeployDirectory().toPath().resolve(path);
//       traj = TrajectoryUtil.fromPathweaverJson(p);
//     }
//     catch(Exception e){
//       System.out.println("path file failed");
//       failed = true;
//     }
//   }

//   public void initialize() {
//     if(!failed){
//       ramCom = new RamseteCommand(traj, Robot.ds::getPose, new RamseteController(B, ZETA), 
//         new SimpleMotorFeedForward(DriveSystem.V, DriveSystem.VSpM, DriveSystem.VS2pM), Robot.ds::getKine, 
//         Robot.ds::getSpeeds, new PIDController(DriveSystem.P, 0, 0), new PIDController(DriveSystem.P, 0, 0), 
//         Robot.ds::setVolts, Robot.ds);
//     }
//   }

//   public void execute() {
//     if(!failed)
//       ramCom.execute();
//   }

//   public void end(boolean interrupted) {
//     if(!failed)
//       ramCom.end();
//     Robot.ds.setSpeed(0, 0);
    
//   }

//   public boolean isFinished() {
//     return failed || ramCom.isFinished();
//   }
// }
