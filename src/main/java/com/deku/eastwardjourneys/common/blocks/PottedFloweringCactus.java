package com.deku.eastwardjourneys.common.blocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.material.PushReaction;

public class PottedFloweringCactus extends FlowerPotBlock {
    public PottedFloweringCactus() {
        super(ModBlockInitializer.FLOWERING_CACTUS.get(), Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(new ResourceLocation("eastwardjourneys:flowering_cactus"), () -> this);
    }
}
