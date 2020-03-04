package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class IO {

    private static Joystick joy = new Joystick(0);

    private static XboxController xbox = new XboxController(1);

    public static boolean getShoot() {
        return xbox.getBumper(Hand.kRight);
    }

    public static boolean getA() {
        return xbox.getAButtonPressed();
    }

    public static boolean getY() {
        return xbox.getYButtonPressed();
    }

    public static boolean getX() {
        return xbox.getXButtonPressed();
    }

    public static boolean getB() {
        return xbox.getBButtonPressed();
    }

    public static double getForward() {
        return Math.abs(joy.getY()) > .03 ? -joy.getY() : 0;
    }

    public static double getTurn() {
        return Math.abs(joy.getZ()) > .3 ? joy.getZ() : 0;
    }
    public static boolean getDPadUp() {
        return xbox.getPOV() == 0;
    }
    public static boolean getDPadDown() {
        return xbox.getPOV() == 180;
    }
    public static double getTilt() {//intake tilt
        return Math.abs(xbox.getY(Hand.kRight)) > .1 ? xbox.getY() : 0;
    }
    
    public static double getIntake() {
        return Math.abs(xbox.getY(Hand.kLeft)) > .1 ? xbox.getY() : 0;
    }
}
