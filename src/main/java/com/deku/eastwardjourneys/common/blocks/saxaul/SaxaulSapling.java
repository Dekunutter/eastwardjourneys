package com.deku.eastwardjourneys.common.blocks.saxaul;

import com.deku.eastwardjourneys.common.features.ModTreeFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.Optional;

public class SaxaulSapling extends SaplingBlock {
    public SaxaulSapling() {
        super(
            new TreeGrower("saxaul", 0.2F, Optional.empty(), Optional.empty(), Optional.of(ModTreeFeatures.SAXAUL), Optional.of(ModTreeFeatures.LARGE_SAXAUL), Optional.empty(), Optional.empty()),
            Properties.of().mapColor(MapColor.PLANT).noCollission().pushReaction(PushReaction.DESTROY).randomTicks().instabreak().sound(SoundType.GRASS)
        );
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos position) {
        return state.is(BlockTags.DIRT) || state.is(Blocks.FARMLAND) || state.is(BlockTags.SAND) || state.is(Blocks.TERRACOTTA);
    }
}
