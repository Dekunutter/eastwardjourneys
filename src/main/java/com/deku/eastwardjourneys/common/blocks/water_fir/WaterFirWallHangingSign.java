package com.deku.eastwardjourneys.common.blocks.water_fir;

import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;
import com.deku.eastwardjourneys.common.blocks.ModWoodType;
import com.deku.eastwardjourneys.common.entity.sign.ModHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class WaterFirWallHangingSign extends WallHangingSignBlock {
    public WaterFirWallHangingSign() {
        super(ModWoodType.WATER_FIR, Properties.of().mapColor(MapColor.TERRACOTTA_RED).ignitedByLava().sound(SoundType.HANGING_SIGN).instrument(NoteBlockInstrument.BASS).lootFrom(() -> ModBlockInitializer.WATER_FIR_HANGING_SIGN.get()));
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
        return new ModHangingSignBlockEntity(position, blockState);
    }
}
