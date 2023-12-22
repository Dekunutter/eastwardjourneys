package com.deku.eastwardjourneys.common.features;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModVegetationFeatures {
    public static ResourceKey<ConfiguredFeature<?, ?>> TREES_MAPLE_WOODS = registerVegetationFeatureKey("trees_maple_woods");
    public static ResourceKey<ConfiguredFeature<?, ?>> TREES_OAK_AND_MAPLE_FOREST = registerVegetationFeatureKey("trees_oak_and_maple_forest");

    public static ResourceKey<ConfiguredFeature<?, ?>> TREES_BLACK_PINE_FOREST = registerVegetationFeatureKey("trees_black_pine_forest");

    /**
     * Registers a resource key for the given vegetation feature name
     *
     * @param featureName Name of the feature we want to create a resource key for
     * @return The resource key created for the given feature
     */
    public static ResourceKey<ConfiguredFeature<?, ?>> registerVegetationFeatureKey(String featureName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MOD_ID, featureName));
    }
}
