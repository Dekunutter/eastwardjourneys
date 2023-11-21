package com.deku.eastwardjourneys.client.models.shoji;

import com.deku.eastwardjourneys.common.items.ShojiPaper;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public abstract class AbstractShojiScreenModel extends EntityModel {
    protected ModelPart bone;

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
    public void setupAnim(@NotNull Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    /**
     * Renders the screen model
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
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    /**
     * Gets the texture for the shoji screen based on the screen placed into the shoji frame
     *
     * @param screen Shoji screen item that is being rendered
     * @return The resource location for the texture to apply to the model
     */
    public ResourceLocation getTextureLocation(ItemStack screen) {
        return new ResourceLocation(MOD_ID, "textures/block/shoji/" + ShojiPaper.getPattern(screen) + ".png");
    }

    /**
     * Sets the screen to invisible so it does not render
     */
    public void setInvisible() {
        bone.visible = false;
    }

    /**
     * Sets the screen to visible so it renders
     */
    public void setVisible() {
        bone.visible = true;
    }
}
