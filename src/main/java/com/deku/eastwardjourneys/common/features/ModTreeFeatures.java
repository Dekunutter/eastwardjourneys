package com.deku.eastwardjourneys.common.features;

import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;
import com.deku.eastwardjourneys.common.features.decorators.ShiitakeMushroomDecorator;
import com.deku.eastwardjourneys.common.world.gen.foliagePlacers.BlackPineFoliagePlacer;
import com.deku.eastwardjourneys.common.world.gen.foliagePlacers.SaxaulFoliagePlacer;
import com.deku.eastwardjourneys.common.world.gen.trunkPlacers.BlackPineTrunkPlacer;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.OptionalInt;

import static com.deku.eastwardjourneys.Main.MOD_ID;

public class ModTreeFeatures {
    public static ResourceKey<ConfiguredFeature<?, ?>> FANCY_MAPLE_TREE = registerTreeFeatureKey("fancy_maple");
    public static ResourceKey<ConfiguredFeature<?, ?>> FANCY_MAPLE_TREE_BEES = registerTreeFeatureKey("fancy_maple_bees");

    public static ResourceKey<ConfiguredFeature<?, ?>> BLACK_PINE = registerTreeFeatureKey("black_pine");
    public static ResourceKey<ConfiguredFeature<?, ?>> STRAIGHT_BLACK_PINE = registerTreeFeatureKey("straight_black_pine");

    public static ResourceKey<ConfiguredFeature<?, ?>> HINOKI = registerTreeFeatureKey("hinoki");
    public static ResourceKey<ConfiguredFeature<?, ?>> HINOKI_BEES = registerTreeFeatureKey("hinoki_bees");

    public static ResourceKey<ConfiguredFeature<?, ?>> WATER_FIR = registerTreeFeatureKey("water_fir");
    public static ResourceKey<ConfiguredFeature<?, ?>> WATER_FIR_BEES = registerTreeFeatureKey("water_fir_bees");

    public static ResourceKey<ConfiguredFeature<?, ?>> MEGA_WATER_FIR = registerTreeFeatureKey("mega_water_fir");

    public static ResourceKey<ConfiguredFeature<?, ?>> SAXAUL = registerTreeFeatureKey("saxaul");

    public static ResourceKey<ConfiguredFeature<?, ?>> LARGE_SAXAUL = registerTreeFeatureKey("large_saxaul");

    public static ResourceKey<ConfiguredFeature<?, ?>> HUGE_ENOKI_MUSHROOM = registerTreeFeatureKey("huge_enoki_mushroom");

    public static ResourceKey<ConfiguredFeature<?, ?>> HUGE_SHIITAKE_MUSHROOM = registerTreeFeatureKey("huge_shiitake_mushroom");



    /**
     * Registers a resource key for the given tree feature name
     *
     * @param featureName Name of the feature we want to create a resource key for
     * @return The resource key created for the given feature
     */
    public static ResourceKey<ConfiguredFeature<?, ?>> registerTreeFeatureKey(String featureName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MOD_ID, featureName));
    }

    /**
     * Configures a maple tree
     *
     * @return The configuration for a maple tree
     */
    private static TreeConfiguration.TreeConfigurationBuilder createFancyMapleTreeConfiguration() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockInitializer.MAPLE_LOG.get()),
                new FancyTrunkPlacer(3, 11, 0),
                BlockStateProvider.simple(ModBlockInitializer.MAPLE_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
        ).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createBlackPineTreeConfiguration() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockInitializer.BLACK_PINE_LOG.get()),
                new BlackPineTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ModBlockInitializer.BLACK_PINE_LEAVES.get()),
                new BlackPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(1)),
                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlackPineTreeConfiguration() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockInitializer.BLACK_PINE_LOG.get()),
                new StraightTrunkPlacer(5, 2, 1),
                BlockStateProvider.simple(ModBlockInitializer.BLACK_PINE_LEAVES.get()),
                new SpruceFoliagePlacer(UniformInt.of(2, 0), UniformInt.of(3, 2), UniformInt.of(2, 1)),
                new TwoLayersFeatureSize(2, 0, 2)
        ).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createHinokiTreeConfiguration() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockInitializer.HINOKI_LOG.get()),
                new StraightTrunkPlacer(7, 4, 2),
                BlockStateProvider.simple(ModBlockInitializer.HINOKI_LEAVES.get()),
                new SpruceFoliagePlacer(UniformInt.of(2, 0), UniformInt.of(3, 2), UniformInt.of(2, 1)),
                new TwoLayersFeatureSize(2, 0, 2)
        ).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createWaterFirTreeConfiguration() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockInitializer.WATER_FIR_LOG.get()),
                new StraightTrunkPlacer(7, 4, 2),
                BlockStateProvider.simple(ModBlockInitializer.WATER_FIR_LEAVES.get()),
                new SpruceFoliagePlacer(UniformInt.of(2, 0), UniformInt.of(3, 2), UniformInt.of(2, 1)),
                new TwoLayersFeatureSize(2, 0, 2)
        ).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createMegaWaterFirTreeConfiguration() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockInitializer.WATER_FIR_LOG.get()),
                new GiantTrunkPlacer(15, 2, 16),
                BlockStateProvider.simple(ModBlockInitializer.WATER_FIR_LEAVES.get()),
                new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)),
                new TwoLayersFeatureSize(1, 1, 2)
        ).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createSaxaulTreeConfiguration() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockInitializer.SAXAUL_LOG.get()),
                new ForkingTrunkPlacer(2, 2, 0),
                BlockStateProvider.simple(ModBlockInitializer.SAXAUL_LEAVES.get()),
                new SaxaulFoliagePlacer(ConstantInt.of(0), ConstantInt.of(1)),
                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createLargeSaxaulTreeConfiguration() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockInitializer.SAXAUL_LOG.get()),
                new ForkingTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ModBlockInitializer.SAXAUL_LEAVES.get()),
                new SaxaulFoliagePlacer(ConstantInt.of(0), ConstantInt.of(1)),
                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines();
    }

    /**
     * Registers tree features using the bootstrap context
     *
     * @param context The bootstrap context
     */
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        BeehiveDecorator beehiveDecorator002 = new BeehiveDecorator(0.002F);
        BeehiveDecorator beehiveDecorator02 = new BeehiveDecorator(0.02F);
        BeehiveDecorator beehiveDecorator05 = new BeehiveDecorator(0.05F);
        BeehiveDecorator beehiveDecorator25 = new BeehiveDecorator(0.25F);

        context.register(FANCY_MAPLE_TREE_BEES, new ConfiguredFeature<>(Feature.TREE, createFancyMapleTreeConfiguration().decorators(ImmutableList.of(beehiveDecorator25)).build()));

        context.register(BLACK_PINE, new ConfiguredFeature<>(Feature.TREE, createBlackPineTreeConfiguration().build()));
        context.register(STRAIGHT_BLACK_PINE, new ConfiguredFeature<>(Feature.TREE, createStraightBlackPineTreeConfiguration().build()));

        context.register(HINOKI, new ConfiguredFeature<>(Feature.TREE, createHinokiTreeConfiguration().build()));
        context.register(HINOKI_BEES, new ConfiguredFeature<>(Feature.TREE, createHinokiTreeConfiguration().decorators(ImmutableList.of(beehiveDecorator05)).build()));

        context.register(WATER_FIR, new ConfiguredFeature<>(Feature.TREE, createWaterFirTreeConfiguration().build()));
        context.register(WATER_FIR_BEES, new ConfiguredFeature<>(Feature.TREE, createWaterFirTreeConfiguration().decorators(ImmutableList.of(beehiveDecorator02)).build()));
        context.register(MEGA_WATER_FIR, new ConfiguredFeature<>(Feature.TREE, createMegaWaterFirTreeConfiguration().decorators(ImmutableList.of(new ShiitakeMushroomDecorator(0.4F), new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL)))).build()));

        context.register(SAXAUL, new ConfiguredFeature<>(Feature.TREE, createSaxaulTreeConfiguration().build()));
        context.register(LARGE_SAXAUL, new ConfiguredFeature<>(Feature.TREE, createLargeSaxaulTreeConfiguration().build()));
    }
}
