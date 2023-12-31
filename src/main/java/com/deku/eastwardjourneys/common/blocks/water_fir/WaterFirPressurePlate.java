package com.deku.eastwardjourneys.common.blocks.water_fir;

import com.deku.eastwardjourneys.common.blocks.ModBlockSetType;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class WaterFirPressurePlate extends PressurePlateBlock {
    public WaterFirPressurePlate() {
        super(ModBlockSetType.WATER_FIR, Properties.of().noCollission().strength(0.5F).mapColor(MapColor.TERRACOTTA_RED).ignitedByLava().sound(SoundType.WOOD).instrument(NoteBlockInstrument.BASS).ignitedByLava());
    }
}
