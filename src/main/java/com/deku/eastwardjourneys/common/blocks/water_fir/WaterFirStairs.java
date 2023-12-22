package com.deku.eastwardjourneys.common.blocks.water_fir;

import com.deku.eastwardjourneys.common.blocks.AbstractWoodenStairsBlock;
import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;

public class WaterFirStairs extends AbstractWoodenStairsBlock {
    public WaterFirStairs() {
        super(ModBlockInitializer.WATER_FIR_PLANKS.get().defaultBlockState(), Properties.ofLegacyCopy(ModBlockInitializer.WATER_FIR_PLANKS.get()));
    }
}
