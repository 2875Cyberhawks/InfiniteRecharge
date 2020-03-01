
package frc.robot.commands;

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



import edu.wpi.first.wpilibj2.command.CommandBase;

public class Climb extends CommandBase {

  public Climb() {
    addRequirements(Robot.cs);
  }

  @Override
  public void initialize() {
      Robot.cs.stop();
    }

  @Override
  public void execute() {
    if (IO.getDPadUP())
        Robot.cs.setSpeed(1);
      else if (IO.getDPadDown())
        Robot.cs.setSpeed(-1);
    if (IO.getA()){
      Robot.cs.toggle();
    }      
  }

  @Override
  public void end(boolean interrupted) {
  }

   @Override
  public boolean isFinished() {
    return false;
  }
}
