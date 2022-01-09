package com.deku.cherryblossomgrotto.client;

import com.deku.cherryblossomgrotto.common.entity.projectile.ShurikenEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;

import static com.deku.cherryblossomgrotto.Main.MOD_ID;

public class ShurikenRenderer extends EntityRenderer<ShurikenEntity> {
    private static final float RENDERED_SCALE_X  = 0.028125f;
    private static final float RENDERED_SCALE_Y = 0.05625F;
    private static final float RENDERED_SCALE_Z = 0.05625F;

    public ShurikenRenderer(EntityRendererManager rendererManager) {
        super(rendererManager);
    }

    /**
     * Gets the location of the texture to be rendered by this renderable
     *
     * @param entity The entity the texture is being applied to
     * @return The location of the texture resource
     */
    @Override
    public ResourceLocation getTextureLocation(ShurikenEntity entity) {
        return new ResourceLocation(MOD_ID, "textures/item/shuriken.png");
    }

    /**
     * Renders the shuriken entity into the world, applying its texture to its position.
     * This pushes a render stack into memory, performs all necessary operations and then pops it out of the stack
     * to pass it into a final renderer.
     *
     * @param entity The shuriken entity to be rendered
     * @param yaw Rotation of the entity around the yaw axis
     * @param partialTicks The time through the current tick of the entity
     * @param matrixStack The rendering stack that holds the rendering co-ordinates of the entity
     * @param buffer Render buffer
     * @param packedLight Light affecting the entity
     */
    @Override
    public void render(ShurikenEntity entity, float yaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
        matrixStack.pushPose();

        matrixStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
        matrixStack.scale(RENDERED_SCALE_X, RENDERED_SCALE_Y, RENDERED_SCALE_Z);

        applyInFlightSpin(entity, matrixStack);

        IVertexBuilder vertexBuilder = buffer.getBuffer(RenderType.entityCutout(this.getTextureLocation(entity)));
        MatrixStack.Entry stackEntry = matrixStack.last();
        Matrix4f positionMatrix = stackEntry.pose();
        Matrix3f normalMatrix = stackEntry.normal();

        renderRightSideFace(positionMatrix, normalMatrix, vertexBuilder, packedLight);
        renderLeftSideFace(positionMatrix, normalMatrix, vertexBuilder, packedLight);

        matrixStack.popPose();
        super.render(entity, yaw, partialTicks, matrixStack, buffer, packedLight);
    }

    /**
     * Applies additional rotation around the Z axis pivot while in flight to give the appearance of it spinning through the air
     *
     * @param entity Entity to apply the spin to
     * @param matrixStack The rendering stack that holds the rendering co-ordinates of the entity
     */
    private void applyInFlightSpin(ShurikenEntity entity, MatrixStack matrixStack) {
        if (!entity.isOnGround()) {
            matrixStack.mulPose(Vector3f.ZP.rotationDegrees(entity.spin * 3.0F));
        }
    }

    /**
     * Renders the right side face of the entity.
     *
     * @param positionMatrix 4-dimensional matrix holding positional information on the entity
     * @param normalMatrix 3-dimensional matrix holding normal data about the entity for rendering
     * @param vertexBuilder Builder for the vertices
     * @param packedLight Light affecting the entity
     */
    private void renderRightSideFace(Matrix4f positionMatrix, Matrix3f normalMatrix, IVertexBuilder vertexBuilder, int packedLight) {
        vertex(positionMatrix, normalMatrix, vertexBuilder, -4, 0, 0, 0.0F, 0.0F, 0, 1, 0, packedLight);
        vertex(positionMatrix, normalMatrix, vertexBuilder, 4, 0, 0, 1.0F, 0.0F, 0, 1, 0, packedLight);
        vertex(positionMatrix, normalMatrix, vertexBuilder, 4, 4, 0, 1.0F, 1.0F, 0, 1, 0, packedLight);
        vertex(positionMatrix, normalMatrix, vertexBuilder, -4, 4, 0, 0.0F, 1.0F, 0, 1, 0, packedLight);
    }

    /**
     * Renders the left side face of the entity.
     *
     * @param positionMatrix 4-dimensional matrix holding positional information on the entity
     * @param normalMatrix 3-dimensional matrix holding normal data about the entity for rendering
     * @param vertexBuilder Builder for the vertices
     * @param packedLight Light affecting the entity
     */
    private void renderLeftSideFace(Matrix4f positionMatrix, Matrix3f normalMatrix, IVertexBuilder vertexBuilder, int packedLight) {
        vertex(positionMatrix, normalMatrix, vertexBuilder, -4, 4, 0, 0.0F, 0.0F, 0, -1, 0, packedLight);
        vertex(positionMatrix, normalMatrix, vertexBuilder, 4, 4, 0, 1.0F, 0.0F, 0, -1, 0, packedLight);
        vertex(positionMatrix, normalMatrix, vertexBuilder, 4, 0, 0, 1.0F, 1.0F, 0, -1, 0, packedLight);
        vertex(positionMatrix, normalMatrix, vertexBuilder, -4, 0, 0, 0.0F, 1.0F, 0, -1, 0, packedLight);
    }

    /**
     * Builds a given vertex by attaching all positional and rendering data to it
     *
     * @param positionMatrix 4-dimensional matrix holding positional information on the entity
     * @param normalMatrix 3-dimensional matrix holding normal data about the entity for rendering
     * @param vertexBuilder Builder for this vertex
     * @param positionX Position along the X axis that we want to place this vertex
     * @param positionY Position along the Y axis that we want to place this vertex
     * @param positionZ Position along the Z axis that we want to place this vertex
     * @param horizontalUV Decimal number on how much of the texture we want to stretch across this vertex horizontally
     * @param verticalUV Decimal number on how much of the texture we want to stretch acorss this vertex vertically
     * @param normalX The normal value for the X axis
     * @param normalY The normal value for the Y axis
     * @param normalZ The normal value for the Z axis
     * @param lightingUV Value for mapping lighting data to the vertex
     */
    private void vertex(Matrix4f positionMatrix, Matrix3f normalMatrix, IVertexBuilder vertexBuilder, int positionX, int positionY, int positionZ, float horizontalUV, float verticalUV, int normalX, int normalY, int normalZ, int lightingUV) {
        vertexBuilder.vertex(positionMatrix, (float)positionX, (float)positionY, (float)positionZ).color(255, 255, 255, 255).uv(horizontalUV, verticalUV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(lightingUV).normal(normalMatrix, (float)normalX, (float)normalZ, (float)normalY).endVertex();
    }
}
