package com.deku.eastwardjourneys.common.blockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class ShojiScreenBlockEntity extends AbstractShojiScreenBlockEntity {
    private FrameType type = FrameType.STANDARD;

    public enum FrameType {
        STANDARD,
        GRIDED,
        GRIDED_HEAVY
    }

    public ShojiScreenBlockEntity(BlockPos position, BlockState state) {
        super(ModBlockEntityType.SHOJI_SCREEN_BLOCK_DATA, position, state);
    }

    public ShojiScreenBlockEntity(BlockPos position, BlockState state, FrameType type, WoodColor color) {
        super(ModBlockEntityType.SHOJI_SCREEN_BLOCK_DATA, position, state, color);
        this.type = type;
    }

    /**
     * Gets the type of frame this block entity represents
     *
     * @return Type of frame
     */
    public FrameType getFrameType() {
        return type;
    }
}
