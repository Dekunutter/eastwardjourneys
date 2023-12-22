package com.deku.eastwardjourneys.common.features;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModMiscOverworldFeatures {
    public static ResourceKey<ConfiguredFeature<?, ?>> MAPLE_LEAF_GROUND_COVER = registerOverworldFeatureKey("maple_leaf_ground_cover");
    public static ResourceKey<ConfiguredFeature<?, ?>> MOSS_LAYER = registerOverworldFeatureKey("moss_layer");

    public static ResourceKey<ConfiguredFeature<?, ?>> HOTSPRING = registerOverworldFeatureKey("hotspring");

    public static ResourceKey<ConfiguredFeature<?, ?>> KARST_STONE = registerOverworldFeatureKey("karst_stone");

    public static ResourceKey<ConfiguredFeature<?, ?>> FALLEN_TREE_HINOKI = registerOverworldFeatureKey("fallen_tree_hinoki");

    /**
     * Registers a resource key for the given miscellanous overworld feature name
     *
     * @param featureName Name of the feature we want to create a resource key for
     * @return The resource key created for the given feature
     */
    public static ResourceKey<ConfiguredFeature<?, ?>> registerOverworldFeatureKey(String featureName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MOD_ID, featureName));
    }
}
