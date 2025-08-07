package com.XYccWA.thediaryofsteve.Capability.TechTree.TechPoint;

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

public class PlayerTechPointProvider implements ICapabilityProvider, INBTSerializable {

    private PlayerTechPoint playerTechPoint;
    public static final Capability<PlayerTechPoint> PLAYER_TECH_POINT_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerTechPoint>() {});
    private final LazyOptional<PlayerTechPoint> lazyOptional = LazyOptional.of(() -> this.playerTechPoint);

    public PlayerTechPointProvider() {
        this.playerTechPoint = new PlayerTechPoint();
    }

    @Override
    public Tag serializeNBT() {
        var tag = new CompoundTag();
        playerTechPoint.saveNBTData(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        playerTechPoint.loadNBTData((CompoundTag) nbt);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if(cap == PLAYER_TECH_POINT_CAPABILITY){
            return lazyOptional.cast();
        }else{
            return lazyOptional.empty();
        }
    }
}
