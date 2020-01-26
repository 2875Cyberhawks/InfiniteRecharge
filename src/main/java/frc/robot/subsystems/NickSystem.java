/* package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;

public class NickSystem extends PIDSubsystem {

  private static final double P = 0;

  private static final double I = 0;

 private static final double D = 0;

  private static final double T = .5;

  public SimpleMotorFeedforward f = new SimpleMotorFeedforward(0, 0);

  private static final int [] E_PORTS = {1, 2};

  private static final int M_PORT = 8;

  public static Encoder enc = new Encoder(E_PORTS[0], E_PORTS[1]);

  public static Spark nick = new Spark(M_PORT);
  
  public NickSystem() {
    super(new PIDController(P, I, D));
    getController().setTolerance(0, T);
    enc.setDistancePerPulse(0.00048828125); // 1 /2048
    setSetpoint(0);
  }

  
  public void useOutput(double output, double setpoint) {
    nick.setVoltage(output + f.calculate(setpoint));
  }

  
  public double getMeasurement() {
    return enc.getRate();
  }
}*/
