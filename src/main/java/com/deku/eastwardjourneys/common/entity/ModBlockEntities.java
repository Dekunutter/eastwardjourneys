package com.deku.eastwardjourneys.common.entity;

import com.deku.eastwardjourneys.common.blockEntities.MapleLeavesBlockEntity;
import com.deku.eastwardjourneys.common.blockEntities.ShojiScreenBlockEntity;
import com.deku.eastwardjourneys.common.blockEntities.SmallShojiScreenBlockEntity;
import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;
import com.deku.eastwardjourneys.common.entity.sign.ModHangingSignBlockEntity;
import com.deku.eastwardjourneys.common.entity.sign.ModSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
    public static BlockEntityType<MapleLeavesBlockEntity> MAPLE_LEAVES_TYPE = BlockEntityType.Builder.of(MapleLeavesBlockEntity::new, ModBlockInitializer.MAPLE_LEAVES.get()).build(null);

    public static BlockEntityType<ModSignBlockEntity> SIGN_ENTITY_TYPE = BlockEntityType.Builder.of(
        ModSignBlockEntity::new,
        ModBlockInitializer.MAPLE_SIGN.get(),
        ModBlockInitializer.MAPLE_WALL_SIGN.get(),
        ModBlockInitializer.BLACK_PINE_SIGN.get(),
        ModBlockInitializer.BLACK_PINE_WALL_SIGN.get(),
        ModBlockInitializer.HINOKI_SIGN.get(),
        ModBlockInitializer.HINOKI_WALL_SIGN.get(),
        ModBlockInitializer.WATER_FIR_SIGN.get(),
        ModBlockInitializer.WATER_FIR_WALL_SIGN.get(),
        ModBlockInitializer.SAXAUL_SIGN.get(),
        ModBlockInitializer.SAXAUL_WALL_SIGN.get()
    ).build(null);

    public static BlockEntityType<ModHangingSignBlockEntity> HANGING_SIGN_ENTITY_TYPE = BlockEntityType.Builder.of(
        ModHangingSignBlockEntity::new,
        ModBlockInitializer.MAPLE_HANGING_SIGN.get(),
        ModBlockInitializer.MAPLE_WALL_HANGING_SIGN.get(),
        ModBlockInitializer.BLACK_PINE_HANGING_SIGN.get(),
        ModBlockInitializer.BLACK_PINE_WALL_HANGING_SIGN.get(),
        ModBlockInitializer.HINOKI_HANGING_SIGN.get(),
        ModBlockInitializer.HINOKI_WALL_HANGING_SIGN.get(),
        ModBlockInitializer.WATER_FIR_HANGING_SIGN.get(),
        ModBlockInitializer.WATER_FIR_WALL_HANGING_SIGN.get(),
        ModBlockInitializer.SAXAUL_HANGING_SIGN.get(),
        ModBlockInitializer.SAXAUL_WALL_HANGING_SIGN.get()
    ).build(null);

    public static BlockEntityType<ShojiScreenBlockEntity> SHOJI_SCREEN_TYPE = BlockEntityType.Builder.of(
        ShojiScreenBlockEntity::new,
            ModBlockInitializer.SHOJI_SCREEN.get(),
            ModBlockInitializer.SHOJI_SCREEN_DARK.get(),
            ModBlockInitializer.SHOJI_SCREEN_GRIDED.get(),
            ModBlockInitializer.SHOJI_SCREEN_DARK_GRIDED.get(),
            ModBlockInitializer.SHOJI_SCREEN_GRIDED_HEAVY.get(),
            ModBlockInitializer.SHOJI_SCREEN_DARK_GRIDED_HEAVY.get()
    ).build(null);

    public static BlockEntityType<SmallShojiScreenBlockEntity> SMALL_SHOJI_SCREEN_TYPE = BlockEntityType.Builder.of(
        SmallShojiScreenBlockEntity::new,
        ModBlockInitializer.SMALL_SHOJI_SCREEN.get(),
        ModBlockInitializer.SMALL_SHOJI_SCREEN_DARK.get()
    ).build(null);
}
