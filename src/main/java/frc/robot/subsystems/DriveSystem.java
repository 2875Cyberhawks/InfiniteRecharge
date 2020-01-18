/*package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {

  public static final int[][] D_PORTS = {{0, 1},
                                         {2, 3},
                                         {4, 5}};

  public static final int[] E_PORTS = {6, 7};
  
  private SpeedControllerGroup left = new SpeedControllerGroup(new Spark(D_PORTS[0][0]), new Spark(D_PORTS[1][0]), new Spark(D_PORTS[2][0]));
  
  private SpeedControllerGroup right = new SpeedControllerGroup(new Spark(D_PORTS[0][1]), new Spark(D_PORTS[1][1]), new Spark(D_PORTS[2][1]));

  private Encoder enc = new Encoder(E_PORTS[0], E_PORTS[1]);

  public DriveSystem() {

  }

  public void initDefaultCommand() {
    
  }
}*/
