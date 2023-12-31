package com.deku.eastwardjourneys.common.blockEntities;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ObjectHolder;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModBlockEntityType {
    @ObjectHolder(registryName = "minecraft:block_entity_type", value = MOD_ID + ":maple_leaves_tile_entity")
    public static BlockEntityType<MapleLeavesBlockEntity> MAPLE_LEAVES_TILE_DATA;

    @ObjectHolder(registryName = "minecraft:block_entity_type", value = MOD_ID + ":shoji_screen_block_entity")
    public static BlockEntityType<ShojiScreenBlockEntity> SHOJI_SCREEN_BLOCK_DATA;

    @ObjectHolder(registryName = "minecraft:block_entity_type", value = MOD_ID + ":small_shoji_screen_block_entity")
    public static BlockEntityType<SmallShojiScreenBlockEntity> SMALL_SHOJI_SCREEN_BLOCK_DATA;
}
