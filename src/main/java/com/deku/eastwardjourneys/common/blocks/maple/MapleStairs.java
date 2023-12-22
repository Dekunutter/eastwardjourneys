package com.deku.eastwardjourneys.common.blocks.maple;

import com.deku.eastwardjourneys.common.blocks.AbstractWoodenStairsBlock;
import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;

public class MapleStairs extends AbstractWoodenStairsBlock {
    public MapleStairs() {
        super(ModBlockInitializer.MAPLE_PLANKS.get().defaultBlockState(), Properties.ofLegacyCopy(ModBlockInitializer.MAPLE_PLANKS.get()));
    }
}
