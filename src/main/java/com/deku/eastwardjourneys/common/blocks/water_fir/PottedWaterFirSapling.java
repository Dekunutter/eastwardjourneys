package com.deku.eastwardjourneys.common.blocks.water_fir;

import com.deku.eastwardjourneys.common.blocks.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.material.PushReaction;

public class PottedWaterFirSapling extends FlowerPotBlock {
    public PottedWaterFirSapling() {
        super(ModBlocks.MAPLE_SAPLING, Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
        // maybe if I do something like https://github.com/Tropicraft/Tropicraft/blob/e5d50a20cb027f14870d1789ea5e5b643b1ebbc4/src/main/java/net/tropicraft/core/common/item/TropicraftItems.java#L696 to init my flower pot items in the item register instead of the block register it might help with the incompatibility?
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(new ResourceLocation("eastwardjourneys:water_fir_sapling"), () -> this);
    }
}
