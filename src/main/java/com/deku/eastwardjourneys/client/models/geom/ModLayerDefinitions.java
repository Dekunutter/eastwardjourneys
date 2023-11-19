package com.deku.eastwardjourneys.client.models.geom;

import com.deku.eastwardjourneys.client.models.*;
import com.deku.eastwardjourneys.client.models.shoji.*;
import net.minecraft.client.model.geom.builders.LayerDefinition;

public class ModLayerDefinitions {
    public static LayerDefinition KOI_LAYER = KoiModel.createBodyLayer();

    public static LayerDefinition SHOJI_FRAME_LOWER_LAYER = ShojiLowerFrameModel.createBodyLayer();
    public static LayerDefinition SHOJI_FRAME_UPPER_LAYER = ShojiUpperFrameModel.createBodyLayer();
    public static LayerDefinition SHOJI_FRAME_GRIDED_LOWER_LAYER = ShojiLowerFrameGridedModel.createBodyLayer();
    public static LayerDefinition SHOJI_FRAME_GRIDED_UPPER_LAYER = ShojiUpperFrameGridedModel.createBodyLayer();
    public static LayerDefinition SHOJI_FRAME_GRIDED_HEAVY_LOWER_LAYER = ShojiLowerFrameGridedHeavyModel.createBodyLayer();
    // TODO: Split shoji screen into lower and upper halves
    public static LayerDefinition SHOJI_SCREEN_LAYER = ShojiScreenModel.createScreenLayer();
    public static LayerDefinition SMALL_SHOJI_FRAME_LAYER = SmallShojiFrameModel.createBodyLayer();
    public static LayerDefinition SMALL_SHOJI_SCREEN_LAYER = SmallShojiScreenModel.createScreenLayer();
}
