package com.deku.cherryblossomgrotto.common.world.gen.foliagePlacers;

import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

public class GrandCherryBlossomFoliagePlacerType extends FoliagePlacerType {
    public GrandCherryBlossomFoliagePlacerType() {
        super(GrandCherryBlossomFoliagePlacer.CODEC);
        setRegistryName("big_cherry_blossom_tree_foliage_placer");
    }
}