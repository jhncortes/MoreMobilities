package net.jcortes.moremobilities.item;

import net.jcortes.moremobilities.entity.EntityBike;
import net.jcortes.moremobilities.entity.EntityRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Objects;

public class ItemMobility extends Item {
    public ItemMobility(Properties properties) {
        super(properties);
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            // Reduce item count by 1
            itemStack.shrink(1);

            // Get the player's position and spawn the entity near them
            BlockHitResult blockhitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
            BlockPos blockPos = blockhitresult.getBlockPos();
            ServerLevel serverLevel = (ServerLevel) level; // Cast level to ServerLevel for spawning

            EntityBike bikeEntity = EntityRegistry.BIKE.get().spawn((ServerLevel) level, itemStack, player, blockPos, MobSpawnType.SPAWN_EGG, false, false);


            return InteractionResultHolder.success(itemStack); // Return SUCCESS with the modified stack
        }

        return InteractionResultHolder.pass(itemStack); // Return PASS with the original stack
    }
}
