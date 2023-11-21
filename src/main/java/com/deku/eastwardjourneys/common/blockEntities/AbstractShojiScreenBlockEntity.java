package com.deku.eastwardjourneys.common.blockEntities;

import com.deku.eastwardjourneys.common.items.ShojiPaper;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractShojiScreenBlockEntity extends BlockEntity {
    private WoodColor color;
    private ItemStack screen = null;

    public enum WoodColor {
        STANDARD,
        DARK,
    }

    public AbstractShojiScreenBlockEntity(BlockEntityType<?> entityType, BlockPos position, BlockState state) {
        super(entityType, position, state);
    }

    public AbstractShojiScreenBlockEntity(BlockEntityType<?> entityType, BlockPos position, BlockState state, WoodColor color) {
        super(entityType, position, state);
        this.color = color;
    }

    /**
     * Loads NBT data into the block entity
     *
     * @param tag Compound tag holding any potential NBT data
     */
    public void load(CompoundTag tag) {
        if (tag == null) {
            screen = null;
            return;
        }

        super.load(tag);
        if (!tag.getCompound("Screen").isEmpty()) {
            CompoundTag screenTag = tag.getCompound("Screen");
            screen = ItemStack.of(screenTag);
        } else {
            screen = null;
        }

    }

    /**
     * Saves additional data as NBT to the block entity
     *
     * @param tag Compound tag to save any additional data under
     */
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (screen != null) {
            CompoundTag screenTag = new CompoundTag();
            tag.put("Screen", screen.save(screenTag));
        }
    }

    /**
     * Removes the screen currently inserted into this block entity
     */
    public void removeScreen() {
        if (screen != null) {
            screen = null;
            setChanged();
            // TODO: Block.UPDATE_NEIGHBORS may be more appropriate as an optimization so that it only syncs with clients in the current chunk? Others will get the data when entering the chunk
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
        }
    }

    /**
     * Removes the screen currently inserted into this block entity and spawns it as an item in the world for pick-up
     *
     * @return Whether we popped out a screen or not
     */
    public boolean popScreen() {
        if (screen != null) {
            // TODO: Popping is happening when the world is saved not when its reloaded! I guess that the despawning is counting as breaking!!
            ItemEntity itementity = new ItemEntity(level, getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ(), screen);
            level.addFreshEntity(itementity);
            removeScreen();
            return true;
        }
        return false;
    }

    /**
     * Gets the screen currently inserted into this block entity
     *
     * @return ItemStack for the shoji screen in this block entity
     */
    public ItemStack getScreen() {
        return screen;
    }

    /**
     * Sets a shoji screen into this block entity
     *
     * @param screen Itemstack for a shoji screen being set into this block entity
     * @return Boolean value denoting whether the item was inserted or rejected by this block entity
     */
    public boolean setScreen(ItemStack screen) {
        if (this.screen == null && screen.getItem() instanceof ShojiPaper) {
            this.screen = screen;
            setChanged();
            // update all serverside entity changes with the client
            // TODO: Block.UPDATE_NEIGHBORS may be more appropriate as an optimization so that it only syncs with clients in the current chunk? Others will get the data when entering the chunk
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
            return true;
        }
        return false;
    }

    /**
     * Gets the wood colour of the frame this block entity represents
     * @return Colour of the frame
     */
    public WoodColor getWoodColor() {
        return color;
    }

    /**
     * Syncs all data on the server to the client so that players can actually affect the block entity data for other players in the world
     *
     * @return NBT data tied to this block entity after saving changes
     */
    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }

    /**
     * Loads all saved data from the server to the client so that players can see the data from their client.
     * Technically don't need to override this since I'm not doing anything extra to the data being loaded.
     *
     * @param tag The {@link CompoundTag} sent from {@link BlockEntity#getUpdateTag()}
     */
    @Override
    public void handleUpdateTag(CompoundTag tag) {
        load(tag);
    }

    /**
     * Data packet used to sync data between server and clients for this block entity
     *
     * @return Data packet
     */
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    /**
     * Loads the data from a packet into the client
     * Technically don't need to override this since I'm not doing anything extra to the data being loaded
     *
     * @param connection The NetworkManager the packet originated from
     * @param packet The data packet
     */
    @Override
    public void onDataPacket(Connection connection, ClientboundBlockEntityDataPacket packet) {
        handleUpdateTag(packet.getTag());
    }
}
