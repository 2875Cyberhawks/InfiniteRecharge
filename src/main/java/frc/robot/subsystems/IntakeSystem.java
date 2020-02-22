
// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import edu.wpi.first.wpilibj.Encoder;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import edu.wpi.first.wpilibj.controller.PIDController;
// import com.ctre.phoenix.motorcontrol.ControlMode;
// import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpiutil.math.MathUtil;
// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.Spark;
// public class IntakeSystem extends SubsystemBase {
//   public static final int[] M_PORTS = {4,5};
//   public static final int[] ENC_PORTS = {6,7};
//   public static Spark angle = new Spark(M_PORTS[0]);
//   public static Spark intake = new Spark(M_PORTS[1]);
//   private static final double P = 0;

//   private static final double I = 0;

//   private static final double D = 0;

//   public static Encoder angEnc = new Encoder(ENC_PORTS[0], ENC_PORTS[1]);


//   public static final double inSpeed = 0;


//   public double setpoint = 0;



//   public double dPP = 1.0 / 2048.0;

//   public PIDController PIDang = new PIDController(P,I,D);

  
//   public IntakeSystem() {
     
//   }

//   @Override
//   public void periodic() {
//     angle.set()
//   }
// }
