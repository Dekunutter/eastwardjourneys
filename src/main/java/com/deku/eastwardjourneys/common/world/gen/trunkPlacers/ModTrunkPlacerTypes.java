package com.deku.eastwardjourneys.common.world.gen.trunkPlacers;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, MOD_ID);

    public static RegistryObject<TrunkPlacerType<BlackPineTrunkPlacer>> BLACK_PINE_TREE_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("black_pine_tree_trunk_placer", () -> new TrunkPlacerType<>(BlackPineTrunkPlacer.CODEC));
}
