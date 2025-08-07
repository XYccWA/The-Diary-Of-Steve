package com.XYccWA.thediaryofsteve.Capability.FoodNutrition.Protein;

import net.minecraft.nbt.CompoundTag;

public class PlayerProtein {

    private int protein;

    public PlayerProtein() {
        this.protein = 100;
    }

    public void increace(int i){
        if((protein+i)<=100)
            protein += i;
        else
            protein = 100;
    }

    public void increace(){
        this.increace(1);
    }

    public void decreace(int d){
        if(protein < d)
            protein = 0;
        else
            protein -= d;
    }

    public void decreace(){
        this.decreace(1);
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = PlayerProtein.this.protein;
    }

    public void saveNBTData(CompoundTag compoundTag){
        compoundTag.putInt("protein", protein);
    }

    public void loadNBTData(CompoundTag compoundTag){
        protein = compoundTag.getInt("protein");
    }

}
