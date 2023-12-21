package com.example.redstone_reimagined_renovations.CustomItemClasses;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InfiniteWater extends BucketItem {
    public InfiniteWater(Settings settings) {
        super(Fluids.WATER, settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        HitResult result = playerEntity.raycast(5.0, 1.0F, false);

        if (!world.isClient) {
            BlockPos targetBlockPos = ((BlockHitResult) result).getBlockPos();
            if (world.getBlockState(targetBlockPos) == Blocks.AIR.getDefaultState()) {
                world.setBlockState(targetBlockPos, Blocks.WATER.getDefaultState());
            } else if (!world.getBlockState(targetBlockPos).get(Properties.WATERLOGGED)) {
                world.setBlockState(targetBlockPos, world.getBlockState(targetBlockPos).with(Properties.WATERLOGGED, true));
            }
        }

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
