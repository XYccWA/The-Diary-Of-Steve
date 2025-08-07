package com.XYccWA.thediaryofsteve.Capability.FoodNutrition.SugarContent;

import net.minecraft.nbt.CompoundTag;

public class PlayerSugarContent {

    private int sugarContent;

    public PlayerSugarContent() {
        this.sugarContent = 100;
    }

    public void increace(int i){
        if((sugarContent+i)<=100)
            sugarContent += i;
        else
            sugarContent = 100;
    }

    public void increace(){
        this.increace(1);
    }

    public void decreace(int d){
        if(sugarContent < d)
            sugarContent = 0;
        else
            sugarContent -= d;
    }

    public void decreace(){
        this.decreace(1);
    }

    public int getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(int sugarContent) {
        this.sugarContent = PlayerSugarContent.this.sugarContent;
    }

    public void saveNBTData(CompoundTag compoundTag){
        compoundTag.putInt("sugarContent", sugarContent);
    }

    public void loadNBTData(CompoundTag compoundTag){
        sugarContent = compoundTag.getInt("sugarContent");
    }

}
