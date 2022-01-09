package com.deku.cherryblossomgrotto.common.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;

public class CherryBlossomTreeBees002ConfiguredFeature extends ConfiguredFeature<BaseTreeFeatureConfig, Feature<BaseTreeFeatureConfig>> {
    public CherryBlossomTreeBees002ConfiguredFeature() {
        super(Feature.TREE, ModFeatures.CHERRY_TREE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002)));
    }
}