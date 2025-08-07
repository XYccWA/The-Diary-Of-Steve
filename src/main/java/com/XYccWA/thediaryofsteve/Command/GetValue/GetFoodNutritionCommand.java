package com.XYccWA.thediaryofsteve.Command.GetValue;


import com.XYccWA.thediaryofsteve.Capability.FoodNutrition.Protein.PlayerProteinProvider;
import com.XYccWA.thediaryofsteve.Capability.FoodNutrition.SugarContent.PlayerSugarContentProvider;
import com.XYccWA.thediaryofsteve.Capability.FoodNutrition.fat.PlayerFatProvider;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class GetFoodNutritionCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("foodnutrition").executes((context) -> {
            context.getSource().getPlayer().getCapability(PlayerFatProvider.PLAYER_FAT_CAPABILITY).ifPresent((fat) -> {
                context.getSource().sendSuccess(() -> Component.literal("fat = "+fat.getFat()), false);
            });
            context.getSource().getPlayer().getCapability(PlayerProteinProvider.PLAYER_PROTEIN_CAPABILITY).ifPresent((protein) -> {
                context.getSource().sendSuccess(() -> Component.literal("protein = "+protein.getProtein()+"/n"),false);
            });
            context.getSource().getPlayer().getCapability(PlayerSugarContentProvider.PLAYER_SUGAR_CONTENT_CAPABILITY).ifPresent((sugarcontent) -> {
                context.getSource().sendSuccess(() -> Component.literal("sugarcontent = "+sugarcontent.getSugarContent()),false);
            });
            return 0;
        }));
    }
}
