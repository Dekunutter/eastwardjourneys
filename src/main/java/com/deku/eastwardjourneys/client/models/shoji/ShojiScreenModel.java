package com.deku.eastwardjourneys.client.models.shoji;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;


public class ShojiScreenModel extends AbstractShojiScreenModel {
    public ShojiScreenModel(ModelPart root) {
        this.bone = root.getChild("bb_main");
    }

    /**
     * Initializes the layer tied to this model, setting up its vertices and UVs
     *
     * @return Layer definition for this model
     */
    public static LayerDefinition createScreenLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // NOTE: Got these dimensions from blockbench by copying the screen element from my shoji frame models into a new modded entity project, applying a texture, setting the UV and then exporting that. Allowing me to have a "single model" with multiple textures on different layers
        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -30.0F, 6.0F, 12.0F, 28.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }
}