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
    public static boolean getDPadUp(){
        if (xbox.getPOV() > 0 && ((xbox.getPOV() > 270 && xbox.getPOV() < 360) || (xbox.getPOV()>= 0 && < 90)))
            return true;
        else
            return false;
    }
    public static boolean getDPadDown(){
        if (xbox.getPOV() > 0 && (xbox.getPOV()> 90 && xbox.getPOV() <270))
            return true;
        else
            return false;
    public static double getTiltation(){//intake tilt
        return Math.abs(xbox.getY(Hand.kright)) > .3 ? xbox.getY() : 0;
    }        
}
