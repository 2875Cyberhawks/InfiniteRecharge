
package auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;

public class RedLayout extends SequentialCommandGroup {
  
  public RedLayout() {
    //TurnTo IS NOT WORKING not relevent to the robot NEED TO FIX OR THIS IS USELESS 
    super(new MoveDist(90), new TurnTo(-26.56505118),new MoveDist(67.08203932), new TurnTo(-71.56505118), new MoveDist(94.86832981),new TurnTo(0),new MoveDist(150));
    //new parameters for MoveDist constiting of f and tol 
  }
}