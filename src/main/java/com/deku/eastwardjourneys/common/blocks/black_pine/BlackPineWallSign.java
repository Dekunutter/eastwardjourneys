package com.deku.eastwardjourneys.common.blocks.black_pine;

import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;
import com.deku.eastwardjourneys.common.blocks.ModWoodType;
import com.deku.eastwardjourneys.common.entity.sign.ModSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class BlackPineWallSign extends WallSignBlock {
    public BlackPineWallSign() {
        super(ModWoodType.BLACK_PINE, Properties.of().noCollission().strength(1.0F).mapColor(MapColor.WOOD).ignitedByLava().sound(SoundType.WOOD).instrument(NoteBlockInstrument.BASS).lootFrom(() -> ModBlockInitializer.BLACK_PINE_SIGN.get()));
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
