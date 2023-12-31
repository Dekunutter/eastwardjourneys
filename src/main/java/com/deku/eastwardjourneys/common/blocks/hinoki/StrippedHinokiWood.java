package com.deku.eastwardjourneys.common.blocks.hinoki;

import com.deku.eastwardjourneys.common.blocks.AbstractWoodenBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class StrippedHinokiWood extends AbstractWoodenBlock {
    public StrippedHinokiWood() {
        super(Properties.of().strength(2.0f).mapColor(MapColor.WOOD).ignitedByLava().sound(SoundType.WOOD).instrument(NoteBlockInstrument.BASS));
    }
}
