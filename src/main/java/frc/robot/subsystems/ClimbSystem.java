package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Servo;

public class ClimbSystem extends SubsystemBase {

  public static final int M_PORT = 9;
  public static Spark pulley = new Spark(M_PORT);

  public static final int S_PORT = 0;
  public static Servo lock = new Servo(S_PORT);

  private double ang = 0;
  private double speed = 0;

  public ClimbSystem(){
    lock.setAngle(0);
    pulley.setSpeed(0);
  }  
  public void toggle(){
    ang = ang == 0 ? 180 : 0;
  }
       
  public void setSpeed(double input){
    speed = input;
  }
  
  public void stop(){
    ang = 0; //set motors to 0 manually?
    speed = 0;
  }

  public void periodic() {
    lock.setAngle(ang);
    pulley.set(speed);
  }
  
}
