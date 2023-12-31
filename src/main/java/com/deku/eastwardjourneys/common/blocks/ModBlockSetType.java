package com.deku.eastwardjourneys.common.blocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModBlockSetType {
    public static BlockSetType MAPLE = new BlockSetType(new ResourceLocation(MOD_ID, "maple").toString());
    public static BlockSetType BLACK_PINE = new BlockSetType(new ResourceLocation(MOD_ID, "black_pine").toString());
    public static BlockSetType HINOKI = new BlockSetType(new ResourceLocation(MOD_ID, "hinoki").toString());
    public static BlockSetType WATER_FIR = new BlockSetType(new ResourceLocation(MOD_ID, "water_fir").toString());
    public static BlockSetType SAXAUL = new BlockSetType(new ResourceLocation(MOD_ID, "saxaul").toString());
}
