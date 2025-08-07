package com.XYccWA.thediaryofsteve.Capability.FoodNutrition.Protein;


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

public class PlayerProteinProvider implements ICapabilityProvider, INBTSerializable {

    private PlayerProtein playerProtein;
    public static final Capability<PlayerProtein> PLAYER_PROTEIN_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerProtein>() {});
    private final LazyOptional<PlayerProtein> lazyOptional = LazyOptional.of(() -> this.playerProtein);

    public PlayerProteinProvider() {
        this.playerProtein = new PlayerProtein();
    }

    @Override
    public Tag serializeNBT() {
        var tag = new CompoundTag();
        playerProtein.saveNBTData(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        playerProtein.loadNBTData((CompoundTag) nbt);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if(cap == PLAYER_PROTEIN_CAPABILITY){
            return lazyOptional.cast();
        }else{
            return lazyOptional.empty();
        }
    }
}
