package com.Pixelb0t.addon.mixins;
import meteordevelopment.meteorclient.events.world.ServerConnectBeginEvent;
import net.minecraft.client.network.ServerAddress;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ServerConnectBeginEvent.class)
public class ServerConectionBeginEventMixin {
    @Shadow
    public ServerAddress address;



}

