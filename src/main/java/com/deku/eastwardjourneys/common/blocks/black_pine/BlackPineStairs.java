package com.deku.eastwardjourneys.common.blocks.black_pine;

import com.deku.eastwardjourneys.common.blocks.AbstractWoodenStairsBlock;

import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;

public class BlackPineStairs extends AbstractWoodenStairsBlock {
    public BlackPineStairs() {
        super(ModBlockInitializer.BLACK_PINE_PLANKS.get().defaultBlockState(), Properties.ofLegacyCopy(ModBlockInitializer.BLACK_PINE_PLANKS.get()));
    }
}
