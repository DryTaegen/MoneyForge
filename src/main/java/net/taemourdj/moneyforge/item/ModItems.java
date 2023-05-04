package net.taemourdj.moneyforge.item;

import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.taemourdj.moneyforge.MoneyForge;
import net.taemourdj.moneyforge.item.custom.CoinItem;

import static net.minecraft.world.flag.FeatureFlags.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoneyForge.MOD_ID);

    public static final RegistryObject<Item> COIN = ITEMS.register("coin",
            () -> new CoinItem(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    };

}
