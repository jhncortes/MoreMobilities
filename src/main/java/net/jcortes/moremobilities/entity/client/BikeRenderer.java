package net.jcortes.moremobilities.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.jcortes.moremobilities.MoreMobilities;
import net.jcortes.moremobilities.entity.EntityBike;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class BikeRenderer extends EntityRenderer<EntityBike> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(MoreMobilities.MODID, "textures/entity/bike.png");
    private final ModelBike<EntityBike> bikeModel;

    public BikeRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.bikeModel = new ModelBike<>(context.bakeLayer(ModModelLayers.BIKE_LAYER));
        this.shadowRadius = 0.8f; // Adjust shadow size if needed
    }

    @Override
    public void render(@NotNull EntityBike entityBike, float rotation, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        poseStack.pushPose();
        poseStack.translate(0.0F, 0.375F, 0.0F);
        bikeModel.setupAnim(entityBike, partialTick, 0F, 0F, 0F, 0F);
        // Render texture
        VertexConsumer vertexconsumer = buffer.getBuffer(bikeModel.renderType(TEXTURE_LOCATION));
        bikeModel.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
        super.render(entityBike, rotation, partialTick, poseStack, buffer, packedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull EntityBike bikeEntity) {
        return TEXTURE_LOCATION;
    }
}
