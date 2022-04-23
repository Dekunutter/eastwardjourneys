package com.deku.cherryblossomgrotto.common.blocks;

import com.deku.cherryblossomgrotto.common.entity.sign.ModSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class CherryBlossomSign extends StandingSignBlock {
    public CherryBlossomSign() {
        super(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_RED).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.CHERRY_BLOSSOM);
        setRegistryName("cherry_blossom_sign");
    }

    /**
     * Gets the sign block entity for this sign
     *
     * @param position Position of the sign in the level
     * @param blockState State of the sign
     * @return The block entity for this sign
     */
    @Override
    public BlockEntity newBlockEntity(BlockPos position, BlockState blockState) {
        return new ModSignBlockEntity(position, blockState);
    }
}
