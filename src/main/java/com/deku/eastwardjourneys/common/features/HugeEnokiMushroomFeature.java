package com.deku.eastwardjourneys.common.features;

import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;
import com.deku.eastwardjourneys.common.blocks.ModBlockTags;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class HugeEnokiMushroomFeature extends AbstractHugeMushroomFeature {
    public HugeEnokiMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    protected int getTreeHeight(RandomSource random) {
        return random.nextInt(6) + 8;
    }

    @Override
    protected int getTreeRadiusForHeight(int min, int max, int foliageRadius, int height) {
        int i = 0;
        if (height < max && height >= max - 3) {
            i = foliageRadius;
        } else if (height == max) {
            i = foliageRadius;
        }

        return i;
    }

    // NOTE: Only overridden to change the valid blocks that the mushroom can spawn on
    @Override
    protected boolean isValidPosition(LevelAccessor p_65099_, BlockPos p_65100_, int p_65101_, BlockPos.MutableBlockPos p_65102_, HugeMushroomFeatureConfiguration p_65103_) {
        int i = p_65100_.getY();
        if (i >= p_65099_.getMinBuildHeight() + 1 && i + p_65101_ + 1 < p_65099_.getMaxBuildHeight()) {
            BlockState blockstate = p_65099_.getBlockState(p_65100_.below());

            if (!isDirt(blockstate) && !blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK)  && !blockstate.is(ModBlockTags.MUSHROOM_GROW_BLOCK_WOOD)) {
                return false;
            } else {
                for(int j = 0; j <= p_65101_; ++j) {
                    int k = this.getTreeRadiusForHeight(-1, -1, p_65103_.foliageRadius, j);

                    for(int l = -k; l <= k; ++l) {
                        for(int i1 = -k; i1 <= k; ++i1) {
                            BlockState blockstate1 = p_65099_.getBlockState(p_65102_.setWithOffset(p_65100_, l, j, i1));
                            if (!blockstate1.isAir() && !blockstate1.is(BlockTags.LEAVES) && !blockstate1.is(ModBlockInitializer.ENOKI_MUSHROOM.get())) {
                                return false;
                            }
                        }
                    }
                }

                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    protected void makeCap(LevelAccessor levelAccessor, RandomSource random, BlockPos position, int height, BlockPos.MutableBlockPos mutablePosition, HugeMushroomFeatureConfiguration configuration) {
        for(int i = height - 3; i <= height; ++i) {
            int j = i < height ? configuration.foliageRadius : configuration.foliageRadius - 1;
            int k = configuration.foliageRadius - 2;

            for(int l = -j; l <= j; ++l) {
                for(int i1 = -j; i1 <= j; ++i1) {
                    boolean flag = l == -j;
                    boolean flag1 = l == j;
                    boolean flag2 = i1 == -j;
                    boolean flag3 = i1 == j;
                    boolean flag4 = flag || flag1;
                    boolean flag5 = flag2 || flag3;
                    if (i >= height || flag4 != flag5) {
                        mutablePosition.setWithOffset(position, l, i, i1);
                        if (!levelAccessor.getBlockState(mutablePosition).isSolidRender(levelAccessor, mutablePosition)) {
                            BlockState blockstate = configuration.capProvider.getState(random, position);
                            if (blockstate.hasProperty(HugeMushroomBlock.WEST) && blockstate.hasProperty(HugeMushroomBlock.EAST) && blockstate.hasProperty(HugeMushroomBlock.NORTH) && blockstate.hasProperty(HugeMushroomBlock.SOUTH) && blockstate.hasProperty(HugeMushroomBlock.UP)) {
                                blockstate = blockstate.setValue(HugeMushroomBlock.UP, Boolean.valueOf(i >= height - 1)).setValue(HugeMushroomBlock.WEST, Boolean.valueOf(l < -k)).setValue(HugeMushroomBlock.EAST, Boolean.valueOf(l > k)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(i1 < -k)).setValue(HugeMushroomBlock.SOUTH, Boolean.valueOf(i1 > k));
                            }

                            this.setBlock(levelAccessor, mutablePosition, blockstate);
                        }
                    }
                }
            }
        }
    }
}
