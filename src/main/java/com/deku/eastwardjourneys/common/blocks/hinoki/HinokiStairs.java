package com.deku.eastwardjourneys.common.blocks.hinoki;

import com.deku.eastwardjourneys.common.blocks.AbstractWoodenStairsBlock;
import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;

public class HinokiStairs extends AbstractWoodenStairsBlock {
    public HinokiStairs() {
        super(ModBlockInitializer.HINOKI_PLANKS.get().defaultBlockState(), Properties.ofLegacyCopy(ModBlockInitializer.HINOKI_PLANKS.get()));
    }
}
