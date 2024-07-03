package com.jez.milk;

import com.jez.milk.config.ModConfig;
import com.jez.milk.config.ModConfigWrapper;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class LimitedMilk implements ModInitializer {
    public static final String MOD_ID = "limited-milk";
    public static ModConfig config;

    @Override
    public void onInitialize() {
        if (FabricLoader.getInstance().isModLoaded("cloth-config")) {
            AutoConfig.register(ModConfigWrapper.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
            config = AutoConfig.getConfigHolder(ModConfigWrapper.class).getConfig().config;
        } else {
            config = new ModConfig();
        }
    }
}
