package com.deku.cherryblossomgrotto.common.blocks.black_pine;

import com.deku.cherryblossomgrotto.common.blocks.ModWoodType;
import com.deku.cherryblossomgrotto.common.entity.sign.ModHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class BlackPineHangingSign  extends CeilingHangingSignBlock {
    public BlackPineHangingSign() {
        super(Properties.of().noCollission().strength(1.0F).mapColor(MapColor.WOOD).ignitedByLava().sound(SoundType.HANGING_SIGN).instrument(NoteBlockInstrument.BASS), ModWoodType.BLACK_PINE);
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
