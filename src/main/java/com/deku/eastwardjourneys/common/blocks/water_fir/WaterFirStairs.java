package com.deku.eastwardjourneys.common.blocks.water_fir;

import com.deku.eastwardjourneys.common.blocks.AbstractWoodenStairsBlock;
import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class WaterFirStairs extends AbstractWoodenStairsBlock {
    public WaterFirStairs() {
        super(ModBlockInitializer.WATER_FIR_PLANKS.get().defaultBlockState(), Properties.of().strength(2.0f, 3.0f).mapColor(MapColor.TERRACOTTA_RED).ignitedByLava().sound(SoundType.WOOD).instrument(NoteBlockInstrument.BASS));
    }
}
