package com.deku.eastwardjourneys.client.models.shoji;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;


public class ShojiUpperFrameModel extends AbstractShojiFrameModel {
    private final ModelPart frame;

    public ShojiUpperFrameModel(ModelPart root) {
        this.frame = root.getChild("frame");
    }

    /**
     * Initializes the layer tied to this model, setting up its vertices and UVs
     *
     * @return Layer definition for this model
     */
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(23, 22).addBox(-16.0F, -16.0F, 13.0F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
            .texOffs(10, 25).addBox(-2.0F, -14.0F, 13.0F, 2.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
            .texOffs(0, 25).addBox(-16.0F, -14.0F, 13.0F, 2.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    /**
     * Sets up the animations for this model.
     *
     * @param entity The entity being animated
     * @param limbSwing
     * @param limbSwingAmount
     * @param ageInTicks
     * @param netHeadYaw
     * @param headPitch
     */
    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    /**
     * Renders the frame model
     *
     * @param poseStack Positional data on the model
     * @param vertexConsumer vertices and UVs to be rendered
     * @param packedLight Light applied to this model
     * @param packedOverlay overlay applied to this model
     * @param red Intensity for the red hue on this model
     * @param green Intensity for the green hue on this model
     * @param blue Intensity for the blue hue on this model
     * @param alpha Intensity for the alpha on this model
     */
    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}