package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;

public class SalSystem extends PIDSubsystem {

  private static final double P = 0;

  private static final double I = 0;

  private static final double D = 0;

  private static final double T = 0;

  public SimpleMotorFeedforward f = new SimpleMotorFeedforward(0, 0);

  private static final int [] E_PORTS = {0, 1};

  private static final int M_PORT = 2;

  public static Encoder enc = new Encoder(E_PORTS[0], E_PORTS[1]);

  public static Spark sal = new Spark(M_PORT);

  public double setpoint = 0;

  public final double MAX_SPD = 18730 * 4;//inaccurate; change
  
  public SalSystem() {
    super(new PIDController(P, I, D));
    getController().setTolerance(0, T);
    setSetpoint(0);
  }

  
  public void useOutput(double output, double setpoint) {
    sal.setVoltage(output + f.calculate(setpoint));
  }

  
  public double getMeasurement() {
    return enc.getRate();
  }
}
