package com.deku.eastwardjourneys.common.blocks.saxaul;

import com.deku.eastwardjourneys.common.blocks.ModBlockSetType;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.material.PushReaction;

public class SaxaulButton extends ButtonBlock {
    public SaxaulButton() {
        super(ModBlockSetType.SAXAUL, 30, Properties.of().noCollission().strength(0.5f).pushReaction(PushReaction.DESTROY));
    }
}
