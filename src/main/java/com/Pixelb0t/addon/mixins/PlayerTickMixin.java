package com.Pixelb0t.addon.mixins;

import com.Pixelb0t.addon.modules.*;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static java.lang.Math.round;

@Mixin(PlayerEntity.class)
public class PlayerTickMixin {
    @Shadow
    @Final
    private static Logger LOGGER;

    @Inject(at = @At("TAIL"), method = "tick")
    private void Tick(CallbackInfo info) throws InterruptedException {

        Entity player = MeteorClient.mc.player;
        if(MeteorClient.mc.player != null && MinecraftClient.getInstance().player.hasVehicle()){
            player = MeteorClient.mc.player.getVehicle();
        }



        //the normal coordonates of the player
        double rawx = player.getX();
        double rawy = player.getY();
        double rawz = player.getZ();

        //we round the coordonates in the math below
        double xR = round(rawx*100);
        //double yR = round(rawy*100);
        double zR = round(rawz*100);
        double x = xR/100;
        //double y = yR/100;
        double z = zR/100;
        if (Modules.get().isActive(Bot_Mode_Module.class)){


            //now we set the player coordonates to the rounded x, y, z
            if(Modules.get().isActive(FloatingPointErrorFixer.class)){
                player.setPosition(x+0.01,rawy,z+0.01);
            }else{
                player.setPosition(x,rawy,z);
            }




            //this should bypass th only bot plugin made by liveoverflow

        }
        if (Modules.get().isActive(Novelocity.class)){



            player.setVelocity( 0 , 0 ,0);



        }





    }

    private int jumptime = 0;
    @Inject(method = "jump", at = @At("HEAD"))
    private void onJump(CallbackInfo info) {

        jumptime++;
        System.out.println(jumptime);
        Entity player = MeteorClient.mc.player;
        if(Modules.get().isActive(JumpBoost.class) && jumptime == 2){
            player.setVelocity(player.getVelocity().x,player.getVelocity().y + 1 , player.getVelocity().z);
            jumptime = 0;
        }
    }





}
