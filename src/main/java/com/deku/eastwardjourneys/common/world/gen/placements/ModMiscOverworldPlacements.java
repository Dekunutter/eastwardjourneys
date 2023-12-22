package com.deku.eastwardjourneys.common.world.gen.placements;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.*;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModMiscOverworldPlacements {
    public static ResourceKey<PlacedFeature> MAPLE_LEAF_TOP_LAYER = registerOverworldPlacementKey("maple_leaves_top_layer");
    public static ResourceKey<PlacedFeature> MOSS_LAYER = registerOverworldPlacementKey("moss_top_layer");

    public static ResourceKey<PlacedFeature> HOTSPRING = registerOverworldPlacementKey("hotspring");

    /**
     * Registers the overworld placements into the vanilla game by the placed feature registry
     *
     * @param placementName The registry name of the placed feature
     * @return The registered key for the custom placed feature
     */
    public static ResourceKey<PlacedFeature> registerOverworldPlacementKey(String placementName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MOD_ID, placementName));
    }
}
