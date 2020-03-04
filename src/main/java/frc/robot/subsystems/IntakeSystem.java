
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Spark;

public class IntakeSystem extends SubsystemBase {
  
  public static final int[] M_PORTS = {4, 5, 6};
  public static final int[] ENC_PORTS = {6, 7};

  public static TalonSRX angle = new TalonSRX(M_PORTS[0]);
  public static Spark intake = new Spark(M_PORTS[1]);
  public static Spark elevator = new Spark(M_PORTS[2]);

  private static final double P = 0;

  private static final double I = 0;
  
  private static final double D = 0;

  public static Encoder angEnc = new Encoder(ENC_PORTS[0], ENC_PORTS[1]);

  public static final double MIN_POS = 0;
  public static final double MAX_POS = 0;

  private boolean limited = true;

  public double setpoint = 0;
  public double inSpeed = 0;
  public double eSpeed = 0;
  public IntakeSystem() {
   setpoint = 0;
   eSpeed = 0;
   inSpeed = 0;
   angle.configFactoryDefault();
 
   angle.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
 
   angle.configContinuousCurrentLimit(40);
   angle.enableCurrentLimit(true);
   
   angle.configNominalOutputForward(0);
   angle.configNominalOutputReverse(0);
   angle.configPeakOutputForward(1);
   angle.configPeakOutputReverse(-1);
   angle.setIntegralAccumulator(0);
   angle.config_IntegralZone(0, 60);
 
   angle.config_kP(0, P);
   angle.config_kI(0, I); 
   angle.config_kD(0, D);
   angle.config_kF(0, 0);
 
   angle.setSelectedSensorPosition(0); 
  }
  public void setSetpoint(double s){
    setpoint = s;
  }
  public void setIntake(double input){
    inSpeed = input;
  }
  public void setElevator(double input){
    eSpeed = input;
  }
  public void disable(){
    setpoint = 0;
    elevator.setSpeed(0);
    intake.setSpeed(0);
  }
  
  public void moveInc(double diff){
    diff = limited && ((angle.getSelectedSensorPosition() > (MAX_POS) && diff > 0) 
    || (angle.getSelectedSensorPosition() < (MIN_POS) && diff < 0)) ? 0 : diff;
    setSetpoint(setpoint + diff);
  }

  public void periodic(){
    angle.set(ControlMode.MotionMagic, setpoint);
    intake.set(inSpeed);
    elevator.set(eSpeed);
  }
}
