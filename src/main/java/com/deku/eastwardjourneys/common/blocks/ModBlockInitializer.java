package com.deku.eastwardjourneys.common.blocks;

import com.deku.eastwardjourneys.common.blockEntities.ShojiScreenBlockEntity;
import com.deku.eastwardjourneys.common.blocks.black_pine.*;
import com.deku.eastwardjourneys.common.blocks.hinoki.*;
import com.deku.eastwardjourneys.common.blocks.maple.*;
import com.deku.eastwardjourneys.common.blocks.saxaul.*;
import com.deku.eastwardjourneys.common.blocks.water_fir.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModBlockInitializer {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    // ------ WOOD ------
    // MAPLE WOOD BLOCKS
    public static final RegistryObject<Block> MAPLE_LOG = BLOCKS.register("maple_log", MapleLog::new);
    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = BLOCKS.register("stripped_maple_log", StrippedMapleLog::new);
    public static final RegistryObject<Block> MAPLE_WOOD = BLOCKS.register("maple_wood", MapleWood::new);
    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = BLOCKS.register("stripped_maple_wood", StrippedMapleWood::new);
    public static final RegistryObject<Block> MAPLE_PLANKS = BLOCKS.register("maple_planks", MaplePlanks::new);
    public static final RegistryObject<Block> MAPLE_SLAB = BLOCKS.register("maple_slab", MapleSlab::new);
    public static final RegistryObject<Block> MAPLE_STAIRS = BLOCKS.register("maple_stairs", MapleStairs::new);
    public static final RegistryObject<Block> MAPLE_BUTTON = BLOCKS.register("maple_button", MapleButton::new);
    public static final RegistryObject<Block> MAPLE_FENCE = BLOCKS.register("maple_fence", MapleFence::new);
    public static final RegistryObject<Block> MAPLE_FENCE_GATE = BLOCKS.register("maple_fence_gate", MapleFenceGate::new);
    public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = BLOCKS.register("maple_pressure_plate", MaplePressurePlate::new);
    public static final RegistryObject<Block> MAPLE_SIGN = BLOCKS.register("maple_sign", MapleSign::new);
    public static final RegistryObject<Block> MAPLE_WALL_SIGN = BLOCKS.register("maple_wall_sign", MapleWallSign::new);
    public static final RegistryObject<Block> MAPLE_HANGING_SIGN = BLOCKS.register("maple_hanging_sign", MapleHangingSign::new);
    public static final RegistryObject<Block> MAPLE_WALL_HANGING_SIGN = BLOCKS.register("maple_wall_hanging_sign", MapleWallHangingSign::new);
    public static final RegistryObject<Block> MAPLE_DOOR = BLOCKS.register("maple_door", MapleDoor::new);
    public static final RegistryObject<Block> MAPLE_TRAPDOOR = BLOCKS.register("maple_trapdoor", MapleTrapDoor::new);
    public static final RegistryObject<Block> MAPLE_PLANKS_TRAPDOOR = BLOCKS.register("maple_planks_trapdoor", MaplePlanksTrapdoor::new);

    // MAPLE TREE BLOCKS
    public static final RegistryObject<Block> MAPLE_LEAVES = BLOCKS.register("maple_leaves", MapleLeaves::new);
    public static final RegistryObject<Block> MAPLE_LEAF_PILE = BLOCKS.register("maple_leaf_pile", MapleLeafPile::new);
    public static final RegistryObject<Block> MAPLE_SAPLING = BLOCKS.register("maple_sapling", MapleSapling::new);
    public static final RegistryObject<Block> POTTED_MAPLE_SAPLING = BLOCKS.register("potted_maple_sapling", PottedMapleSapling::new);


    // BLACK PINE WOOD BLOCKS
    public static final RegistryObject<Block> BLACK_PINE_LOG = BLOCKS.register("black_pine_log", BlackPineLog::new);
    public static final RegistryObject<Block> STRIPPED_BLACK_PINE_LOG = BLOCKS.register("stripped_black_pine_log", StrippedBlackPineLog::new);
    public static final RegistryObject<Block> BLACK_PINE_WOOD = BLOCKS.register("black_pine_wood", BlackPineWood::new);
    public static final RegistryObject<Block> STRIPPED_BLACK_PINE_WOOD = BLOCKS.register("stripped_black_pine_wood", StrippedBlackPineWood::new);
    public static final RegistryObject<Block> BLACK_PINE_PLANKS = BLOCKS.register("black_pine_planks", BlackPinePlanks::new);
    public static final RegistryObject<Block> BLACK_PINE_SLAB = BLOCKS.register("black_pine_slab", BlackPineSlab::new);
    public static final RegistryObject<Block> BLACK_PINE_STAIRS = BLOCKS.register("black_pine_stairs", BlackPineStairs::new);
    public static final RegistryObject<Block> BLACK_PINE_BUTTON = BLOCKS.register("black_pine_button", BlackPineButton::new);
    public static final RegistryObject<Block> BLACK_PINE_FENCE = BLOCKS.register("black_pine_fence", BlackPineFence::new);
    public static final RegistryObject<Block> BLACK_PINE_FENCE_GATE = BLOCKS.register("black_pine_fence_gate", BlackPineFenceGate::new);
    public static final RegistryObject<Block> BLACK_PINE_PRESSURE_PLATE = BLOCKS.register("black_pine_pressure_plate", BlackPinePressurePlate::new);
    public static final RegistryObject<Block> BLACK_PINE_SIGN = BLOCKS.register("black_pine_sign", BlackPineSign::new);
    public static final RegistryObject<Block> BLACK_PINE_WALL_SIGN = BLOCKS.register("black_pine_wall_sign", BlackPineWallSign::new);
    public static final RegistryObject<Block> BLACK_PINE_HANGING_SIGN = BLOCKS.register("black_pine_hanging_sign", BlackPineHangingSign::new);
    public static final RegistryObject<Block> BLACK_PINE_WALL_HANGING_SIGN = BLOCKS.register("black_pine_wall_hanging_sign", BlackPineWallHangingSign::new);
    public static final RegistryObject<Block> BLACK_PINE_DOOR = BLOCKS.register("black_pine_door", BlackPineDoor::new);
    public static final RegistryObject<Block> BLACK_PINE_TRAPDOOR = BLOCKS.register("black_pine_trapdoor", BlackPineTrapDoor::new);
    public static final RegistryObject<Block> BLACK_PINE_PLANKS_TRAPDOOR = BLOCKS.register("black_pine_planks_trapdoor", BlackPinePlanksTrapdoor::new);

    // BLACK PINE TREE BLOCKS
    public static final RegistryObject<Block> BLACK_PINE_LEAVES = BLOCKS.register("black_pine_leaves", BlackPineLeaves::new);
    public static final RegistryObject<Block> BLACK_PINE_SAPLING = BLOCKS.register("black_pine_sapling", BlackPineSapling::new);
    public static final RegistryObject<Block> POTTED_BLACK_PINE_SAPLING = BLOCKS.register("potted_black_pine_sapling", PottedBlackPineSapling::new);


    // HINOKI WOOD BLOCKS
    public static final RegistryObject<Block> HINOKI_LOG = BLOCKS.register("hinoki_log", HinokiLog::new);
    public static final RegistryObject<Block> STRIPPED_HINOKI_LOG = BLOCKS.register("stripped_hinoki_log", StrippedHinokiLog::new);
    public static final RegistryObject<Block> HINOKI_WOOD = BLOCKS.register("hinoki_wood", HinokiWood::new);
    public static final RegistryObject<Block> STRIPPED_HINOKI_WOOD = BLOCKS.register("stripped_hinoki_wood", StrippedHinokiWood::new);
    public static final RegistryObject<Block> HINOKI_PLANKS = BLOCKS.register("hinoki_planks", HinokiPlanks::new);
    public static final RegistryObject<Block> HINOKI_SLAB = BLOCKS.register("hinoki_slab", HinokiSlab::new);
    public static final RegistryObject<Block> HINOKI_STAIRS = BLOCKS.register("hinoki_stairs", HinokiStairs::new);
    public static final RegistryObject<Block> HINOKI_BUTTON = BLOCKS.register("hinoki_button", HinokiButton::new);
    public static final RegistryObject<Block> HINOKI_FENCE = BLOCKS.register("hinoki_fence", HinokiFence::new);
    public static final RegistryObject<Block> HINOKI_FENCE_GATE = BLOCKS.register("hinoki_fence_gate", HinokiFenceGate::new);
    public static final RegistryObject<Block> HINOKI_PRESSURE_PLATE = BLOCKS.register("hinoki_pressure_plate", HinokiPressurePlate::new);
    public static final RegistryObject<Block> HINOKI_SIGN = BLOCKS.register("hinoki_sign", HinokiSign::new);
    public static final RegistryObject<Block> HINOKI_WALL_SIGN = BLOCKS.register("hinoki_wall_sign", HinokiWallSign::new);
    public static final RegistryObject<Block> HINOKI_HANGING_SIGN = BLOCKS.register("hinoki_hanging_sign", HinokiHangingSign::new);
    public static final RegistryObject<Block> HINOKI_WALL_HANGING_SIGN = BLOCKS.register("hinoki_wall_hanging_sign", HinokiWallHangingSign::new);
    public static final RegistryObject<Block> HINOKI_DOOR = BLOCKS.register("hinoki_door", HinokiDoor::new);
    public static final RegistryObject<Block> HINOKI_TRAPDOOR = BLOCKS.register("hinoki_trapdoor", HinokiTrapDoor::new);
    public static final RegistryObject<Block> HINOKI_PLANKS_TRAPDOOR = BLOCKS.register("hinoki_planks_trapdoor", HinokiPlanksTrapdoor::new);

    // HINOKI TREE BLOCKS
    public static final RegistryObject<Block> HINOKI_LEAVES = BLOCKS.register("hinoki_leaves", HinokiLeaves::new);
    public static final RegistryObject<Block> HINOKI_SAPLING = BLOCKS.register("hinoki_sapling", HinokiSapling::new);
    public static final RegistryObject<Block> POTTED_HINOKI_SAPLING = BLOCKS.register("potted_hinoki_sapling", PottedHinokiSapling::new);


    // WATER FIR WOOD BLOCKS
    public static final RegistryObject<Block> WATER_FIR_LOG = BLOCKS.register("water_fir_log", WaterFirLog::new);
    public static final RegistryObject<Block> STRIPPED_WATER_FIR_LOG = BLOCKS.register("stripped_water_fir_log", StrippedWaterFirLog::new);
    public static final RegistryObject<Block> WATER_FIR_WOOD = BLOCKS.register("water_fir_wood", WaterFirWood::new);
    public static final RegistryObject<Block> STRIPPED_WATER_FIR_WOOD = BLOCKS.register("stripped_water_fir_wood", StrippedWaterFirWood::new);
    public static final RegistryObject<Block> WATER_FIR_PLANKS = BLOCKS.register("water_fir_planks", WaterFirPlanks::new);
    public static final RegistryObject<Block> WATER_FIR_SLAB = BLOCKS.register("water_fir_slab", WaterFirSlab::new);
    public static final RegistryObject<Block> WATER_FIR_STAIRS = BLOCKS.register("water_fir_stairs", WaterFirStairs::new);
    public static final RegistryObject<Block> WATER_FIR_BUTTON = BLOCKS.register("water_fir_button", WaterFirButton::new);
    public static final RegistryObject<Block> WATER_FIR_FENCE = BLOCKS.register("water_fir_fence", WaterFirFence::new);
    public static final RegistryObject<Block> WATER_FIR_FENCE_GATE = BLOCKS.register("water_fir_fence_gate", WaterFirFenceGate::new);
    public static final RegistryObject<Block> WATER_FIR_PRESSURE_PLATE = BLOCKS.register("water_fir_pressure_plate", WaterFirPressurePlate::new);
    public static final RegistryObject<Block> WATER_FIR_SIGN = BLOCKS.register("water_fir_sign", WaterFirSign::new);
    public static final RegistryObject<Block> WATER_FIR_WALL_SIGN = BLOCKS.register("water_fir_wall_sign", WaterFirWallSign::new);
    public static final RegistryObject<Block> WATER_FIR_HANGING_SIGN = BLOCKS.register("water_fir_hanging_sign", WaterFirHangingSign::new);
    public static final RegistryObject<Block> WATER_FIR_WALL_HANGING_SIGN = BLOCKS.register("water_fir_wall_hanging_sign", WaterFirWallHangingSign::new);
    public static final RegistryObject<Block> WATER_FIR_DOOR = BLOCKS.register("water_fir_door", WaterFirDoor::new);
    public static final RegistryObject<Block> WATER_FIR_TRAPDOOR = BLOCKS.register("water_fir_trapdoor", WaterFirTrapDoor::new);
    public static final RegistryObject<Block> WATER_FIR_PLANKS_TRAPDOOR = BLOCKS.register("water_fir_planks_trapdoor", WaterFirPlanksTrapdoor::new);

    // WATER FIR TREE BLOCKS
    public static final RegistryObject<Block> WATER_FIR_LEAVES = BLOCKS.register("water_fir_leaves", WaterFirLeaves::new);
    public static final RegistryObject<Block> AUTUMNAL_WATER_FIR_LEAVES = BLOCKS.register("autumnal_water_fir_leaves", AutumnalWaterFirLeaves::new);
    public static final RegistryObject<Block> WATER_FIR_SAPLING = BLOCKS.register("water_fir_sapling", WaterFirSapling::new);
    public static final RegistryObject<Block> POTTED_WATER_FIR_SAPLING = BLOCKS.register("potted_water_fir_sapling", PottedWaterFirSapling::new);

    // SAXAUL WOOD BLOCKS
    public static final RegistryObject<Block> SAXAUL_LOG = BLOCKS.register("saxaul_log", SaxaulLog::new);
    public static final RegistryObject<Block> STRIPPED_SAXAUL_LOG = BLOCKS.register("stripped_saxaul_log", StrippedSaxaulLog::new);
    public static final RegistryObject<Block> SAXAUL_WOOD = BLOCKS.register("saxaul_wood", SaxaulWood::new);
    public static final RegistryObject<Block> STRIPPED_SAXAUL_WOOD = BLOCKS.register("stripped_saxaul_wood", StrippedSaxaulWood::new);
    public static final RegistryObject<Block> SAXAUL_PLANKS = BLOCKS.register("saxaul_planks", SaxaulPlanks::new);
    public static final RegistryObject<Block> SAXAUL_SLAB = BLOCKS.register("saxaul_slab", SaxaulSlab::new);
    public static final RegistryObject<Block> SAXAUL_STAIRS = BLOCKS.register("saxaul_stairs", SaxaulStairs::new);
    public static final RegistryObject<Block> SAXAUL_BUTTON = BLOCKS.register("saxaul_button", SaxaulButton::new);
    public static final RegistryObject<Block> SAXAUL_FENCE = BLOCKS.register("saxaul_fence", SaxaulFence::new);
    public static final RegistryObject<Block> SAXAUL_FENCE_GATE = BLOCKS.register("saxaul_fence_gate", SaxaulFenceGate::new);
    public static final RegistryObject<Block> SAXAUL_PRESSURE_PLATE = BLOCKS.register("saxaul_pressure_plate", SaxaulPressurePlate::new);
    public static final RegistryObject<Block> SAXAUL_SIGN = BLOCKS.register("saxaul_sign", SaxaulSign::new);
    public static final RegistryObject<Block> SAXAUL_WALL_SIGN = BLOCKS.register("saxaul_wall_sign", SaxaulWallSign::new);
    public static final RegistryObject<Block> SAXAUL_HANGING_SIGN = BLOCKS.register("saxaul_hanging_sign", SaxaulHangingSign::new);
    public static final RegistryObject<Block> SAXAUL_WALL_HANGING_SIGN = BLOCKS.register("saxaul_wall_hanging_sign", SaxaulWallHangingSign::new);
    public static final RegistryObject<Block> SAXAUL_DOOR = BLOCKS.register("saxaul_door", SaxaulDoor::new);
    public static final RegistryObject<Block> SAXAUL_TRAPDOOR = BLOCKS.register("saxaul_trapdoor", SaxaulTrapDoor::new);
    public static final RegistryObject<Block> SAXAUL_PLANKS_TRAPDOOR = BLOCKS.register("saxaul_planks_trapdoor", SaxaulPlanksTrapdoor::new);

    // SAXAUL TREE BLOCKS
    public static final RegistryObject<Block> SAXAUL_LEAVES = BLOCKS.register("saxaul_leaves", SaxaulLeaves::new);
    public static final RegistryObject<Block> SAXAUL_SAPLING = BLOCKS.register("saxaul_sapling", SaxaulSapling::new);
    public static final RegistryObject<Block> POTTED_SAXAUL_SAPLING = BLOCKS.register("potted_saxaul_sapling", PottedSaxaulSapling::new);


    // ------ ARCHITECTURE ------
    // SHOJI SCREENS
    public static final RegistryObject<Block> SHOJI_SCREEN = BLOCKS.register("shoji_screen", () -> new ShojiScreen(ShojiScreenBlockEntity.FrameType.STANDARD, ShojiScreenBlockEntity.WoodColor.STANDARD));
    public static final RegistryObject<Block> SHOJI_SCREEN_DARK = BLOCKS.register("dark_shoji_screen", () -> new ShojiScreen(ShojiScreenBlockEntity.FrameType.STANDARD, ShojiScreenBlockEntity.WoodColor.DARK));
    public static final RegistryObject<Block> SHOJI_SCREEN_GRIDED = BLOCKS.register("shoji_screen_grided", () -> new ShojiScreen(ShojiScreenBlockEntity.FrameType.GRIDED, ShojiScreenBlockEntity.WoodColor.STANDARD));
    public static final RegistryObject<Block> SHOJI_SCREEN_DARK_GRIDED = BLOCKS.register("dark_shoji_screen_grided", () -> new ShojiScreen(ShojiScreenBlockEntity.FrameType.GRIDED, ShojiScreenBlockEntity.WoodColor.DARK));
    public static final RegistryObject<Block> SHOJI_SCREEN_GRIDED_HEAVY = BLOCKS.register("shoji_screen_grided_heavy", () -> new ShojiScreen(ShojiScreenBlockEntity.FrameType.GRIDED_HEAVY, ShojiScreenBlockEntity.WoodColor.STANDARD));
    public static final RegistryObject<Block> SHOJI_SCREEN_DARK_GRIDED_HEAVY = BLOCKS.register("dark_shoji_screen_grided_heavy", () -> new ShojiScreen(ShojiScreenBlockEntity.FrameType.GRIDED_HEAVY, ShojiScreenBlockEntity.WoodColor.DARK));
    public static final RegistryObject<Block> SMALL_SHOJI_SCREEN = BLOCKS.register("small_shoji_screen", () -> new SmallShojiScreen(ShojiScreenBlockEntity.WoodColor.STANDARD));
    public static final RegistryObject<Block> SMALL_SHOJI_SCREEN_DARK = BLOCKS.register("small_dark_shoji_screen", () -> new SmallShojiScreen(ShojiScreenBlockEntity.WoodColor.DARK));

    // TATAMI MATS
    public static final RegistryObject<Block> TATAMI_MAT = BLOCKS.register("tatami_mat", TatamiMat::new);
    public static final RegistryObject<Block> TATAMI_MAT_AGED = BLOCKS.register("aged_tatami_mat", AgedTatamiMat::new);
    public static final RegistryObject<Block> TATAMI_MAT_LONG = BLOCKS.register("long_tatami_mat", LongTatamiMat::new);
    public static final RegistryObject<Block> TATAMI_MAT_AGED_LONG = BLOCKS.register("long_aged_tatami_mat", LongAgedTatamiMat::new);

    // LANTERNS
    public static final RegistryObject<Block> ZEN_LANTERN = BLOCKS.register("zen_lantern", ZenLantern::new);
    public static final RegistryObject<Block> ZEN_LANTERN_SOUL = BLOCKS.register("soul_zen_lantern", SoulZenLantern::new);
    public static final RegistryObject<Block> PAPER_LANTERN = BLOCKS.register("paper_lantern", PaperLantern::new);

    // HIDDEN TRAPDOORS (VANILLA VARIANTS)
    public static final RegistryObject<Block> STONE_TRAPDOOR = BLOCKS.register("stone_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> SMOOTH_STONE_TRAPDOOR = BLOCKS.register("smooth_stone_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> COBBLESTONE_TRAPDOOR = BLOCKS.register("cobblestone_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> OAK_PLANKS_TRAPDOOR = BLOCKS.register("oak_planks_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> DARK_OAK_PLANKS_TRAPDOOR = BLOCKS.register("dark_oak_planks_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> ACACIA_PLANKS_TRAPDOOR = BLOCKS.register("acacia_planks_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> JUNGLE_PLANKS_TRAPDOOR = BLOCKS.register("jungle_planks_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> SPRUCE_PLANKS_TRAPDOOR = BLOCKS.register("spruce_planks_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> BIRCH_PLANKS_TRAPDOOR = BLOCKS.register("birch_planks_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> MANGROVE_PLANKS_TRAPDOOR = BLOCKS.register("mangrove_planks_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> BAMBOO_PLANKS_TRAPDOOR = BLOCKS.register("bamboo_planks_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> CHERRY_PLANKS_TRAPDOOR = BLOCKS.register("cherry_planks_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> WARPED_PLANKS_TRAPDOOR = BLOCKS.register("warped_planks_trapdoor", StoneTrapdoor::new);
    public static final RegistryObject<Block> CRIMSON_PLANKS_TRAPDOOR = BLOCKS.register("crimson_planks_trapdoor", StoneTrapdoor::new);

    // MISC
    public static final RegistryObject<Block> TERRACOTTA_WARRIOR_STATUE = BLOCKS.register("terracotta_warrior_statue", TerracottaWarriorStatue::new);
    public static final RegistryObject<Block> RED_FENCE = BLOCKS.register("red_fence", RedFence::new);
    public static final RegistryObject<Block> POLISHED_GRAVEL = BLOCKS.register("polished_gravel", PolishedGravel::new);


    // ------ NATURE ------
    // CROPS
    public static final RegistryObject<Block> RICE_PADDY = BLOCKS.register("rice_paddy", RicePaddy::new);

    // MUSHROOMS
    public static final RegistryObject<Block> ENOKI_MUSHROOM = BLOCKS.register("enoki_mushroom", EnokiMushroom::new);
    public static final RegistryObject<Block> SHIITAKE_MUSHROOM = BLOCKS.register("shiitake_mushroom", ShiitakeMushroom::new);
    public static final RegistryObject<Block> ENOKI_MUSHROOM_BLOCK = BLOCKS.register("enoki_mushroom_block", EnokiMushroomBlock::new);
    public static final RegistryObject<Block> POTTED_ENOKI_MUSHROOM = BLOCKS.register("potted_enoki_mushroom", PottedEnokiMushroom::new);
    public static final RegistryObject<Block> POTTED_SHIITAKE_MUSHROOM = BLOCKS.register("potted_shiitake_mushroom", PottedShiitakeMushroom::new);

    // CACTI
    public static final RegistryObject<Block> FLOWERING_CACTUS = BLOCKS.register("flowering_cactus", FloweringCactus::new);
    public static final RegistryObject<Block> POTTED_FLOWERING_CACTUS = BLOCKS.register("potted_flowering_cactus", PottedFloweringCactus::new);
}
