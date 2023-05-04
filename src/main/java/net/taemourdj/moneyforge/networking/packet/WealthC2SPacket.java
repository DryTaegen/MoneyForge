package net.taemourdj.moneyforge.networking.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.taemourdj.moneyforge.wealth.PlayerWealth;
import net.taemourdj.moneyforge.wealth.PlayerWealthProvider;

import java.util.function.Supplier;

public class WealthC2SPacket {
    private static final String MESSAGE_GAIN_WEALTH = "message.moneyforge.gain_wealth";
    public WealthC2SPacket() {

    }
    public WealthC2SPacket(FriendlyByteBuf buf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            //on the server
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            //Notify the player
            player.sendSystemMessage(Component.translatable(MESSAGE_GAIN_WEALTH).withStyle(ChatFormatting.GOLD));
            //Increase player wealth
            player.getCapability(PlayerWealthProvider.PLAYER_WEALTH).ifPresent(wealth -> {
                wealth.addWealth(1);
                player.sendSystemMessage(Component.literal("Current wealth: " + wealth.getWealth())
                        .withStyle(ChatFormatting.GOLD));
            });
        });
        return true;
    }
}
