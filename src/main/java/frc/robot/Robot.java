
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.util.PixyCam;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;


public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  public static ShootSystem ss;
  public static DriveSystem ds;

  public static PixyCam ballPixy;
  public static PixyCam goalPixy;

  public static boolean inAuto = false;


  public static AHRS gyro;

  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

   // ss = new ShootSystem();
    ds = new DriveSystem();
    gyro = new AHRS(SPI.Port.kMXP); 
    //ballPixy = new PixyCam();
    //goalPixy = new PixyCam();
    gyro.reset();
  }

  public void robotPeriodic() {

  }

  

  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
    inAuto = true;
    gyro.reset();
  }

  
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  public void teleopInit() {
    inAuto = false;
    gyro.reset();//if robot is facing forwards at end of auto
    //ss.setDefaultCommand(new Shoot());
    ds.setDefaultCommand(new Drive());
  }

  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }


  public static double getAngle()
    {
        double gyAng = gyro.getAngle();

        while (gyAng < -180)
        {
            gyAng += 360;
        }
        while (gyAng > 180)
        {
            gyAng -= 360;
        }

        return gyAng;
    }
}
