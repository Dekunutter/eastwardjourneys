package com.deku.eastwardjourneys.common.blocks.black_pine;

import com.deku.eastwardjourneys.common.features.ModTreeFeatures;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.Optional;

public class BlackPineSapling extends SaplingBlock {
    public BlackPineSapling() {
        // TODO: For black pines I want a tree grower that can be tree different forms, not just two. What do I do here?? Maybe I need to use AT  to make the final class not final and extend it but the functions are often private and the structure just isnt ideal to what I want to do sadly.....
        super(
            new TreeGrower("black_pine", 0.4F, Optional.empty(), Optional.empty(), Optional.of(ModTreeFeatures.BLACK_PINE), Optional.of(ModTreeFeatures.STRAIGHT_BLACK_PINE), Optional.empty(), Optional.empty()),
            Properties.of().mapColor(MapColor.PLANT).noCollission().pushReaction(PushReaction.DESTROY).randomTicks().instabreak().sound(SoundType.GRASS)
        );
    }
}
