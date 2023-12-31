package com.deku.eastwardjourneys.common.enchantments;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModEnchantmentInitializer {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MOD_ID);

    public static final RegistryObject<Enchantment> DOUBLE_JUMP_ENCHANTMENT = ENCHANTMENTS.register("double_jump", DoubleJumpEnchantment::new);
}
