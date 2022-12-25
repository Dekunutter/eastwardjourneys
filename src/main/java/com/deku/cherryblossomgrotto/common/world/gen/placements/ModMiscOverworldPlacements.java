package com.deku.cherryblossomgrotto.common.world.gen.placements;

import com.deku.cherryblossomgrotto.common.features.ModMiscOverworldFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

import static com.deku.cherryblossomgrotto.Main.MOD_ID;

public class ModMiscOverworldPlacements {
    public static ResourceKey<PlacedFeature> CHERRY_BLOSSOM_PETAL_TOP_LAYER = registerOverworldPlacementKey("cherry_blossom_petals_top_layer");

    /**
     * Registers the overworld placements into the vanilla game by the placed feature registry
     *
     * @param placementName The registry name of the placed feature
     * @return The registered key for the custom placed feature
     */
    public static ResourceKey<PlacedFeature> registerOverworldPlacementKey(String placementName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MOD_ID, placementName));
    }

    /**
     * Bootstraps the context needed to register the placed features for the mod
     *
     * @param context Bootstrap context needed to register placed features to the game
     */
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> featureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(CHERRY_BLOSSOM_PETAL_TOP_LAYER, new PlacedFeature(featureGetter.getOrThrow(ModMiscOverworldFeatures.CHERRY_BLOSSOM_PETAL_GROUND_COVER), List.of(BiomeFilter.biome())));
    }
}
