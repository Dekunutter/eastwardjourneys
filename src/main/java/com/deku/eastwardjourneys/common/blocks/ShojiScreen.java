package com.deku.eastwardjourneys.common.blocks;

import com.deku.eastwardjourneys.common.blockEntities.ShojiScreenBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

import static com.deku.eastwardjourneys.common.blocks.ModBlockStateProperties.HAS_SHOJI;

public class ShojiScreen extends AbstractShojiScreen {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public ShojiScreen(ShojiScreenBlockEntity.FrameType type, ShojiScreenBlockEntity.WoodColor color) {
        super(type, color);
        registerDefaultState(defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(FACING, Direction.NORTH).setValue(HAS_SHOJI, false));

    }

    /**
     * Updates the shape of this block.
     * If the block doesn't survive it is replaced with an air block, otherwise its shape is updated.
     * Ensures that if either block is destroyed, then the other half cannot survive in the world either since they make up a single object.
     *
     * @param blockState State of the block having its shape updated
     * @param direction Direction we are going to update the shape in
     * @param otherBlockState State of the other block in the check
     * @param levelAccessor Accessor for the level that the block is being updated in
     * @param position Position of the block having its shape updated
     * @param otherPosition Position of the other block in the check
     * @return Updated block state of the current block
     */
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState otherBlockState, LevelAccessor levelAccessor, BlockPos position, BlockPos otherPosition) {
        DoubleBlockHalf doubleblockhalf = blockState.getValue(HALF);
        if (direction.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (direction == Direction.UP) || otherBlockState.is(this) && otherBlockState.getValue(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !blockState.canSurvive(levelAccessor, position) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, otherBlockState, levelAccessor, position, otherPosition);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
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
            return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(FACING, blockPlaceContext.getHorizontalDirection());
        } else {
            return null;
        }
    }

    /**
     * Places the block into the world if the position above is also free so that the top block can be generated also.
     *
     * @param level Level the block is being placed in
     * @param position Position the block is being placed on
     * @param blockState State of the block to be placed
     * @param entity The entity placing the block
     * @param itemStack The stack of items that the block may be originating from
     */
    public void setPlacedBy(Level level, BlockPos position, BlockState blockState, LivingEntity entity, ItemStack itemStack) {
        level.setBlock(position.above(), blockState.setValue(HALF, DoubleBlockHalf.UPPER), 3);
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
        BlockState blockstate = levelReader.getBlockState(blockpos);
        return blockState.getValue(HALF) == DoubleBlockHalf.LOWER ? !levelReader.isEmptyBlock(blockpos) : blockstate.is(this);
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
        builder.add(HALF, FACING, HAS_SHOJI);
    }

    /**
     * Ties a block entity to this block
     *
     * @param position Position of the block
     * @param state State of the block
     * @return The block entity tied to this block
     */
    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos position, BlockState state) {
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            return new ShojiScreenBlockEntity(position, state, type, color);
        }
        return null;
    }

    /**
     * Gets the block entity associated with this block
     * Since this is a double-height block and we need to associate all block entity data and rendering just once to both halves, we use this helper method to fetch the block entity
     * It allows us to associate one block entity for both halves
     *
     * @param state State of the block
     * @param position Position of the block
     * @param level Level in which the block exists
     * @return Block entity associated to the given block
     */
    public BlockEntity getAssociatedBlockEntity(BlockState state, BlockPos position, Level level) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            BlockPos belowPosition = position.below();
            return level.getBlockEntity(belowPosition);
        } else {
            return level.getBlockEntity(position);
        }
    }

    /**
     * Called whenever this block is attacked by a player
     * Causes the block to drop its placed screen, if one is attached
     * If we are interacting with the upper half of this block, we grab the block entity from the lower half (the block it is associated with) and continue on with that - allowing us to have one entity to control both blocks
     *
     * @param state State of the block
     * @param level Level the block is in
     * @param position Position of the block
     * @param player Player attacking the block
     */
    @Override
    public void attack(BlockState state, Level level, BlockPos position, Player player) {
        BlockEntity blockEntity = getAssociatedBlockEntity(state, position, level);

        if (blockEntity instanceof ShojiScreenBlockEntity) {
            boolean result = ((ShojiScreenBlockEntity) blockEntity).popScreen();
            if (result) {
                level.playSound(player, position, SoundEvents.MOSS_CARPET_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
        }
    }

    /**
     * Logic that occurs when the player interacts with this block.
     * If the player is holding a shoji paper item and this frame is currently empty, they can place it into this frame.
     * If we are interacting with the upper half of this block, we grab the block entity from the lower half (the block it is associated with) and continue on with that - allowing us to have one entity to control both blocks
     *
     * @param state State of the block
     * @param level Level the block is in
     * @param position Position of the block
     * @param player Player that interacted with the block
     * @param hand Hand with which the player interacted with the block
     * @param hitResult hit result for this block
     * @return Result after interacting with this block
     */
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos position, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemStack = player.getItemInHand(hand);
        BlockEntity blockEntity = getAssociatedBlockEntity(state, position, level);

        return placeScreen(itemStack, blockEntity, level, position, player);
    }
}
