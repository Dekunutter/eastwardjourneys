package com.deku.eastwardjourneys.client.models.shoji;

import com.deku.eastwardjourneys.common.items.ShojiPaper;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static com.deku.eastwardjourneys.Main.MOD_ID;


public class SmallShojiScreenModel extends AbstractShojiScreenModel {
    public SmallShojiScreenModel(ModelPart root) {
        this.bone = root.getChild("bone");
    }

    /**
     * Initializes the layer tied to this model, setting up its vertices and UVs
     *
     * @return Layer definition for this model
     */
    public static LayerDefinition createScreenLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -14.0F, 14.0F, 12.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    /**
     * Gets the texture for the shoji screen based on the screen placed into the shoji frame
     *
     * @param screen Shoji screen item that is being rendered
     * @return The resource location for the texture to apply to the model
     */
    @Override
    public ResourceLocation getTextureLocation(ItemStack screen) {
        return new ResourceLocation(MOD_ID, "textures/block/shoji/small/" + ShojiPaper.getPattern(screen) + ".png");
    }
}
