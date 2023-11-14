package com.deku.eastwardjourneys.client.models.geom;

import com.deku.eastwardjourneys.client.models.*;
import com.deku.eastwardjourneys.client.models.shoji.*;
import net.minecraft.client.model.geom.builders.LayerDefinition;

public class ModLayerDefinitions {
    public static LayerDefinition KOI_LAYER = KoiModel.createBodyLayer();

    public static LayerDefinition SHOJI_FRAME_LAYER = ShojiFrameModel.createBodyLayer();
    public static LayerDefinition SHOJI_FRAME_GRIDED_LAYER = ShojiFrameGridedModel.createBodyLayer();
    public static LayerDefinition SHOJI_FRAME_GRIDED_HEAVY_LAYER = ShojiFrameGridedHeavyModel.createBodyLayer();
    public static LayerDefinition SHOJI_SCREEN_LAYER = ShojiScreenModel.createScreenLayer();
    public static LayerDefinition SMALL_SHOJI_FRAME_LAYER = SmallShojiFrameModel.createBodyLayer();
    public static LayerDefinition SMALL_SHOJI_SCREEN_LAYER = SmallShojiScreenModel.createScreenLayer();
}
