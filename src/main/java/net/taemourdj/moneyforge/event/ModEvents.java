package net.taemourdj.moneyforge.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.taemourdj.moneyforge.MoneyForge;
import net.taemourdj.moneyforge.wealth.PlayerWealth;
import net.taemourdj.moneyforge.wealth.PlayerWealthProvider;



@Mod.EventBusSubscriber(modid = MoneyForge.MOD_ID)
public class ModEvents {

    //Attaches the wealth value to the player
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerWealthProvider.PLAYER_WEALTH).isPresent()) {
                event.addCapability(new ResourceLocation(MoneyForge.MOD_ID, "properties"), new PlayerWealthProvider());
            }
        }
    }


    //If the player dies, the wealth doesn't get reset.
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerWealthProvider.PLAYER_WEALTH).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerWealthProvider.PLAYER_WEALTH).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerWealth.class);
    }


}
