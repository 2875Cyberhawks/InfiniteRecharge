package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IO {

    private static Joystick joy = new Joystick(0);

    private static XboxController xbox = new XboxController(1);

    public static int getShoot() {
        return xbox.getBumper(Hand.kRight) ? 1 : xbox.getBumper(Hand.kLeft) ? -1 : 0;
    }

    public static boolean getGoalAlign() {
        return xbox.getAButtonPressed();
    }

    public static boolean toggleRatchet() {
        return xbox.getYButtonPressed();
    }

    public static boolean getX() { //unused
        return xbox.getXButtonPressed();
    }

    public static boolean getBallAlign() {
        return xbox.getBButtonPressed();
    }

    public static double getForward() {
        SmartDashboard.putNumber("Forward: ",Math.abs(joy.getY()) > .03 ? -joy.getY() : 0 );
        return Math.abs(joy.getY()) > .03 ? -joy.getY() : 0;
    }

    public static double getTurn() {
        SmartDashboard.putNumber("Turn: ", Math.abs(joy.getZ()) > .3 ? joy.getZ() : 0);
        return Math.abs(joy.getZ()) > .3 ? joy.getZ() : 0;
    }
    public static int getClimb() {
        return xbox.getPOV() == 0 ? 1 : xbox.getPOV() == 180 ? -1 : 0;
    }
    public static int getTilt() {
        return joy.getRawButtonPressed(5) ? 1 : joy.getRawButtonPressed(3) ? -1 : 0;
    }
    
    public static double getIntake() {
        return Math.abs(xbox.getY(Hand.kLeft)) > .1 ? xbox.getY(Hand.kLeft) : 0;
    }

    public static double getElevator() {
        return Math.abs(xbox.getY(Hand.kRight)) > .1 ? xbox.getY(Hand.kRight) : 0;
    }

    public static boolean getTrigger(){
        return xbox.getBumper(Hand.kRight);
    }
}
