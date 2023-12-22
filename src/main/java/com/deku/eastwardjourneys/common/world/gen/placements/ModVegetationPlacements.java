package com.deku.eastwardjourneys.common.world.gen.placements;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.*;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModVegetationPlacements {
    public static ResourceKey<PlacedFeature> TREES_MAPLE_WOODS = registerVegetationPlacementKey("trees_maple_woods");
    public static ResourceKey<PlacedFeature> TREES_OAK_AND_MAPLE_FOREST = registerVegetationPlacementKey("trees_oak_and_maple_forest");

    public static ResourceKey<PlacedFeature> TREES_BLACK_PINE_FOREST = registerVegetationPlacementKey("trees_black_pine_forest");

    /**
     * Registers the vegetation placements into the vanilla game by the placed feature registry
     *
     * @param placementName The registry name of the placed feature
     * @return The registered key for the custom placed feature
     */
    public static ResourceKey<PlacedFeature> registerVegetationPlacementKey(String placementName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MOD_ID, placementName));
    }
}
