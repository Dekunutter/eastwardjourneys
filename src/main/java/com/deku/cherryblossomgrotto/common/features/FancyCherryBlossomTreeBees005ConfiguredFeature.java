package com.deku.cherryblossomgrotto.common.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;

public class FancyCherryBlossomTreeBees005ConfiguredFeature extends ConfiguredFeature<BaseTreeFeatureConfig, Feature<BaseTreeFeatureConfig>> {
    public FancyCherryBlossomTreeBees005ConfiguredFeature() {
        super(Feature.TREE, ModConfiguredFeatures.FANCY_CHERRY_TREE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005)));
    }
}