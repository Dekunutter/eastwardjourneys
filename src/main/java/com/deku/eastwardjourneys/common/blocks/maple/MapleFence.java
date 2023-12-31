package com.deku.eastwardjourneys.common.blocks.maple;

import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class MapleFence extends FenceBlock {
    public MapleFence() {
        super(Properties.of().strength(2.0f, 3.0f).mapColor(MapColor.WOOD).ignitedByLava().sound(SoundType.WOOD).instrument(NoteBlockInstrument.BASS));
    }
}
