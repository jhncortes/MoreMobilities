package net.jcortes.moremobilities.event;


import net.jcortes.moremobilities.MoreMobilities;
import net.jcortes.moremobilities.entity.EntityRegistry;
import net.jcortes.moremobilities.entity.client.BikeRenderer;
import net.jcortes.moremobilities.entity.client.ModModelLayers;
import net.jcortes.moremobilities.entity.client.ModelBike;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreMobilities.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayerDefinitionEvent(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.BIKE_LAYER, ModelBike::createBodyLayer);


    }

    @SubscribeEvent
    public static void registerRendererEvent(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegistry.BIKE.get(), BikeRenderer::new);
    }
}