package com.deku.eastwardjourneys.common.blocks;

import com.deku.eastwardjourneys.common.blockEntities.ShojiScreenBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import javax.annotation.Nullable;

import static com.deku.eastwardjourneys.common.blocks.ModBlockStateProperties.HAS_SHOJI;


public class SmallShojiScreen extends AbstractShojiScreen {
    public SmallShojiScreen(ShojiScreenBlockEntity.FrameType type, ShojiScreenBlockEntity.WoodColor color) {
        super(type, color);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH).setValue(HAS_SHOJI, false));
    }

    /**
     * Sets the correct state for the block upon its placement.
     * Designates the lower half of the block with a block state so that we can differentiate it from the top in other functions.
     *
     * @param blockPlaceContext Usage context of the block as it is placed into the level
     * @return Updated state of the block that was placed.
     */
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockPos position = blockPlaceContext.getClickedPos();
        Level level = blockPlaceContext.getLevel();
        if (position.getY() < level.getMaxBuildHeight() - 1 && blockPlaceContext.getLevel().getBlockState(position.above()).canBeReplaced(blockPlaceContext)) {
            return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection());
        } else {
            return null;
        }
    }

    /**
     * Places the block into the world.
     *
     * @param level Level the block is being placed in
     * @param position Position the block is being placed on
     * @param blockState State of the block to be placed
     * @param entity The entity placing the block
     * @param itemStack The stack of items that the block may be originating from
     */
    @Override
    public void setPlacedBy(Level level, BlockPos position, BlockState blockState, LivingEntity entity, ItemStack itemStack) {
        super.setPlacedBy(level, position, blockState, entity, itemStack);
    }

    /**
     * Determines whether the block can survive in the current position.
     * If the current block being checked is the lower half, ensures that it is being placed on valid, sturdy ground.
     * If the current block being checked is the upper half, ensures that the block underneath it is the lower half of the object.
     *
     * @param blockState State of the block being checked
     * @param levelReader Reader for the level the block is in
     * @param position Position of the block being checked
     * @return Whether the block can survive in its current position
     */
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos position) {
        BlockPos blockpos = position.below();
        return !levelReader.isEmptyBlock(blockpos);
    }

    /**
     * Overrides the base block's state container so that we can include our new block state.
     * This allows us to create a block that is made up of two halves and takes up two positions in the world. The lower and top halves.
     *
     * @param builder The builder for the state container
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING).add(HAS_SHOJI);
    }
}
