package net.jcortes.moremobilities.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH;


public class EntityBike extends Entity {


    private static final EntityDataAccessor<Float> HEALTH = SynchedEntityData.defineId(EntityBike.class, EntityDataSerializers.FLOAT);


    private static final float MAX_HEALTH = 10f;
    private static final float SPEED = 0.1f;
    private static final float TURN_SPEED = 1.6f;
    private static final float MAX_TURN = 6f;
    private static final float FRICTION = 0.8f;
    //private static final float DRIFTING_FRICTION = 0.9f;
    private static final float GRAVITY = 0.5f;

    private float targetRotation = 0;
    private float currentRotation = 0;
    public int forwardMotion = 1;

    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private float lerpYRot;
    private double lerpXRot;
    private float deltaRotation = 0;



    public EntityBike(EntityType<? extends EntityBike> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.blocksBuilding = true;
    }

    @Override
    public boolean isPickable() {
        return true;
    }


    @Override
    public LivingEntity getControllingPassenger() {
        return (LivingEntity) this.getFirstPassenger();
    }


    // Sends message to player in client side
    public void sendMessage(Player player, String message) {
        player.sendSystemMessage(Component.literal(message));
    }


    @Override
    @NotNull
    // Handles when player interacts with bike
    public  InteractionResult interact(Player player, InteractionHand hand) {
        if (!this.level().isClientSide) {
            sendMessage(player, "Interacted bike");
            return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public void lerpTo(double x, double y, double z, float rotation, float pitch, int posRotationIncrements, boolean teleport) {
        this.lerpX = x;
        this.lerpY = y;
        this.lerpZ = z;
        this.lerpYRot = rotation;
        //this.lerpXRot = (double)pitch;

        this.lerpSteps = 5;
    }


    private void tickLerp() {
        if (this.isControlledByLocalInstance()) {
            this.lerpSteps = 0;
            this.syncPacketPositionCodec(this.getX(), this.getY(), this.getZ());
        }

        if (this.lerpSteps > 0) {
            double x = this.getX() + (this.lerpX - this.getX()) / (double)this.lerpSteps;
            double y = this.getY() + (this.lerpY - this.getY()) / (double)this.lerpSteps;
            double z = this.getZ() + (this.lerpZ - this.getZ()) / (double)this.lerpSteps;
            float yRotation = this.getYRot() + (this.lerpYRot - this.getYRot()) / this.lerpSteps;

            //this.setYRot(this.getYRot() + (this.lerpX/ (float)this.lerpSteps);
            //this.setXRot(this.getXRot() + (float)(this.lerpXRot - (double)this.getXRot()) / (float)this.lerpSteps);
            --this.lerpSteps;
            this.setPos(x, y, z);
            this.setYRot(yRotation);
        }

    }



    private void controlEntity(Input input) {
        float forward = 0;
        float turn = 0;
        int turnMod = 1;

        if(input.up) {
            forward = SPEED;
        }

        if(input.down) {
            forward = -SPEED;
            turnMod = -1;
        }

        if(input.left) {
            turn = -TURN_SPEED * turnMod;
        }

        if(input.right) {
            turn = TURN_SPEED * turnMod;
        }

        this.currentRotation = this.targetRotation;
        if(Math.abs(this.targetRotation + turn) <= MAX_TURN) {
            this.targetRotation += turn;
        }

        if(forward != 0 && turn == 0) {
            this.targetRotation = 0;
        }

        float deg = this.currentRotation + this.getYRot();
        float rad = deg * (float)Math.PI / 180;

        if(forward != 0 && deg != this.getYRot()) {
            this.setYRot(deg);
        }

        this.setDeltaMovement(this.getDeltaMovement().add(-Math.sin(rad) * forward, 0, Math.cos(rad) * forward));
    }



    @Override
    protected void defineSynchedData() {
        this.entityData.define(HEALTH, MAX_HEALTH);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        this.entityData.set(HEALTH, compoundTag.getFloat("Health"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putFloat("Health", this.entityData.get(HEALTH));
    }

    @Override
    public float getStepHeight() {
        return 1;
    }

    @Override
    public void tick() {

        super.tick();
        this.tickLerp();

        if(this.isControlledByLocalInstance()) {

            Vec3 velocity = this.getDeltaMovement();
            double dx = velocity.x * FRICTION;
            if(Math.abs(dx) < 0.001) dx = 0;

            double dz = velocity.z * FRICTION;
            if(Math.abs(dz) < 0.001) dz = 0;

            double dy = velocity.y + (this.onGround() ? 0 : -GRAVITY);

            this.setDeltaMovement(dx, dy, dz);

            if(this.getControllingPassenger() instanceof LocalPlayer player) {
                this.controlEntity(player.input);
            }

            this.move(MoverType.SELF, this.getDeltaMovement());

        }
        else {
            this.setDeltaMovement(Vec3.ZERO);
        }




    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }


}
