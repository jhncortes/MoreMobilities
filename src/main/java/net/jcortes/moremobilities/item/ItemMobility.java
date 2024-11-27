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
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ItemMobility extends Item {
    public ItemMobility(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        BlockHitResult blockhitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        BlockPos blockPos = blockhitresult.getBlockPos();

        if (level.getBlockState(blockPos).getBlock() instanceof LiquidBlock) {
            InteractionResultHolder.pass(itemStack);
        }
        else {
            if (!level.isClientSide) {
                EntityType<EntityBike> bikeEntity = EntityRegistry.BIKE.get();
                bikeEntity.spawn((ServerLevel) level, itemStack, player, blockPos.above(), MobSpawnType.SPAWN_EGG, false, false);
                itemStack.shrink(1);
                return InteractionResultHolder.success(itemStack);
            }

        }


        return InteractionResultHolder.pass(itemStack); // Return PASS with the original stack
    }
}
