package net.jcortes.moremobilities.entity.client;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ModelBike<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	//public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("moremobilities", "modelbike"), "main");
	private final ModelPart bike;
	private final ModelPart bar;
	private final ModelPart lights;
	private final ModelPart wheel_f;
	private final ModelPart base;
	private final ModelPart wheel_b;

	public ModelBike(ModelPart root) {
		this.bike = root.getChild("bike");
		this.bar = this.bike.getChild("bar");
		this.lights = this.bar.getChild("lights");
		this.wheel_f = this.bar.getChild("wheel_f");
		this.base = this.bike.getChild("base");
		this.wheel_b = root.getChild("wheel_b");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bike = partdefinition.addOrReplaceChild("bike", CubeListBuilder.create(), PartPose.offset(-0.5F, 22.25F, 0.0F));

		PartDefinition bar = bike.addOrReplaceChild("bar", CubeListBuilder.create().texOffs(16, 63).addBox(2.5F, 13.2F, -3.06F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 63).addBox(2.5F, 13.2F, 1.26F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 49).addBox(3.0F, 13.7F, -3.04F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(10.455F, -22.4F, 0.0F));

		PartDefinition cube_r1 = bar.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, 52).addBox(1.1F, -1.9F, -5.64F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 49).addBox(1.1F, -1.9F, 7.64F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, -11.0F, -1.5F, 0.0F, 0.0F, -0.0262F));

		PartDefinition cube_r2 = bar.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 76).addBox(2.0F, -1.0F, -14.04F, 1.0F, 1.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, -11.4F, 2.7F, 0.0F, 0.0F, -0.0262F));

		PartDefinition cube_r3 = bar.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(64, 11).addBox(1.8F, -0.7F, -4.24F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, -3.4F, 2.7F, 0.0F, 0.0F, -0.0262F));

		PartDefinition cube_r4 = bar.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(4, 49).addBox(-1.0F, -18.0F, -3.0F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 49).addBox(-1.0F, -18.0F, 1.12F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4F, 14.2F, 0.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r5 = bar.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(40, 63).addBox(1.6F, -2.0F, -3.84F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 63).addBox(1.6F, -2.0F, 0.94F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7F, -2.6F, 0.3F, 0.0F, 0.0F, -0.0262F));

		PartDefinition cube_r6 = bar.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(12, 63).addBox(-0.4115F, -7.4511F, -1.4F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -4.6F, -1.4F, 0.2182F, 0.0F, -0.0873F));

		PartDefinition cube_r7 = bar.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(28, 48).addBox(1.2F, -2.0F, -2.76F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, 1.5F, -0.3F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r8 = bar.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(8, 63).addBox(-0.4115F, -7.4511F, 0.22F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -4.6F, 1.4F, -0.2182F, 0.0F, -0.0873F));

		PartDefinition lights = bar.addOrReplaceChild("lights", CubeListBuilder.create(), PartPose.offset(4.6F, 1.4F, 0.3F));

		PartDefinition cube_r9 = lights.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(50, 56).addBox(-2.4F, -3.2F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, 0.2F, -0.3F, 0.0F, 0.0F, -0.1222F));

		PartDefinition wheel_f = bar.addOrReplaceChild("wheel_f", CubeListBuilder.create().texOffs(0, 43).addBox(0.0F, -3.0F, -1.0F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 27).addBox(-2.0F, -16.0F, -1.0F, 15.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 44).addBox(0.0F, -17.0F, -1.0F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.055F, 23.65F, -0.5F));

		PartDefinition base = bike.addOrReplaceChild("base", CubeListBuilder.create().texOffs(16, 63).addBox(-7.6005F, 3.1432F, -2.8829F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 63).addBox(-7.6005F, 3.1432F, 1.4371F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 49).addBox(-7.1005F, 3.6432F, -2.8629F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.4445F, -12.3432F, -0.1771F));

		PartDefinition cube_r10 = base.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(48, 6).addBox(-6.8F, -2.0F, -3.74F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(36, 33).addBox(-11.0F, -1.4F, -3.34F, 15.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4995F, -6.2568F, 2.6771F, 0.0F, 0.0F, -1.8457F));

		PartDefinition cube_r11 = base.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(37, 29).addBox(-12.7F, -1.4F, 1.84F, 17.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6995F, -6.2568F, -0.5229F, 0.0F, 0.0567F, -1.0603F));

		PartDefinition cube_r12 = base.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 4).addBox(-27.0F, -2.4F, -4.94F, 19.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.1995F, -9.6068F, 2.6771F, 0.0F, 0.0F, -0.0044F));

		PartDefinition cube_r13 = base.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(44, 48).addBox(-3.0F, -2.2F, -2.56F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.4995F, 5.1432F, -0.3229F, 0.0F, 0.0F, -0.0131F));

		PartDefinition cube_r14 = base.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(48, 4).addBox(-14.4F, -1.5F, 1.84F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.4995F, 5.2432F, -0.3229F, 0.0F, 0.0F, -0.0131F));

		PartDefinition cube_r15 = base.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-26.0F, -1.4F, -4.04F, 30.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.1995F, -8.6568F, 2.6771F, 0.0F, 0.0F, -0.0044F));

		PartDefinition cube_r16 = base.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 47).addBox(-14.4F, -1.5F, -3.14F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.4995F, 5.2432F, 0.6771F, 0.0F, 0.0F, -0.0131F));

		PartDefinition cube_r17 = base.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(36, 27).addBox(-14.0F, -1.4F, -3.14F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.4995F, -6.2568F, 1.6771F, 0.0F, 0.0F, -0.8858F));

		PartDefinition cube_r18 = base.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(37, 31).addBox(-12.7F, -1.4F, -2.94F, 17.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6995F, -6.2568F, 1.0771F, 0.0F, -0.0567F, -1.0603F));

		PartDefinition cube_r19 = base.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(36, 25).addBox(-14.0F, -1.4F, 1.84F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.4995F, -6.2568F, -1.3229F, 0.0F, 0.0F, -0.8858F));

		PartDefinition wheel_b = partdefinition.addOrReplaceChild("wheel_b", CubeListBuilder.create().texOffs(0, 43).mirror().addBox(-11.0F, -3.0F, -1.0F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 27).mirror().addBox(-13.0F, -16.0F, -1.0F, 15.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(28, 44).mirror().addBox(-11.0F, -17.0F, -1.0F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.1F, 23.5F, -0.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bike.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wheel_b.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}