package com.deku.eastwardjourneys.common.features;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModOreFeatures {
    public static ResourceKey<ConfiguredFeature<?, ?>> ORE_IRON_SPARSE = registerOreFeatureKey("ore_iron_sparse");

    /**
     * Registers a resource key for the given ore feature name
     *
     * @param featureName Name of the feature we want to create a resource key for
     * @return The resource key created for the given feature
     */
    public static ResourceKey<ConfiguredFeature<?, ?>> registerOreFeatureKey(String featureName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MOD_ID, featureName));
    }
}
