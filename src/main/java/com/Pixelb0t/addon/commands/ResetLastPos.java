package com.Pixelb0t.addon.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandSource;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;


public class ResetLastPos extends Command {
    public ResetLastPos() {
        super("Reset_Last_POS_To-Current-POS", "Resets the last position");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            double x = MinecraftClient.getInstance().player.getX();
            double y = MinecraftClient.getInstance().player.getY();
            double z = MinecraftClient.getInstance().player.getZ();
            MinecraftClient.getInstance().player.setPosition(x ,y+100 ,z);
            return SINGLE_SUCCESS;
        });
    }
}
