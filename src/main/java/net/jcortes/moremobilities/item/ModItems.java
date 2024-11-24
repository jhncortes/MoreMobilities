package net.jcortes.moremobilities.item;

import net.jcortes.moremobilities.MoreMobilities;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreMobilities.MODID);

    public static final RegistryObject<Item> WHEEL = ITEMS.register("wheel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BIKE_ITEM = ITEMS.register("bike_item", () -> new ItemMobility(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
