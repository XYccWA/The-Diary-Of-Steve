package com.XYccWA.thediaryofsteve.Event;

import com.XYccWA.thediaryofsteve.Capability.Technology.PlayerTechPointProvider;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.XYccWA.thediaryofsteve.TheDiaryOfSteve.MODID;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MODID)
public class ModEventListener {

    @SubscribeEvent
    public static void registerCapability(RegisterCapabilitiesEvent event){
        event.register(PlayerTechPointProvider.class);
    }


}
