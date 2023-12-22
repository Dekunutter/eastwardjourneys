package com.deku.eastwardjourneys.common.world.gen.placements;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.*;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModOrePlacements {
    public static ResourceKey<PlacedFeature> ORE_IRON_SPARSE = registerOrePlacementKey("ore_iron_sparse");
    public static ResourceKey<PlacedFeature> ORE_IRON_SPARSE_UPPER = registerOrePlacementKey("ore_iron_sparse_upper");

    /**
     * Registers the ore placements into the vanilla game by the placed feature registry
     *
     * @param placementName The registry name of the placed feature
     * @return The registered key for the custom placed feature
     */
    public static ResourceKey<PlacedFeature> registerOrePlacementKey(String placementName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MOD_ID, placementName));
    }
}
