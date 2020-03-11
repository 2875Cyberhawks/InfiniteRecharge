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
import frc.robot.Robot;

public class ShootSystem extends SubsystemBase{

  private static final int [] E_PORTS = {4, 5, 6, 7};

  private static final int [] M_PORTS = {1, 3, 2};

  private static final double PS = .04;

  private static final double IS = 0;

  private static final double DS = .0002;

  public static SimpleMotorFeedforward ffs = new SimpleMotorFeedforward(0, .152);

  public static Encoder encS = new Encoder(E_PORTS[0], E_PORTS[1]);

  public static Encoder encF = new Encoder(E_PORTS[2], E_PORTS[3]);

  public static TalonSRX sal = new TalonSRX(M_PORTS[0]);

  public static TalonSRX nick = new TalonSRX(M_PORTS[1]); 

  public static TalonSRX feed = new TalonSRX(M_PORTS[2]);

  public static final double PF = .05;

  public static final double IF = 0;

  public static final double DF = .0001;

  public static SimpleMotorFeedforward fff = new SimpleMotorFeedforward(0, .58);

  public double setpointS = 0;

  public double setpointF = 0;

  public double dPP = 1.0 / 2048.0;

  public PIDController pidS = new PIDController(PS, IS, DS);

  public PIDController pidF = new PIDController(PF, IF, DF);

  public boolean backwardsS = false;

  public boolean backwardsF = false;

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

    setpointS = 0;
    setpointF = 0;

    pidS.setTolerance(1);
    pidF.setTolerance(1);

    encS.setDistancePerPulse(dPP);
    encF.setDistancePerPulse(dPP);
  }

  public void periodic() {
    if(backwardsS){
      sal.set(ControlMode.PercentOutput, .4);
      nick.set(ControlMode.PercentOutput, .4);
    }else{ 
      sal.set(ControlMode.PercentOutput, -MathUtil.clamp((pidS.calculate(encS.getRate(), setpointS) + ffs.calculate(setpointS)) / 12, -1.0 , 1.0));
      nick.set(ControlMode.PercentOutput, -MathUtil.clamp((pidS.calculate(encS.getRate(), setpointS) + ffs.calculate(setpointS)) / 12, -1.0, 1.0));
    }

    if(backwardsF)
      feed.set(ControlMode.PercentOutput, .4);
    else
      feed.set(ControlMode.PercentOutput, MathUtil.clamp((pidF.calculate(encF.getRate(), setpointF) + fff.calculate(setpointF)) / 12, -1.0, 1.0));
    
    //sal.set(ControlMode.PercentOutput, .5);
    //nick.set(ControlMode.PercentOutput, .5);

    Robot.atSpeed = atSetpoint();
    prevCur = avgCur();
    SmartDashboard.putNumber("f spd", encF.getRate());

    /*SmartDashboard.putNumber("s volt", sal.getMotorOutputVoltage());
    SmartDashboard.putNumber("n volt", nick.getMotorOutputVoltage());
    SmartDashboard.putBoolean("at setpoint", pid.atSetpoint());
    SmartDashboard.putNumber("shoot spd", enc.getRate());
    SmartDashboard.putNumber("set", setpoint);*/
    SmartDashboard.putNumber("shoot err", pidS.getPositionError());
    SmartDashboard.putNumber("feed err", pidF.getPositionError());/*
    SmartDashboard.putNumber("s curr", sal.getStatorCurrent());
    SmartDashboard.putNumber("n curr", nick.getStatorCurrent());
    //System.out.println(time.get() + " " + pidSal.getPositionError() + " " + pidNick.getPositionError());*/
  }

  public void stop() {
    sal.set(ControlMode.PercentOutput, 0);
    nick.set(ControlMode.PercentOutput, 0);
    feed.set(ControlMode.PercentOutput, 0);
  }

  public void setSetpointS(double s){
    setpointS = s;
  }

  public void setSetpointF(double s){
    setpointF = s;
  }

  public void setFeed(double input){
    fSpeed = input;
  }

  public void setBackwardsS(boolean back) {
    backwardsS = back;
  }

  public void setBackwardsF(boolean back) {
    backwardsF = back;
  }

  public double avgCur() {
    return (sal.getStatorCurrent() + nick.getStatorCurrent()) / 2;
  }

  public boolean atSetpoint(){
    return pidS.atSetpoint() && pidF.atSetpoint() && prevCur - avgCur() < 2;
  }

}
