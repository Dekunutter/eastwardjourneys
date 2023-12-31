package com.deku.eastwardjourneys.common.blocks.maple;

import com.deku.eastwardjourneys.common.blocks.ModBlockSetType;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.material.PushReaction;

public class MapleButton extends ButtonBlock {
    public MapleButton() {
        super(ModBlockSetType.MAPLE, 30, Properties.of().noCollission().strength(0.5f).pushReaction(PushReaction.DESTROY));
    }
}
