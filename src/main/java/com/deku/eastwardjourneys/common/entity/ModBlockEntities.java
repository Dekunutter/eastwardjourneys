package com.deku.eastwardjourneys.common.entity;

import com.deku.eastwardjourneys.common.blockEntities.MapleLeavesBlockEntity;
import com.deku.eastwardjourneys.common.blockEntities.ShojiScreenBlockEntity;
import com.deku.eastwardjourneys.common.blockEntities.SmallShojiScreenBlockEntity;
import com.deku.eastwardjourneys.common.blocks.ModBlocks;
import com.deku.eastwardjourneys.common.entity.sign.ModHangingSignBlockEntity;
import com.deku.eastwardjourneys.common.entity.sign.ModSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
    public static BlockEntityType<MapleLeavesBlockEntity> MAPLE_LEAVES_TYPE = BlockEntityType.Builder.of(MapleLeavesBlockEntity::new, ModBlocks.MAPLE_LEAVES).build(null);

    public static BlockEntityType<ModSignBlockEntity> SIGN_ENTITY_TYPE = BlockEntityType.Builder.of(ModSignBlockEntity::new, ModBlocks.MAPLE_SIGN, ModBlocks.MAPLE_WALL_SIGN, ModBlocks.BLACK_PINE_SIGN, ModBlocks.BLACK_PINE_WALL_SIGN, ModBlocks.HINOKI_SIGN, ModBlocks.HINOKI_WALL_SIGN, ModBlocks.WATER_FIR_SIGN, ModBlocks.WATER_FIR_WALL_SIGN, ModBlocks.SAXAUL_SIGN, ModBlocks.SAXAUL_WALL_SIGN).build(null);

    public static BlockEntityType<ModHangingSignBlockEntity> HANGING_SIGN_ENTITY_TYPE = BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, ModBlocks.MAPLE_HANGING_SIGN, ModBlocks.MAPLE_WALL_HANGING_SIGN, ModBlocks.BLACK_PINE_HANGING_SIGN, ModBlocks.BLACK_PINE_WALL_HANGING_SIGN, ModBlocks.HINOKI_HANGING_SIGN, ModBlocks.HINOKI_WALL_HANGING_SIGN, ModBlocks.WATER_FIR_HANGING_SIGN, ModBlocks.WATER_FIR_WALL_HANGING_SIGN, ModBlocks.SAXAUL_HANGING_SIGN, ModBlocks.SAXAUL_WALL_HANGING_SIGN).build(null);

    public static BlockEntityType<ShojiScreenBlockEntity> SHOJI_SCREEN_TYPE = BlockEntityType.Builder.of(ShojiScreenBlockEntity::new, ModBlocks.SHOJI_SCREEN, ModBlocks.DARK_SHOJI_SCREEN, ModBlocks.SHOJI_SCREEN_GRIDED, ModBlocks.DARK_SHOJI_SCREEN_GRIDED, ModBlocks.SHOJI_SCREEN_GRIDED_HEAVY, ModBlocks.DARK_SHOJI_SCREEN_GRIDED_HEAVY).build(null);

    public static BlockEntityType<SmallShojiScreenBlockEntity> SMALL_SHOJI_SCREEN_TYPE = BlockEntityType.Builder.of(SmallShojiScreenBlockEntity::new, ModBlocks.SMALL_SHOJI_SCREEN, ModBlocks.SMALL_DARK_SHOJI_SCREEN).build(null);
}
