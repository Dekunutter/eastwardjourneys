package com.deku.eastwardjourneys.common.blockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class SmallShojiScreenBlockEntity extends AbstractShojiScreenBlockEntity {
    public SmallShojiScreenBlockEntity(BlockPos position, BlockState state) {
        super(ModBlockEntityType.SMALL_SHOJI_SCREEN_BLOCK_DATA, position, state);
    }

    public SmallShojiScreenBlockEntity(BlockPos position, BlockState state, AbstractShojiScreenBlockEntity.WoodColor color) {
        super(ModBlockEntityType.SMALL_SHOJI_SCREEN_BLOCK_DATA, position, state, color);
    }
}
