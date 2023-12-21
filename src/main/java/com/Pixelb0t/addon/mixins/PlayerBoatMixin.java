package com.Pixelb0t.addon.mixins;

import com.Pixelb0t.addon.modules.StopRiding;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerBoatMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    private void onPlayerTick(CallbackInfo info) {
        Entity player = MeteorClient.mc.player;
        if (player.hasVehicle()){
            Entity vehicle = player.getVehicle();
        }



        if (Modules.get().isActive(StopRiding.class) && MeteorClient.mc.player.isRiding() == true) {
            MeteorClient.mc.player.dismountVehicle();


        }
    }


}

