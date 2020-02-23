
/*package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.util.PixyCam;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import frc.robot.subsystems.DriveSystem;
import edu.wpi.first.wpiutil.math.MathUtil;
import edu.wpi.first.wpilibj.DriverStation


public class ColorWheel extends CommandBase {
  public PixyCam cam;
  public String signature;
  public ColorWheel() {
  }

 
  @Override
  public void initialize() {
  
    pixy = Pixy2.createInstance(new SPILin(k)); // Creates a new Pixy2 camera using SPILink
		pixy.init(); // Initializes the camera and prepares to send/receive data
		pixy.setLamp((byte) 1, (byte) 1); // Turns the LEDs on
		pixy.setLED(255, 255, 255); // Sets the RGB LED to full white
  }

  
  @Override
  public void execute() {
    String gameData = '';
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0)
{
  switch (gameData.charAt(0))
  {
    case 'B' :
      signature = 'CCC_SIG2'
      break;
    case 'G' :
      signature = 'CCC_SIG3'
      break;
    case 'R' :
      signature = 'CCC_SIG4'
    break;
    case 'Y' :
      signature = 'CCC_SIG5'
      break;
    default :
      //NO DATA BAAAAAAAAAD
      break;
  }
  int blockCount = cam.getPixy().getCCC().getBlocks(false, signature, 25);
		if (blockCount <= 0) {
    }
    ArrayList<Block> blocks = cam.getPixy().getCCC().getBlocks();
		Block largestBlock = null;
		if (blocks == null) {
			
			return;
		}
		for (Block block : blocks) {
			if (block.getSignature() == signature) {
				if (largestBlock == null) {
					largestBlock = block;
				} else if (block.getWidth() > largestBlock.getWidth()) {
					largestBlock = block;
				}
      }
      //From here, manipulate the block
} 
  }

   @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}*/ 
//john stop copying random shit from the internet