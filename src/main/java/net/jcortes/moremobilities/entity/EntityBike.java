package net.jcortes.moremobilities.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeBoat;

public class EntityBike extends Entity {

//    private static final EntityDataAccessor<Integer> DATA_ID_HURT;
//    private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR;
//    private static final EntityDataAccessor<Float> DATA_ID_DAMAGE;
//    private static final EntityDataAccessor<Integer> DATA_ID_TYPE;
//    private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_LEFT;
//    private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_RIGHT;
//    private static final EntityDataAccessor<Integer> DATA_ID_BUBBLE_TIME;

    public static final int PADDLE_LEFT = 0;
    public static final int PADDLE_RIGHT = 1;
    private static final int TIME_TO_EJECT = 60;
    private static final float PADDLE_SPEED = ((float)Math.PI / 8F);
    public static final double PADDLE_SOUND_TIME = (double)((float)Math.PI / 4F);
    public static final int BUBBLE_TIME = 60;
    //private final float[] paddlePositions;
    private float invFriction;
    private float outOfControlTicks;
    private float deltaRotation;
    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYRot;
    private double lerpXRot;
    private boolean inputLeft;
    private boolean inputRight;
    private boolean inputUp;
    private boolean inputDown;
    private double waterLevel;
    private float landFriction;
    //private Boat.Status status;
    //private Boat.Status oldStatus;
    private double lastYd;
    private boolean isAboveBubbleColumn;
    private boolean bubbleColumnDirectionIsDown;
    private float bubbleMultiplier;
    private float bubbleAngle;
    private float bubbleAngleO;

    public EntityBike(EntityType<? extends EntityBike> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.blocksBuilding = true;
    }


    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }
}
