package com.deku.eastwardjourneys.server.network.handlers;

import com.deku.eastwardjourneys.Main;
import com.deku.eastwardjourneys.client.network.messages.DoubleJumpClientMessage;
import com.deku.eastwardjourneys.common.capabilities.DoubleJumpCapability;
import com.deku.eastwardjourneys.server.network.messages.DoubleJumpServerMessage;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.network.CustomPayloadEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.PacketDistributor;


public class DoubleJumpServerMessageHandler {
    /**
     * Handles a message containing information about a double jump performed by a player.
     * This checks that the message was received by the right side (server vs client), that the message contents are
     * valid, and that the network event was triggered by an actual player on this server.
     *
     * Assuming all of the above is true, the message is then processed by the network event context.
     *
     * @param message The message that was received by the server
     * @param context The network event context
     */
    public static void onMessageReceived(final DoubleJumpServerMessage message, CustomPayloadEvent.Context context) {
        LogicalSide sideReceived = context.getDirection().getReceptionSide();
        context.setPacketHandled(true);

        if (sideReceived != LogicalSide.SERVER) {
            Main.LOGGER.error("DoubleJumpServerMessage received on wrong side: " + context.getDirection().getReceptionSide());
            return;
        }
        if (!message.isValid()) {
            Main.LOGGER.error("DoubleJumpServerMessge was invalid: " + message);
            return;
        }

        final ServerPlayer sendingPlayer = context.getSender();
        if (sendingPlayer == null) {
            Main.LOGGER.error("Sending player was null when double jump message was received");
        }

        context.enqueueWork(() -> processMessage(message, sendingPlayer));
    }

    /**
     * Processing logic that happens on a double jump server message. This formulates a client message for the given
     * player and sends it on to their client so that they can be synced with the server. A capability is populated
     * server-side as well since this will be needed for the server to sync info with the clients on certain events
     * like re-logging
     *
     * This only syncs players within the same dimension that the double jump action was performed in.
     *
     * @param message
     * @param player
     */
    public static void processMessage(DoubleJumpServerMessage message, ServerPlayer player) {
        DoubleJumpClientMessage clientMessage = new DoubleJumpClientMessage(player.getUUID(), message.hasDoubleJumped());
        ResourceKey<Level> playerDimension = player.getCommandSenderWorld().dimension();

        DoubleJumpCapability.IDoubleJump doubleJumpCapability = player.getCapability(DoubleJumpCapability.DOUBLE_JUMP).orElse(null);
        if (doubleJumpCapability != null) {
            doubleJumpCapability.setHasDoubleJumped(message.hasDoubleJumped());
        }

        Main.networkChannel.send(clientMessage, PacketDistributor.DIMENSION.with(playerDimension));
    }
}
