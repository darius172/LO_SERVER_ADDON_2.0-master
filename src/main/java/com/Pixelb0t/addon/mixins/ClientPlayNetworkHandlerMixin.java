package com.Pixelb0t.addon.mixins;

import com.Pixelb0t.addon.modules.DefaultSurvival;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static meteordevelopment.meteorclient.MeteorClient.mc;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin{





    public ServerAddress address;
    @Inject(method = "onGameJoin", at = @At("TAIL"))
    private void onGameJoinTail(GameJoinS2CPacket packet, CallbackInfo info) {


        if(Modules.get().isActive(DefaultSurvival.class) ){
            mc.interactionManager.setGameMode(GameMode.SURVIVAL);
            System.out.println("Player Gamemode set to survival");
        }

    }

}
