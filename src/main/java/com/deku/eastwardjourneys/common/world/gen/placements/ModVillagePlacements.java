package com.deku.eastwardjourneys.common.world.gen.placements;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;


import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModVillagePlacements {
    public static ResourceKey<PlacedFeature> CHERRY_BLOSSOM_TREE_VILLAGE = registerVillagePlacementKey("cherry_blossom");
    public static ResourceKey<PlacedFeature> FLOWER_FOREST_VILLAGE = registerVillagePlacementKey("flower_forest");

    /**
     * Registers the village placements into the vanilla game by the placed feature registry
     *
     * @param placementName The registry name of the placed feature
     * @return The registered key for the custom placed feature
     */
    public static ResourceKey<PlacedFeature> registerVillagePlacementKey(String placementName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MOD_ID, placementName));
    }
}
