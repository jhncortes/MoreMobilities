package net.jcortes.moremobilities.item;

import net.jcortes.moremobilities.MoreMobilities;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreMobilities.MODID);

    public static final RegistryObject<CreativeModeTab> MORE_MOBILITIES_TAB = CREATIVE_MODE_TABS.register("more_mobilities_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WHEEL.get()))
                    .title(Component.translatable("creativetab.more_mobilities_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.WHEEL.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
