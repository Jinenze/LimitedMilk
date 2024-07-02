package com.jez.milk.mixin;

import com.jez.milk.dependencies.jade.LastMilkGetter;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CowEntity.class)
public abstract class CowEntityMixin extends AnimalEntity implements LastMilkGetter {
    @Unique
    private int lastMilk;

    protected CowEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    private void interactMobInject(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (lastMilk > 0) {
            cir.setReturnValue(super.interactMob(player, hand));
        }
    }

    @Inject(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;setStackInHand(Lnet/minecraft/util/Hand;Lnet/minecraft/item/ItemStack;)V"))
    private void interactMobInjectTail(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        lastMilk = 24000;
    }

    @Unique
    @Override
    public void tickMovement() {
        super.tickMovement();
        if (lastMilk > 0) {
            --lastMilk;
        }
    }

    @Unique
    @Override
    public int getLastMilk() {
        return lastMilk;
    }
}
