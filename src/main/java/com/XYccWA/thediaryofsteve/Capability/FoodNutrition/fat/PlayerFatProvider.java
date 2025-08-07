package com.XYccWA.thediaryofsteve.Capability.FoodNutrition.fat;


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

public class PlayerFatProvider implements ICapabilityProvider, INBTSerializable {

    private PlayerFat playerFat;
    public static final Capability<PlayerFat> PLAYER_FAT_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerFat>() {});
    private final LazyOptional<PlayerFat> lazyOptional = LazyOptional.of(() -> this.playerFat);

    public PlayerFatProvider() {
        this.playerFat = new PlayerFat();
    }

    @Override
    public Tag serializeNBT() {
        var tag = new CompoundTag();
        playerFat.saveNBTData(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        playerFat.loadNBTData((CompoundTag) nbt);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if(cap == PLAYER_FAT_CAPABILITY){
            return lazyOptional.cast();
        }else{
            return lazyOptional.empty();
        }
    }
}
