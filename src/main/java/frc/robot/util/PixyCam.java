package frc.robot.util;

import io.github.pseudoresonance.pixy2api.links.SPILink;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

import java.util.ArrayList;

public class PixyCam {

    private Pixy2 pixy;

    public PixyCam() {
        pixy = Pixy2.createInstance(new SPILink());
        pixy.init();
    }

    public Block getBlock(){
        int blockCount = pixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 25);
        if (blockCount <= 0) 
			return null;
        ArrayList<Block> blocks = pixy.getCCC().getBlocks();
        Block largestBlock = null;
        for (Block block : blocks){
			if (largestBlock == null) 
				largestBlock = block;
			else if (block.getWidth() > largestBlock.getWidth()) 
                largestBlock = block;
        }
		return largestBlock;
    }
}
