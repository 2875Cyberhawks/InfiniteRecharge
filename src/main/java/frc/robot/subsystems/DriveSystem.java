package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSystem extends SubsystemBase {

  public static final int[][] D_PORTS = {{0, 1},
                                         {2, 3},
                                         {4, 5}};

  public static final int[][] E_PORTS = {{6, 7},
                                         {8, 9}};
  
  private SpeedControllerGroup left = new SpeedControllerGroup(new Spark(D_PORTS[0][0]), new Spark(D_PORTS[1][0]), new Spark(D_PORTS[2][0]));
  
  private SpeedControllerGroup right = new SpeedControllerGroup(new Spark(D_PORTS[0][1]), new Spark(D_PORTS[1][1]), new Spark(D_PORTS[2][1]));

  private Encoder leftEnc = new Encoder(E_PORTS[0][0], E_PORTS[0][1]);

  private Encoder rightEnc = new Encoder(E_PORTS[1][0], E_PORTS[1][1]);

  private double lSpeed = 0;

  private double rSpeed = 0;

  public DriveSystem() {
    leftEnc.setDistancePerPulse(1.0/2048.0);
    rightEnc.setDistancePerPulse(1.0/2048.0);
  }

  public void periodic() {
    left.set(lSpeed);
    right.set(rSpeed);
  }

  public void setSpeed(double l, double r){
    lSpeed = l;
    rSpeed = r;
  }
  
}
