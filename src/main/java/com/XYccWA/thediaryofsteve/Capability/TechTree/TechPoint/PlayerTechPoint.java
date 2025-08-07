package com.XYccWA.thediaryofsteve.Capability.TechTree.TechPoint;

import net.minecraft.nbt.CompoundTag;

public class PlayerTechPoint {

    private int techPoint;

    public PlayerTechPoint() {
        this.techPoint = 0;
    }

    public void increace(int i){
        techPoint += i;
    }

    public void increace(){
        techPoint++;
    }

    public boolean decreace(int d){
        if(techPoint < d) {
            return false;
        }
        else {
            techPoint -= d;
            return true;
        }
    }

    public void decreace(){
        this.decreace(1);
    }

    public int getTechPoint() {
        return techPoint;
    }

    public void setTechPoint(int techPoint) {
        this.techPoint = techPoint;
    }

    public void saveNBTData(CompoundTag compoundTag){
        compoundTag.putInt("techpoint", techPoint);
    }

    public void loadNBTData(CompoundTag compoundTag){
        techPoint = compoundTag.getInt("techpoint");
    }

}
