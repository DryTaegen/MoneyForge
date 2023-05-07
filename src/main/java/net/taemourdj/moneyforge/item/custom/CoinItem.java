package net.taemourdj.moneyforge.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.taemourdj.moneyforge.networking.ModMessages;
import net.taemourdj.moneyforge.networking.packet.WealthC2SPacket;

public class CoinItem extends Item {
    public CoinItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        //If coin is in player's hand and they interact with it
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            //increase player wealth
            ModMessages.sendToServer(new WealthC2SPacket());
            player.getItemInHand(hand).shrink(1);


        }


        return super.use(level, player, hand);
    }
}
