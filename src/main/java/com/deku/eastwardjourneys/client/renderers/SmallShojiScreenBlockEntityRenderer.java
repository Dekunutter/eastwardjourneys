package com.deku.eastwardjourneys.client.renderers;

import com.deku.eastwardjourneys.client.models.geom.ModModelLayerLocations;
import com.deku.eastwardjourneys.client.models.shoji.*;
import com.deku.eastwardjourneys.common.blockEntities.SmallShojiScreenBlockEntity;
import com.deku.eastwardjourneys.common.blocks.SmallShojiScreen;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;


// NOTE: Despite being so similar to the standard shoji block, decided to have this be its own renderer since the renderer was getting pretty complex with a lot of conditional logic and this needs its own models anyway
public class SmallShojiScreenBlockEntityRenderer implements BlockEntityRenderer<SmallShojiScreenBlockEntity> {
    private final SmallShojiFrameModel model;
    private final SmallShojiScreenModel screen;

    public SmallShojiScreenBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        model = new SmallShojiFrameModel(context.bakeLayer(ModModelLayerLocations.SMALL_SHOJI_FRAME));
        screen = new SmallShojiScreenModel(context.bakeLayer(ModModelLayerLocations.SMALL_SHOJI_SCREEN));
    }

    /**
     * Renders the shoji screen block into the world.
     * This will determine what model needs to be rendered based off of the information tied to the block entity.
     * It will also render the shoji screen placed into the frame if applicable.
     * The models for the frame and screen are determined by the frame type and wood colour of the shoji screen block entity.
     *
     * @param entity The block entity being rendered
     * @param partialTicks ticks since the last render
     * @param poseStack Positional data for the models being rendered
     * @param buffer Buffer for rendering
     * @param packedLight Lighting applied to this render
     * @param combinedOverlay Overlay applied to this render
     */
    @Override
    public void render(SmallShojiScreenBlockEntity entity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int combinedOverlay) {
        // NOTE: Seems blockbench models can come out a bit offset for thin blocks like this, so I had to modify the position a bit to get it to display correctly, as well as rotate it
        poseStack.pushPose();
        poseStack.translate(0.5F, 1.5F, 0.5F);

        float angle = -entity.getBlockState().getValue(SmallShojiScreen.FACING).toYRot();
        poseStack.mulPose(Axis.YP.rotationDegrees(angle));
        poseStack.mulPose(Axis.XP.rotationDegrees(180));

        VertexConsumer vertexconsumer = buffer.getBuffer(model.renderType(model.getTextureLocation(entity.getWoodColor())));
        model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        if (entity.getScreen() == null) {
            screen.setInvisible();
        } else {
            screen.setVisible();
            VertexConsumer screenVertexConsumer = buffer.getBuffer(screen.renderType(screen.getTextureLocation(entity.getScreen())));
            screen.renderToBuffer(poseStack, screenVertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
        poseStack.popPose();
    }
}