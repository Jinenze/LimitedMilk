package com.jez.milk.dependencies.jade;

import com.jez.milk.LimitedMilk;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum MilkComponentProvider implements IServerDataProvider<EntityAccessor>, IEntityComponentProvider {
    INSTANCE;

    private static final String KEY = "last_milk";
    private static final Identifier ID = new Identifier(LimitedMilk.MOD_ID, KEY);

    @Override
    public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        if (entityAccessor.getServerData().contains(KEY)) {
            iTooltip.append(
                    Text.translatable(
                            "tooltip.limited_milk.last_milk",
                            entityAccessor.getServerData().getInt(KEY)
                    )
            );
        }
    }

    @Override
    public void appendServerData(NbtCompound nbtCompound, EntityAccessor entityAccessor) {
        LastMilkGetter entity = (LastMilkGetter) entityAccessor.getEntity();
        nbtCompound.putInt(KEY, entity.getLastMilk());
    }

    @Override
    public Identifier getUid() {
        return ID;
    }
}
