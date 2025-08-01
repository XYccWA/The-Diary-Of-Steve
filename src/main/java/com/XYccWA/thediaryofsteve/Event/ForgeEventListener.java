package com.XYccWA.thediaryofsteve.Event;

import com.XYccWA.thediaryofsteve.Capability.Technology.PlayerTechPointProvider;
import com.XYccWA.thediaryofsteve.Command.GetTechPointCommand;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeEventListener {

    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event){
        GetTechPointCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void breakCrop(BlockEvent.BreakEvent event){
        if(event.getState().getBlock() instanceof CropBlock){
            event.getPlayer().getCapability(PlayerTechPointProvider.PLAYER_TECH_POINT_CAPABILITY).ifPresent((techPoint) -> {
                techPoint.increace();
            });
        }
    }
}
