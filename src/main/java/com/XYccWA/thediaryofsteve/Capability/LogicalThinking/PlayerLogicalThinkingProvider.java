package com.XYccWA.thediaryofsteve.Capability.LogicalThinking;


import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerLogicalThinkingProvider implements ICapabilityProvider, INBTSerializable {
    private PlayerLogicalThinking playerLogicalThinking;
    public static final Capability<PlayerLogicalThinking> PLAYER_LOGICAL_THINKING_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerLogicalThinking>() {});
    private final LazyOptional<PlayerLogicalThinking> lazyOptional = LazyOptional.of(() -> this.playerLogicalThinking);


    public PlayerLogicalThinkingProvider(){
        this.playerLogicalThinking = new PlayerLogicalThinking();
    }

    @Override
    public Tag serializeNBT() {
        var tag = new CompoundTag();
        playerLogicalThinking.saveNBTData(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        playerLogicalThinking.loadNBTData((CompoundTag) nbt);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if(cap == PLAYER_LOGICAL_THINKING_CAPABILITY){
            return lazyOptional.cast();
        }else{
            return lazyOptional.empty();
        }
    }
}
