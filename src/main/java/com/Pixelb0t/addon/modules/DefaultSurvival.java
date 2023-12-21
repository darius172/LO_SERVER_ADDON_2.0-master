package com.Pixelb0t.addon.modules;

import com.Pixelb0t.addon.Addon;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.settings.StringListSetting;
import meteordevelopment.meteorclient.systems.modules.Module;

import java.util.List;

public class DefaultSurvival extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    public DefaultSurvival() {
        super(Addon.Pixel_utility_Category, "Default Gamemode Survival", "When joining a server sets the gamemode to survival clientside");
    }
    public final Setting<List<String>> ServerIP = sgGeneral.add(new StringListSetting.Builder()
        .name("ServerIP")
        .description("ServerIP for Default gamemode survival")
        .defaultValue(List.of("Example.com"))
        .build()
    );



}
