package com.XYccWA.thediaryofsteve.Event;

import com.XYccWA.thediaryofsteve.Capability.TechTree.TechPoint.PlayerTechPointProvider;
import com.XYccWA.thediaryofsteve.Command.GetValue.GetFoodNutritionCommand;
import com.XYccWA.thediaryofsteve.Command.GetValue.GetLogicalThinkingCommand;
import com.XYccWA.thediaryofsteve.Command.GetValue.GetTechPointCommand;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.XYccWA.thediaryofsteve.TheDiaryOfSteve.MODID;


@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventListener {

    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event){
        GetTechPointCommand.register(event.getDispatcher());
        GetLogicalThinkingCommand.register(event.getDispatcher());
        GetFoodNutritionCommand.register(event.getDispatcher());
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
