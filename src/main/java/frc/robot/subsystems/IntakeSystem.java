
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.controller.PIDController;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpiutil.math.MathUtil;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Spark;
public class IntakeSystem extends SubsystemBase {
  public static final int[] M_PORTS = {4,5};
  public static final int[] ENC_PORTS = {6,7};
  public static TalonSRX angle = new TalonSRX(M_PORTS[0]);
  public static Spark intake = new Spark(M_PORTS[1]);
  private static final double P = 0;

  private static final double I = 0;

  private static final double D = 0;

  public static Encoder angEnc = new Encoder(ENC_PORTS[0], ENC_PORTS[1]);

  public static final double MIN_POS = 0;
  public static final double MAX_POS = 0;

  public static final double inSpeed = 0;


  public double setpoint = 0;


  

  
  public IntakeSystem() {
     setpoint = 0;
     angle.configFactoryDefault();
     
 
    angle.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
 
     angle.configContinuousCurrentLimit(10);
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
    
    public void takeIn(){
        intake.setSpeed(1);
    }
    public void disable()
    {
        angle.set(ControlMode.PercentOutput, 0);
        intake.setSpeed(0);
    }
    public void moveTo(double input)
    {
        ang.set(ControlMode.MotionMagic, input);
        setpoint = input;
    }
    public void moveInc(posDiff){
        if (limited)
        if (getPos() > (MAX_POS) && diff > 0)
            diff = 0;
        else if (getPos() < (MIN_POS) && diff < 0)
            diff = 0;
    moveTo(setpoint + diff);
    }
    public void periodic(){
        angle.set(ControlMode.MotionMagic, setpoint);
    }
}
