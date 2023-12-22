package com.deku.eastwardjourneys.common.blocks.maple;

import com.deku.eastwardjourneys.common.features.ModTreeFeatures;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.Optional;

public class MapleSapling extends SaplingBlock {
    public MapleSapling() {
        super(
            new TreeGrower("maple", Optional.empty(), Optional.of(ModTreeFeatures.FANCY_MAPLE_TREE), Optional.of(ModTreeFeatures.FANCY_MAPLE_TREE_BEES)),
            Properties.of().mapColor(MapColor.PLANT).noCollission().pushReaction(PushReaction.DESTROY).randomTicks().instabreak().sound(SoundType.GRASS)
        );
    }
}
