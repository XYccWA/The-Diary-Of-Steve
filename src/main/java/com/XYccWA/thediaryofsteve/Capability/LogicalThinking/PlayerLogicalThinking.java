package com.XYccWA.thediaryofsteve.Capability.LogicalThinking;

import net.minecraft.nbt.CompoundTag;

public class PlayerLogicalThinking {
    private double logicalThinking;

    public PlayerLogicalThinking() { this.logicalThinking = 0.8; }

    public void increace(){
        logicalThinking++;
    }

    public void increace(double i){
        logicalThinking += i;
    }

    public void decreace(double i){
        if (logicalThinking >= i)
            logicalThinking -= i;
        else
            logicalThinking = 0;
    }

    public void decreace(){
        this.decreace(0.01);
    }

    public double getLogicalThinking() {
        return logicalThinking;
    }

    public void setLogicalThinking(double logicalThinking) {
        this.logicalThinking = logicalThinking;
    }

    public void saveNBTData(CompoundTag compoundTag){
        compoundTag.putDouble("logicalthinking", logicalThinking);
    }

    public void loadNBTData(CompoundTag compoundTag){
        logicalThinking = compoundTag.getDouble("logicalthinking");
    }
}
