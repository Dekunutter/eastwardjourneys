package com.deku.eastwardjourneys.common.blocks;

import com.deku.eastwardjourneys.common.blockEntities.AbstractShojiScreenBlockEntity;
import com.deku.eastwardjourneys.common.items.ShojiPaper;
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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


import static com.deku.eastwardjourneys.common.blocks.ModBlockStateProperties.HAS_SHOJI;

// TODO: Something is causing the shoji paper items to spawn into the world when reloaded even though they are still placed into the shoji screen. Essentially duplicating the item I think.
public abstract class AbstractShojiScreen extends Block implements EntityBlock, SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    // NOTE: Actual model is only 3px wide but extended to 10px to resolve pathfinding issues with thin double-block objects and entities
    protected static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D,  10.0D);
    protected static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape WEST_AABB = Block.box(6.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.box(0.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    protected AbstractShojiScreenBlockEntity.WoodColor color;

    public AbstractShojiScreen(AbstractShojiScreenBlockEntity.WoodColor color) {
        super(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).mapColor(MapColor.NONE).ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.GRASS));
        this.color = color;
    }

    /**
     * Gets the shape of the block depending on the state associated with this instance.
     * Extracts the shape from the designated AABBs.
     * This determines in what direction the block will be rendered, since it doesnt fill an entire block
     *
     * @param state State of this block
     * @param blockGetter Reader for information from this block
     * @param position Position of this block
     * @param selectionContext The context under which this block was selected
     * @return
     */
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos position, CollisionContext selectionContext) {
        Direction direction = state.getValue(FACING);
        switch(direction) {
            case EAST:
            default:
                return EAST_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            case NORTH:
                return NORTH_AABB;
        }
    }

    /**
     * Updates the shape of this block.
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
        return super.updateShape(blockState, direction, otherBlockState, levelAccessor, position, otherPosition);
    }

    /**
     * Sets the correct state for the block upon its placement.
     *
     * @param blockPlaceContext Usage context of the block as it is placed into the level
     * @return Updated state of the block that was placed.
     */
    @javax.annotation.Nullable
    public abstract BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext);

    /**
     * Places the block into the world.
     *
     * @param level Level the block is being placed in
     * @param position Position the block is being placed on
     * @param blockState State of the block to be placed
     * @param entity The entity placing the block
     * @param itemStack The stack of items that the block may be originating from
     */
    public void setPlacedBy(Level level, BlockPos position, BlockState blockState, LivingEntity entity, ItemStack itemStack) {
        super.setPlacedBy(level, position, blockState, entity, itemStack);
    }

    /**
     * Determines whether the block can survive in the current position.
     *
     * @param blockState State of the block being checked
     * @param levelReader Reader for the level the block is in
     * @param position Position of the block being checked
     * @return Whether the block can survive in its current position
     */
    public abstract boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos position);

    /**
     * Determines what happens to this block if it is pushed by a piston.
     * In this case, we want the block to be destroyed.
     *
     * @param state State of the block being pushed
     * @return What the reaction to being pushed is
     */
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    /**
     * Sets the flammability of the block. The higher the number the more likely it is to catch fire
     *
     * @param state State of the block
     * @param level Level that we are getting the block from
     * @param pos Position of the block
     * @param face The face of the block being set on fire
     * @return The flammability value of the block given its position in the world and the face being set alight
     */
    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face)
    {
        return 6;
    }

    /**
     * Determines how likely the fire is to destroy the block. The higher the number the more likely it is to burn up.
     *
     * @param state State of the block
     * @param level Level that the block exists in
     * @param pos Position of the block
     * @param face The face of the block that's currently aflame
     * @return The likelihood that this burning block will be destroyed by the fire
     */
    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face)
    {
        return 6;
    }

    /**
     * Ensures that path finding entities treat this block as an obstruction even though it has no occlusion and is not a
     * full shape.
     *
     * @param state State of the block we are pathing against
     * @param blockGetter Reader for accessing block information
     * @param position Position of the block we are pathing against
     * @param pathType The type of path being checked (land, water, or air)
     * @return Whether block is pathable given the path type being checked
     */
    @Override
    public boolean isPathfindable(BlockState state, BlockGetter blockGetter, BlockPos position, PathComputationType pathType) {
        switch(pathType) {
            case LAND:
                return false;
            case WATER:
                return false;
            case AIR:
                return false;
            default:
                return false;
        }
    }

    /**
     * Rotates the block based on the direction the player is facing when it was placed.
     *
     * @param state State of the block being placed
     * @param rotation Rotation the block is being placed at
     * @return Sets the rotation for the facing value into block state for this block
     */
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    /**
     * Called whenever this block is attacked by a player
     * Causes the block to drop its placed screen, if one is attached
     *
     * @param state State of the block
     * @param level Level the block is in
     * @param position Position of the block
     * @param player Player attacking the block
     */
    @Override
    public void attack(BlockState state, Level level, BlockPos position, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(position);
        if (blockEntity instanceof AbstractShojiScreenBlockEntity) {
            boolean result = ((AbstractShojiScreenBlockEntity) blockEntity).popScreen();
            if (result) {
                level.playSound(player, position, SoundEvents.MOSS_CARPET_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
                state.setValue(HAS_SHOJI, true);
            }
        }
    }

    /**
     * Logic that occurs when the player interacts with this block.
     * If the player is holding a shoji paper item and this frame is currently empty, they can place it into this frame.
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

        BlockEntity blockEntity = level.getBlockEntity(position);
        return placeScreen(itemStack, blockEntity, state, level, position, player);
    }

    /**
     * Places the screen into the block entity, if valid
     *
     * @param itemStack Item being placed into the entity
     * @param blockEntity Block entity within which the item is being placed
     * @param state state of the block the screen is being placed into
     * @param level Level in which this is happening in
     * @param position Position that the block was interacted with
     * @param player Player that interacted with the block to place the screen
     * @return Result after interacting with this block
     */
    protected InteractionResult placeScreen(ItemStack itemStack, BlockEntity blockEntity, BlockState state, Level level, BlockPos position, Player player) {
        if (blockEntity instanceof AbstractShojiScreenBlockEntity) {
            if (level.isClientSide()) {
                return itemStack.isEmpty() ? InteractionResult.PASS : InteractionResult.SUCCESS;
            } else {
                if (!itemStack.isEmpty() && itemStack.getItem() instanceof ShojiPaper) {
                    boolean result = ((AbstractShojiScreenBlockEntity) blockEntity).setScreen(itemStack.copyWithCount(1));
                    if (result) {
                        itemStack.shrink(1);
                        level.playSound(player, position, SoundEvents.MOSS_CARPET_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                        state.setValue(HAS_SHOJI, true);
                        return InteractionResult.CONSUME;
                    }
                }
            }
        }

        return InteractionResult.PASS;
    }
}
