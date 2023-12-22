package com.deku.eastwardjourneys.common.blocks.hinoki;

import com.deku.eastwardjourneys.common.features.ModTreeFeatures;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.Optional;

public class HinokiSapling extends SaplingBlock {
    public HinokiSapling() {
        super(
            new TreeGrower("hinoki", Optional.empty(), Optional.of(ModTreeFeatures.HINOKI), Optional.of(ModTreeFeatures.HINOKI_BEES)),
            Properties.of().mapColor(MapColor.PLANT).noCollission().pushReaction(PushReaction.DESTROY).randomTicks().instabreak().sound(SoundType.GRASS)
        );
    }
}
