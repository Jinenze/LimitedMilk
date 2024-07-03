package com.jez.milk.config;

import com.jez.milk.LimitedMilk;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = LimitedMilk.MOD_ID)
public class ModConfig implements ConfigData {
    public int milkTick = 24000;

    @Comment("only on server start")
    @ConfigEntry.Gui.Tooltip
    public boolean needJade = true;
}
