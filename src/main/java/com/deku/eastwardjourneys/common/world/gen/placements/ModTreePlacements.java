package com.deku.eastwardjourneys.common.world.gen.placements;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModTreePlacements {
    public static ResourceKey<PlacedFeature> FANCY_MAPLE_CHECKED = registerTreePlacementKey("fancy_maple_checked");
    public static ResourceKey<PlacedFeature> FANCY_MAPLE_BEES = registerTreePlacementKey("fancy_maple_bees");
    public static ResourceKey<PlacedFeature> BLACK_PINE_CHECKED = registerTreePlacementKey("black_pine_checked");
    public static ResourceKey<PlacedFeature> STRAIGHT_BLACK_PINE_CHECKED = registerTreePlacementKey("straight_black_pine_checked");

    /**
     * Registers the tree placements into the vanilla game by the placed feature registry
     *
     * @param placementName The registry name of the placed feature
     * @return The registered key for the custom placed feature
     */
    public static ResourceKey<PlacedFeature> registerTreePlacementKey(String placementName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MOD_ID, placementName));
    }
}
