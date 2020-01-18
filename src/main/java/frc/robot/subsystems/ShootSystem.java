/*package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.PIDController;
// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.Spark;

public class ShootSystem extends SubsystemBase{

  private static final int [][] E_PORTS = {{0, 1},
                                          {2, 3}};

  private static final int [] M_PORTS = {4, 5};

  private static final double P = 0;

  private static final double I = 0;

  private static final double D = 0;

  private static final double F = 0;

  public static Encoder encSal = new Encoder(E_PORTS[0][0], E_PORTS[0][1]);

  public static Encoder encNick = new Encoder(E_PORTS[1][0], E_PORTS[1][1]);

  public static Spark sal = new Spark(M_PORTS[0]);

  public static Spark nick = new Spark(M_PORTS[1]);

  public double setpointS = 0;

  public double setpointN = 0;

  public final double MAX_SPD = 18730 * 4;

  public PIDController pidSal = new PIDController(P, I, D, F, encSal, sal);

  public PIDController pidNick = new PIDController(P, I, D, F, encNick, nick);

  public ShootSystem() {
    sal.configFactoryDefault();
    nick.configFactoryDefault();

    sal.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    nick.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

    sal.configContinuousCurrentLimit(10);
    sal.enableCurrentLimit(true);

    sal.configNominalOutputForward(0);
    sal.configNominalOutputReverse(0);
    sal.configPeakOutputForward(1);
    sal.configPeakOutputReverse(-1);
    sal.setIntegralAccumulator(0);
    sal.config_IntegralZone(0, 60);

    sal.config_kP(0, PS);
    sal.config_kI(0, IS); 
    sal.config_kD(0, DS);
    sal.config_kF(0, 0);
    
    nick.configContinuousCurrentLimit(10);
    nick.enableCurrentLimit(true);
    
    nick.configNominalOutputForward(0);
    nick.configNominalOutputReverse(0);
    nick.configPeakOutputForward(1);
    nick.configPeakOutputReverse(-1);
    nick.setIntegralAccumulator(0);
    nick.config_IntegralZone(0, 60);

    nick.config_kP(0, PN);
    nick.config_kI(0, IN); 
    nick.config_kD(0, DN);
    nick.config_kF(0, 0);

    setpointS = 0;
    setpointN = 0;

    sal.setSelectedSensorPosition(0);
    nick.setSelectedSensorPosition(0);

  }

  public void move() {
    // sal.set(ControlMode.Velocity, setpointS);
    // nick.set(ControlMode.Velocity, setpointN);
  }

  public void stop() {
    // sal.set(ControlMode.PercentOutput, 0);
    // nick.set(ControlMode.PercentOutput, 0);
  }

  public void setSetpoint(double s, double n){
    setpointS = s;
    setpointN = n;
  }

}*/
