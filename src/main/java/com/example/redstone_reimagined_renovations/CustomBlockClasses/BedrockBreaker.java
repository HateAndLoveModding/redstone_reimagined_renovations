package com.example.redstone_reimagined_renovations.CustomBlockClasses;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BedrockBreaker extends Block {
    private long originalTime;
    public BedrockBreaker(Settings settings) {
        super(settings);
    }
    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (world.isReceivingRedstonePower(pos)) {
            if (originalTime == 0) {
                originalTime = world.getTime();
            } else if (world.getTime() >= originalTime + 1000) {
                if (world.getBlockState(pos.down()).equals(Blocks.BEDROCK.getDefaultState())) {
                    world.setBlockState(pos.down(), Blocks.AIR.getDefaultState(), 3);
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
                }
                originalTime = 0;
            }
        }
    }
}
