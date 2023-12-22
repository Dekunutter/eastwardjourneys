package com.deku.eastwardjourneys.common.blocks.maple;

import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.material.PushReaction;

public class PottedMapleSapling extends FlowerPotBlock {
    public PottedMapleSapling() {
        super(ModBlockInitializer.MAPLE_SAPLING.get(), Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(new ResourceLocation("eastwardjourneys:maple_sapling"), () -> this);
    }
}
