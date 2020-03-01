package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.controller.PIDController;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpiutil.math.MathUtil;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Servo;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSystem extends SubsystemBase {
  public static final int M_PORT = 9;
  public static final int PWM_PORT = 9;
  public static Spark pulley = new Spark(M_PORT);
  public static Servo lock = new Servo(PWM_PORT);
  private int ang = 0;
  private int speed = 0;
  public ClimbSystem() {
    lock.setAngle(0);
  }
  
  public void toggle(){
    ang = ang == 0 ? 180 : 0;
  }
       
  public void setSpeed(double input){
    speed = input;
  }

  public void periodic() {
    lock.setAngle(ang);
    pulley.set(speed);
  }
  
}
