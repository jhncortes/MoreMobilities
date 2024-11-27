package net.jcortes.moremobilities.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
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
        //this.shadowRadius = 1f; // Adjust shadow size if needed
    }

    @Override
    public void render(@NotNull EntityBike entityBike, float rotation, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        poseStack.pushPose();
        //poseStack.scale(-1, -1, 1);
        poseStack.scale(-0.8f, -0.8f, 0.8f);
        poseStack.translate(0, -1.5, 0);
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation));

        //poseStack.mulPose(Axis.XP.rotationDegrees(180.0f));

        this.bikeModel.prepareMobModel(entityBike, 0.0f, 0.0f, partialTick);
        bikeModel.setupAnim(entityBike, partialTick, 0.0f, 0.0f, 0.0F, 0.0f);
        VertexConsumer vertexconsumer = buffer.getBuffer(bikeModel.renderType(TEXTURE_LOCATION));
        bikeModel.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);

        poseStack.popPose();
        super.render(entityBike, rotation, partialTick, poseStack, buffer, packedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull EntityBike bikeEntity) {
        return TEXTURE_LOCATION;
    }
}
