package com.example.redstone_reimagined_renovations.CustomBlockClasses;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TntDuperBlock extends Block {
    private long lastTntPlacedTime;
    public TntDuperBlock(Settings settings) {
        super(settings);
    }
    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (world.isReceivingRedstonePower(pos)) {
            BlockPos tntPos = pos.down();
            long currentTime = world.getTime();
            if (currentTime - lastTntPlacedTime >= 20) {
                world.setBlockState(tntPos, Blocks.TNT.getDefaultState(), 3);
                lastTntPlacedTime = currentTime;
            }
        }
    }

}
