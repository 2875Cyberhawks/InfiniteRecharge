package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.controller.PIDController;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpiutil.math.MathUtil;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;

public class ShootSystem extends SubsystemBase{

  private static final int [] E_PORTS = {4, 5};

  private static final int [] M_PORTS = {2, 3, 0};

  private static final double P = .4;// 2:1 -> N: {.4, 0, .013, -.13}, S: {.27, 0, .014, .11}

  private static final double I = 0;

  private static final double D = .008;//.0125 .45

  public static SimpleMotorFeedforward fSal= new SimpleMotorFeedforward(0, .22);
  public static SimpleMotorFeedforward fNick = new SimpleMotorFeedforward(0, .22);

  public static Encoder enc = new Encoder(E_PORTS[0], E_PORTS[1]);

  public static TalonSRX sal = new TalonSRX(M_PORTS[0]);

  public static TalonSRX nick = new TalonSRX(M_PORTS[1]); 

  public static Spark feed = new Spark(M_PORTS[2]);

  public double setpoint = 0;

  public double dPP = 1.0 / 2048.0;

  public PIDController pidSal = new PIDController(P, I, D);//.23, I, .008);

  public PIDController pidNick = new PIDController(P, I, D);

  public Timer time = new Timer();

  public boolean backwards = false;

  public double prevCur = 0;

  public double fSpeed = 0;
  public ShootSystem() {
    fSpeed = 0;

    sal.configFactoryDefault();
    nick.configFactoryDefault();

    sal.configContinuousCurrentLimit(40);
    sal.enableCurrentLimit(true);

    sal.configNominalOutputForward(0);
    sal.configNominalOutputReverse(0);
    sal.configPeakOutputForward(1);
    sal.configPeakOutputReverse(-1);
    
    nick.configContinuousCurrentLimit(40);
    nick.enableCurrentLimit(true);
    
    nick.configNominalOutputForward(0);
    nick.configNominalOutputReverse(0);
    nick.configPeakOutputForward(1);
    nick.configPeakOutputReverse(-1);

    setpoint = 0;

    pidSal.setTolerance(1);
    pidNick.setTolerance(1);
    System.out.println(fSal.calculate(44));
    System.out.println(fNick.calculate(27));

    enc.setDistancePerPulse(dPP);
    time.start();

  }

  public void periodic() {
    if(backwards){
      sal.set(ControlMode.PercentOutput, -.4);
      nick.set(ControlMode.PercentOutput, -.4);
    }
    else {
      sal.set(ControlMode.PercentOutput, MathUtil.clamp((pidSal.calculate(enc.getRate(), setpoint) + fSal.calculate(setpoint)) / 12, -1.0 , 1.0));
      nick.set(ControlMode.PercentOutput, MathUtil.clamp((pidNick.calculate(enc.getRate(), setpoint) + fNick.calculate(setpoint)) / 12, -1.0, 1.0));
    }
    //sal.set(ControlMode.PercentOutput, .5);
    //nick.set(ControlMode.PercentOutput, .5);

    feed.set(fSpeed);
    Robot.atSpeed = atSetpoint();
    prevCur = avgCur();

    SmartDashboard.putNumber("s volt", sal.getMotorOutputVoltage());
    SmartDashboard.putNumber("n volt", nick.getMotorOutputVoltage());
    SmartDashboard.putBoolean("s at setpoint", pidSal.atSetpoint());
    SmartDashboard.putBoolean("n at setpoint", pidNick.atSetpoint());
    SmartDashboard.putNumber("shoot spd", enc.getRate());
    SmartDashboard.putNumber("set", setpoint);
    SmartDashboard.putNumber("s err", pidSal.getPositionError());
    SmartDashboard.putNumber("n err", pidNick.getPositionError());
    SmartDashboard.putNumber("s curr", sal.getStatorCurrent());
    SmartDashboard.putNumber("n curr", nick.getStatorCurrent());
    //System.out.println(time.get() + " " + pidSal.getPositionError() + " " + pidNick.getPositionError());
  }

  public void stop() {
    sal.set(ControlMode.PercentOutput, 0);
    nick.set(ControlMode.PercentOutput, 0);
    feed.set(0);
  }

  public void setSetpoint(double s){
    setpoint = s;
  }

  public void setFeed(double input){
    fSpeed = input;
  }

  public void setBackwards(boolean back) {
    backwards = back;
  }

  public double avgCur() {
    return (sal.getStatorCurrent() + nick.getStatorCurrent()) / 2;
  }

  public boolean atSetpoint(){
    return pidSal.atSetpoint() && pidNick.atSetpoint() && prevCur - avgCur() < 2;
  }

}
