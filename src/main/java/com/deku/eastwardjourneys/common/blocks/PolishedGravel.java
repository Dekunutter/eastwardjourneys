package com.deku.eastwardjourneys.common.blocks;

import com.deku.eastwardjourneys.common.blocks.state.GravelPattern;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

import static com.deku.eastwardjourneys.common.blocks.ModBlockStateProperties.GRAVEL_PATTERN;

// TODO: Blockstate setting, testing the different patterns, changing blockstate on interact with a hoe, changing dust colour to be a little lighter and having gravel be polished like stones can be to make this block
public class PolishedGravel extends FallingBlock {
    public PolishedGravel() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.SNARE).strength(0.6F).sound(SoundType.GRAVEL));
    }

    public int getDustColor(BlockState state, BlockGetter getter, BlockPos position) {
        return -8356741;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos position, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemStack = player.getItemInHand(hand);

        GravelPattern currentPattern = state.getValue(GRAVEL_PATTERN);

        if (itemStack.is(ItemTags.HOES)) {
            level.setBlock(position, state.setValue(GRAVEL_PATTERN, currentPattern.next()), 3);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return super.use(state, level, position, player, hand, hitResult);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(GRAVEL_PATTERN);
    }
}
