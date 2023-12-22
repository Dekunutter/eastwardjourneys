package com.deku.eastwardjourneys.common.features;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModTreeFeatures {
    public static ResourceKey<ConfiguredFeature<?, ?>> FANCY_MAPLE_TREE = registerTreeFeatureKey("fancy_maple");
    public static ResourceKey<ConfiguredFeature<?, ?>> FANCY_MAPLE_TREE_BEES = registerTreeFeatureKey("fancy_maple_bees");

    public static ResourceKey<ConfiguredFeature<?, ?>> BLACK_PINE = registerTreeFeatureKey("black_pine");
    public static ResourceKey<ConfiguredFeature<?, ?>> STRAIGHT_BLACK_PINE = registerTreeFeatureKey("straight_black_pine");

    public static ResourceKey<ConfiguredFeature<?, ?>> HINOKI = registerTreeFeatureKey("hinoki");
    public static ResourceKey<ConfiguredFeature<?, ?>> HINOKI_BEES = registerTreeFeatureKey("hinoki_bees");

    public static ResourceKey<ConfiguredFeature<?, ?>> WATER_FIR = registerTreeFeatureKey("water_fir");
    public static ResourceKey<ConfiguredFeature<?, ?>> WATER_FIR_BEES = registerTreeFeatureKey("water_fir_bees");

    public static ResourceKey<ConfiguredFeature<?, ?>> MEGA_WATER_FIR = registerTreeFeatureKey("mega_water_fir");

    public static ResourceKey<ConfiguredFeature<?, ?>> SAXAUL = registerTreeFeatureKey("saxaul");

    public static ResourceKey<ConfiguredFeature<?, ?>> LARGE_SAXAUL = registerTreeFeatureKey("large_saxaul");

    public static ResourceKey<ConfiguredFeature<?, ?>> HUGE_ENOKI_MUSHROOM = registerTreeFeatureKey("huge_enoki_mushroom");

    public static ResourceKey<ConfiguredFeature<?, ?>> HUGE_SHIITAKE_MUSHROOM = registerTreeFeatureKey("huge_shiitake_mushroom");



    /**
     * Registers a resource key for the given tree feature name
     *
     * @param featureName Name of the feature we want to create a resource key for
     * @return The resource key created for the given feature
     */
    public static ResourceKey<ConfiguredFeature<?, ?>> registerTreeFeatureKey(String featureName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MOD_ID, featureName));
    }
}
