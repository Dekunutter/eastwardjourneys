package com.deku.eastwardjourneys.common.blocks.hinoki;

import com.deku.eastwardjourneys.common.blocks.ModBlockSetType;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.material.PushReaction;

public class HinokiButton extends ButtonBlock {
    public HinokiButton() {
        super(ModBlockSetType.HINOKI, 30, Properties.of().noCollission().strength(0.5f).pushReaction(PushReaction.DESTROY));
    }
}
