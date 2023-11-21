package com.deku.eastwardjourneys.client.models.shoji;

import com.deku.eastwardjourneys.common.blockEntities.ShojiScreenBlockEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;

import static com.deku.eastwardjourneys.Main.MOD_ID;


public abstract class AbstractShojiFrameModel extends EntityModel {
    /**
     * Gets the texture for the shoji frame based on the wood colour used in construction
     *
     * @param color Wood colour that the frame is composed of
     * @return The resource location for the texture to apply to the model
     */
    public ResourceLocation getTextureLocation(ShojiScreenBlockEntity.WoodColor color) {
        return switch (color) {
            case DARK -> new ResourceLocation(MOD_ID, "textures/block/dark_shoji_screen.png");
            default -> new ResourceLocation(MOD_ID, "textures/block/shoji_screen.png");
        };
    }
}
