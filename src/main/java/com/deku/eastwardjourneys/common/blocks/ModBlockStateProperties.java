package com.deku.eastwardjourneys.common.blocks;

import com.deku.eastwardjourneys.common.blocks.state.GravelPattern;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.*;

public class ModBlockStateProperties {
    public static final IntegerProperty HALF_LAYERS = IntegerProperty.create("half_layers", 1, 4);

    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public static final BooleanProperty HANGING = BlockStateProperties.HANGING;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final BooleanProperty HAS_MAPLE_SYRUP = BooleanProperty.create("has_maple_syrup");

    public static final EnumProperty<GravelPattern> GRAVEL_PATTERN = EnumProperty.create("pattern", GravelPattern.class);

    public static final BooleanProperty HAS_SHOJI = BooleanProperty.create("has_shoji");
}
