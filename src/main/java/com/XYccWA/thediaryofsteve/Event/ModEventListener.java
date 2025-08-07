package com.XYccWA.thediaryofsteve.Event;

import com.XYccWA.thediaryofsteve.Capability.FoodNutrition.Protein.PlayerProteinProvider;
import com.XYccWA.thediaryofsteve.Capability.FoodNutrition.SugarContent.PlayerSugarContentProvider;
import com.XYccWA.thediaryofsteve.Capability.FoodNutrition.fat.PlayerFatProvider;
import com.XYccWA.thediaryofsteve.Capability.TechTree.LogicalThinking.PlayerLogicalThinkingProvider;
import com.XYccWA.thediaryofsteve.Capability.TechTree.TechPoint.PlayerTechPointProvider;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.XYccWA.thediaryofsteve.TheDiaryOfSteve.MODID;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MODID)
public class ModEventListener {



    @SubscribeEvent
    public static void registerCapability(RegisterCapabilitiesEvent event){
        //techtree
        event.register(PlayerTechPointProvider.class);
        event.register(PlayerLogicalThinkingProvider.class);


        //FoodNutrition
        event.register(PlayerSugarContentProvider.class);
        event.register(PlayerProteinProvider.class);
        event.register(PlayerFatProvider.class);
    }




}
