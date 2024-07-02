package com.jez.milk.dependencies.jade;

import net.minecraft.entity.passive.CowEntity;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;

public class MilkPlugin implements IWailaPlugin {

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerEntityComponent(MilkComponentProvider.INSTANCE, CowEntity.class);
    }

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerEntityDataProvider(MilkComponentProvider.INSTANCE, CowEntity.class);
    }
}
