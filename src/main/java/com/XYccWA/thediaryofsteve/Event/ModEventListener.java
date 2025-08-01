package com.XYccWA.thediaryofsteve.Event;

import com.XYccWA.thediaryofsteve.Capability.Technology.PlayerTechPointProvider;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEventListener {

    @SubscribeEvent
    public static void registerCapability(RegisterCapabilitiesEvent event){
        event.register(PlayerTechPointProvider.class);
    }


}
