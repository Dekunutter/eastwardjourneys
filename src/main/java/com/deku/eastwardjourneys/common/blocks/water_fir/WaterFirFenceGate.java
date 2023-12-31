package com.deku.eastwardjourneys.common.blocks.water_fir;

import com.deku.eastwardjourneys.common.blocks.ModWoodType;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class WaterFirFenceGate extends FenceGateBlock {
    public WaterFirFenceGate() {
        super(ModWoodType.WATER_FIR, Properties.of().strength(2.0f, 3.0f).mapColor(MapColor.TERRACOTTA_RED).sound(SoundType.WOOD).ignitedByLava().instrument(NoteBlockInstrument.BASS));
    }
}
