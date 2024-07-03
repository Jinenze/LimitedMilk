package com.jez.milk.config;

import com.jez.milk.LimitedMilk;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;

@Config(name = LimitedMilk.MOD_ID)
public class ModConfigWrapper extends PartitioningSerializer.GlobalData {
    @ConfigEntry.Gui.TransitiveObject
    public ModConfig config = new ModConfig();
}
