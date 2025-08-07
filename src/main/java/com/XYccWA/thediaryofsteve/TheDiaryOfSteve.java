package com.XYccWA.thediaryofsteve;

import com.XYccWA.thediaryofsteve.Capability.TechTree.LogicalThinking.PlayerLogicalThinkingProvider;
import com.XYccWA.thediaryofsteve.Capability.TechTree.TechPoint.PlayerTechPointProvider;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;



@Mod(TheDiaryOfSteve.MODID)
public class TheDiaryOfSteve
{
    public static final String MODID = "thediaryofsteve";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);


    public static final RegistryObject<Block> researchTable = BLOCKS.register("research_table", () -> new Block(BlockBehaviour.Properties.of().strength(3.0F)));


    public static final RegistryObject<Item> researchTableItem = ITEMS.register("research_table", () -> new BlockItem(researchTable.get(), new Item.Properties()));

    public TheDiaryOfSteve(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, this::attachCapability);
    }


    public void attachCapability(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof Player player){
            if(!player.getCapability(PlayerTechPointProvider.PLAYER_TECH_POINT_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(MODID, "techpoint"), new PlayerTechPointProvider());
            }
        }
        if(event.getObject() instanceof Player player){
            if(!player.getCapability(PlayerLogicalThinkingProvider.PLAYER_LOGICAL_THINKING_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(MODID, "logicalthinking"), new PlayerLogicalThinkingProvider());
            }
        }
    }

}

