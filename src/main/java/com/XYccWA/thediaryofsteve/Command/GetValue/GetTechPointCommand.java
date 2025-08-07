package com.XYccWA.thediaryofsteve.Command.GetValue;

import com.XYccWA.thediaryofsteve.Capability.TechTree.TechPoint.PlayerTechPointProvider;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class GetTechPointCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("techpoint").executes((context) -> {
            context.getSource().getPlayer().getCapability(PlayerTechPointProvider.PLAYER_TECH_POINT_CAPABILITY).ifPresent((techpoint) -> {
                context.getSource().sendSuccess(() -> Component.literal("techpoint = "+techpoint.getTechPoint()), false);
            });
            return 0;
        }));
    }
}
