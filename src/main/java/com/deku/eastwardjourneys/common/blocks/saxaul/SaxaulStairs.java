package com.deku.eastwardjourneys.common.blocks.saxaul;

import com.deku.eastwardjourneys.common.blocks.AbstractWoodenStairsBlock;
import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;

public class SaxaulStairs extends AbstractWoodenStairsBlock {
    public SaxaulStairs() {
        super(ModBlockInitializer.SAXAUL_PLANKS.get().defaultBlockState(), Properties.ofLegacyCopy(ModBlockInitializer.SAXAUL_PLANKS.get()));
    }
}
