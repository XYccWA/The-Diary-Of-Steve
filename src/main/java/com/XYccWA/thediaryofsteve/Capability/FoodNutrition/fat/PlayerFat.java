package com.XYccWA.thediaryofsteve.Capability.FoodNutrition.fat;

import net.minecraft.nbt.CompoundTag;

public class PlayerFat {

    private int fat;

    public PlayerFat() {
        this.fat = 100;
    }

    public void increace(int i){
        if((fat+i)<=100)
            fat += i;
        else
            fat = 100;
    }

    public void increace(){
        this.increace(1);
    }

    public void decreace(int d){
        if(fat < d)
            fat = 0;
        else
            fat -= d;
    }

    public void decreace(){
        this.decreace(1);
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = PlayerFat.this.fat;
    }

    public void saveNBTData(CompoundTag compoundTag){
        compoundTag.putInt("fat", fat);
    }

    public void loadNBTData(CompoundTag compoundTag){
        fat = compoundTag.getInt("fat");
    }

}
