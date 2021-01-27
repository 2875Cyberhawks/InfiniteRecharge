
package auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;

public class SixBall extends SequentialCommandGroup {
  
  public SixBall() { //testing github with 2 whole computers!!!
    super(new Shoot(3), new MovePath(/*add path here*/), new PickUp(), new PickUp(), new PickUp(), 
    new turnTo(169.8725527885), new Align(), new Shoot(3));
  }
}
