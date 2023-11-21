package com.deku.eastwardjourneys.client.renderers;

import com.deku.eastwardjourneys.client.models.shoji.*;
import com.deku.eastwardjourneys.client.models.geom.ModModelLayerLocations;
import com.deku.eastwardjourneys.common.blockEntities.ShojiScreenBlockEntity;
import com.deku.eastwardjourneys.common.blocks.SmallShojiScreen;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import static com.deku.eastwardjourneys.common.blocks.ModBlockStateProperties.HALF;


public class ShojiScreenBlockEntityRenderer implements BlockEntityRenderer<ShojiScreenBlockEntity> {
    // NOTE: This is a renderer for a double-height block so I'm using a pair of models for each half. This is similar to how double chest renderers work in vanilla.
    private final Pair<AbstractShojiFrameModel, AbstractShojiFrameModel> standardModels;
    private final Pair<AbstractShojiFrameModel, AbstractShojiFrameModel> gridedModels;
    private final Pair<AbstractShojiFrameModel, AbstractShojiFrameModel> gridedHeavyModels;
    private final AbstractShojiScreenModel screenModel;

    public ShojiScreenBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        standardModels = new Pair<>(new ShojiUpperFrameModel(context.bakeLayer(ModModelLayerLocations.SHOJI_FRAME_UPPER)), new ShojiLowerFrameModel(context.bakeLayer(ModModelLayerLocations.SHOJI_FRAME_LOWER)));
        gridedModels = new Pair<>(new ShojiUpperFrameGridedModel(context.bakeLayer(ModModelLayerLocations.SHOJI_FRAME_GRIDED_UPPER)), new ShojiLowerFrameGridedModel(context.bakeLayer(ModModelLayerLocations.SHOJI_FRAME_GRIDED_LOWER)));
        gridedHeavyModels = new Pair<>(new ShojiUpperFrameGridedModel(context.bakeLayer(ModModelLayerLocations.SHOJI_FRAME_GRIDED_UPPER)), new ShojiLowerFrameGridedHeavyModel(context.bakeLayer(ModModelLayerLocations.SHOJI_FRAME_GRIDED_HEAVY_LOWER)));
        screenModel = new ShojiScreenModel(context.bakeLayer(ModModelLayerLocations.SHOJI_SCREEN));
    }

    /**
     * Determines which frame and screen model pair should be used to render the shoji screen.
     *
     * @param entity The entity we are rendering this model set for
     * @return The pair of models representing frame and screen
     */
    private Pair<AbstractShojiFrameModel, AbstractShojiScreenModel> determineModels(ShojiScreenBlockEntity entity) {
        Pair<AbstractShojiFrameModel, AbstractShojiFrameModel> models = switch (entity.getFrameType()) {
            case GRIDED -> gridedModels;
            case GRIDED_HEAVY -> gridedHeavyModels;
            default -> standardModels;
        };

        boolean isBottomHalf = entity.getBlockState().getValue(HALF) == DoubleBlockHalf.LOWER;
        AbstractShojiFrameModel model;
        AbstractShojiScreenModel screen = null;
        if (isBottomHalf) {
            model = models.getSecond();
            screen = screenModel;
        } else {
            model = models.getFirst();
        }

        return new Pair(model, screen);
    }

    /**
     * Renders the shoji screen block into the world.
     * Since this is a double-height block, it will be called by both halves and needs to understand which half to render via information within the entity
     * It will also render the shoji screen placed into the frame if applicable. The shoji screen is a single render for both halves, meaning it renders only for the lower half but the visible model makes it look seamless
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
    public void render(ShojiScreenBlockEntity entity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int combinedOverlay) {
        Pair<AbstractShojiFrameModel, AbstractShojiScreenModel> models = determineModels(entity);
        AbstractShojiFrameModel frame = models.getFirst();
        AbstractShojiScreenModel screen = models.getSecond();

        // NOTE: Seems blockbench models can come out a bit offset for thin blocks like this, so I had to modify the position a bit to get it to display correctly, as well as rotate it
        poseStack.pushPose();
        poseStack.translate(0.5F, 1.5F, 0.5F);

        float angle = -entity.getBlockState().getValue(SmallShojiScreen.FACING).toYRot();
        poseStack.mulPose(Axis.YP.rotationDegrees(angle));
        poseStack.mulPose(Axis.XP.rotationDegrees(180));

        VertexConsumer vertexconsumer = buffer.getBuffer(frame.renderType(frame.getTextureLocation(entity.getWoodColor())));
        frame.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        // Note: We only render the screen (in its full) for the bottom half of the double-height block.
        if (screen != null) {
            if (entity.getScreen() == null) {
                screen.setInvisible();
            } else {
                screen.setVisible();
                VertexConsumer screenVertexConsumer = buffer.getBuffer(screen.renderType(screen.getTextureLocation(entity.getScreen())));
                screen.renderToBuffer(poseStack, screenVertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
        poseStack.popPose();
    }
}