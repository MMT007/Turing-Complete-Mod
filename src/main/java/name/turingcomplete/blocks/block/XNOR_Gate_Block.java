package name.turingcomplete.blocks.block;

import name.turingcomplete.blocks.AbstractLogicGate;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class XNOR_Gate_Block extends AbstractLogicGate {

    public XNOR_Gate_Block(Settings settings) {
        super(settings);
    }

    @Override
    public boolean gateConditionsMet(BlockState thisBlockState, World world, BlockPos pos)
    {
        boolean left = getSideInputLevel(thisBlockState, world, pos,0) > 0;
        boolean right = getSideInputLevel(thisBlockState, world, pos, 1) > 0;
        return left == right;
    }

    @Override
    public boolean supportsSideDirection() {
        return true;
    }

    @Override
    public boolean supportsBackDirection() {
        return false;
    }
}