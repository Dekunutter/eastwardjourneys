package com.deku.eastwardjourneys.client.models.geom;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModModelLayerLocations {
    public static ModelLayerLocation KOI = ModModelLayerLocations.getLayerLocation("koi", "main");

    public static ModelLayerLocation SHOJI_FRAME_LOWER = ModModelLayerLocations.getLayerLocation("shoji_frame_lower", "main");
    public static ModelLayerLocation SHOJI_FRAME_UPPER = ModModelLayerLocations.getLayerLocation("shoji_frame_upper", "main");
    public static ModelLayerLocation SHOJI_FRAME_GRIDED_LOWER = ModModelLayerLocations.getLayerLocation("shoji_frame_grided_lower", "main");
    public static ModelLayerLocation SHOJI_FRAME_GRIDED_UPPER = ModModelLayerLocations.getLayerLocation("shoji_frame_grided_upper", "main");
    public static ModelLayerLocation SHOJI_FRAME_GRIDED_HEAVY_LOWER = ModModelLayerLocations.getLayerLocation("shoji_frame_grided_heavy_lower", "main");
    public static ModelLayerLocation SHOJI_SCREEN = ModModelLayerLocations.getLayerLocation("shoji_screen", "main");
    public static ModelLayerLocation SMALL_SHOJI_FRAME = ModModelLayerLocations.getLayerLocation("small_shoji_frame", "main");
    public static ModelLayerLocation SMALL_SHOJI_SCREEN = ModModelLayerLocations.getLayerLocation("small_shoji_screen", "main");

    /**
     * Gets the model layer location for the given layer name
     *
     * @param layerName The name of the layer we want the model layer location for
     * @return The model layer location for the given layer
     */
    public static ModelLayerLocation getLayerLocation(String layerName, String part) {
        return new ModelLayerLocation(new ResourceLocation(MOD_ID, layerName), part);
    }
}
