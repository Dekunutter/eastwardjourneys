package com.deku.eastwardjourneys.common.blocks;

import net.minecraft.core.particles.ParticleTypes;

public class SoulZenLantern extends AbstractZenLantern {
    private static int LIGHT_LEVEL = 11;
    public SoulZenLantern() {
        super(LIGHT_LEVEL, ParticleTypes.SOUL_FIRE_FLAME);
    }
}
