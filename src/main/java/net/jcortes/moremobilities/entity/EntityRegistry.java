package net.jcortes.moremobilities.entity;

import net.jcortes.moremobilities.MoreMobilities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MoreMobilities.MODID);

    public static final RegistryObject<EntityType<EntityBike>> BIKE =
            ENTITY_TYPES.register("bike", () -> EntityType.Builder.of(EntityBike::new, MobCategory.MISC)
                    .sized(1f, 1f).build("bike"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
