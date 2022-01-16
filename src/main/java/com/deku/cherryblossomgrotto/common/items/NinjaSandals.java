package com.deku.cherryblossomgrotto.common.items;

import com.deku.cherryblossomgrotto.client.models.NinjaSuitModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;

public class NinjaSandals extends ArmorItem {
    private NinjaSuitModel armorModel;

    public NinjaSandals() {
        super(ModArmorMaterial.WOOL, EquipmentSlotType.FEET, new Item.Properties().tab(ItemGroup.TAB_COMBAT));
        setRegistryName("ninja_sandals");
        armorModel = new NinjaSuitModel();
    }

    /**
     * Gets the model for this piece of armour once it has been equipped
     *
     * @param entity The entity equipping this piece of armour
     * @param itemStack The item stack this item came from
     * @param armorSlot The slot the armour is being equipped in
     * @param defaultArmor The default armour model for this entity
     * @return The armour model of the equipped piece of armour
     */
    @Override
    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
        return armorModel.applyEntityStats(defaultArmor).applySlot(armorSlot);
    }

    /**
     * Gets the texture for this piece of armour
     *
     * @param stack The item stack this item came from
     * @param entity The entity equipping this piece of armour
     * @param slot The slot the armour is being equipped in
     * @param type Whether the texture is a default texture (null) or an overlay (overlay)
     * @return The resource location for this texture
     */
    @Override
    public final String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return armorModel.getTexture();
    }
}
