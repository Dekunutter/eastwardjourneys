package com.deku.eastwardjourneys.common.blocks.water_fir;

import com.deku.eastwardjourneys.common.features.ModTreeFeatures;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.Optional;

public class WaterFirSapling extends SaplingBlock {
    public WaterFirSapling() {
        super(
            new TreeGrower("water_fir", Optional.of(ModTreeFeatures.MEGA_WATER_FIR), Optional.of(ModTreeFeatures.WATER_FIR), Optional.of(ModTreeFeatures.WATER_FIR_BEES)),
            Properties.of().mapColor(MapColor.PLANT).noCollission().pushReaction(PushReaction.DESTROY).randomTicks().instabreak().sound(SoundType.GRASS)
        );
    }
}
