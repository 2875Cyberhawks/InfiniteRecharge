package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSystem extends SubsystemBase {

  public static final int[][] D_PORTS = {{0, 1},
                                         {2, 3},
                                         {4, 5}};

  public static final int[][] E_PORTS = {{6, 7},
                                         {8, 9}};
  
  private TalonSRX right = new TalonSRX(D_PORTS[0][1]);
  private VictorSPX rf1 = new VictorSPX(D_PORTS[1][1]);
  private VictorSPX rf2 = new VictorSPX(D_PORTS[2][1]);
  
  private TalonSRX left = new TalonSRX(D_PORTS[0][0]);
  private VictorSPX lf1 = new VictorSPX(D_PORTS[1][0]);
  private VictorSPX lf2 = new VictorSPX(D_PORTS[2][0]);

  private Encoder leftEnc = new Encoder(E_PORTS[0][0], E_PORTS[0][1]);

  private Encoder rightEnc = new Encoder(E_PORTS[1][0], E_PORTS[1][1]);

  private double lSpeed = 0;

  private double rSpeed = 0;

  public DriveSystem() {
    leftEnc.setDistancePerPulse(1.0/2048.0);
    rightEnc.setDistancePerPulse(1.0/2048.0);

    rf1.follow(right);
    rf2.follow(right);

    lf1.follow(left);
    lf2.follow(left);

    right.configFactoryDefault();
    rf1.configFactoryDefault();
    rf2.configFactoryDefault();

    right.configNominalOutputForward(0);
    rf1.configNominalOutputForward(0);
    rf2.configNominalOutputForward(0);

    right.configNominalOutputReverse(0);
    rf1.configNominalOutputReverse(0);
    rf2.configNominalOutputReverse(0);

    right.configPeakOutputForward(1.0);
    rf1.configPeakOutputForward(1.0);
    rf2.configPeakOutputForward(1.0);

    right.configPeakOutputReverse(-1.0);
    rf1.configPeakOutputReverse(-1.0);
    rf2.configPeakOutputReverse(-1.0);

    right.configPeakCurrentLimit(40);
    right.enableCurrentLimit(true);

    left.configFactoryDefault();
    lf1.configFactoryDefault();
    lf2.configFactoryDefault();

    left.configNominalOutputForward(0);
    lf1.configNominalOutputForward(0);
    lf2.configNominalOutputForward(0);

    left.configNominalOutputReverse(0);
    lf1.configNominalOutputReverse(0);
    lf2.configNominalOutputReverse(0);

    left.configPeakOutputForward(1.0);
    lf1.configPeakOutputForward(1.0);
    lf2.configPeakOutputForward(1.0);

    left.configPeakOutputReverse(-1.0);
    lf1.configPeakOutputReverse(-1.0);
    lf2.configPeakOutputReverse(-1.0);

    left.configPeakCurrentLimit(40);
    left.enableCurrentLimit(true);
  }

  public void periodic() {
    left.set(ControlMode.PercentOutput, lSpeed);
    right.set(ControlMode.PercentOutput, rSpeed);
  }

  public void setSpeed(double l, double r){
    lSpeed = l;
    rSpeed = r;
  }
  
}
