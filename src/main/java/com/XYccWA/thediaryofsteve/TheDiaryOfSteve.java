package com.XYccWA.thediaryofsteve;

import com.XYccWA.thediaryofsteve.Capability.Technology.PlayerTechPointProvider;
import com.XYccWA.thediaryofsteve.Command.GetTechPointCommand;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.logging.LogUtils;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;



@Mod(TheDiaryOfSteve.MODID)
public class TheDiaryOfSteve
{
    public static final String MODID = "thediaryofsteve";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TheDiaryOfSteve(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, this::attachCapability);
    }


    public void attachCapability(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof Player player){
            if(!player.getCapability(PlayerTechPointProvider.PLAYER_TECH_POINT_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(MODID, "techpoint"), new PlayerTechPointProvider());
            }
        }
    }

}

