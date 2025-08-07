package com.XYccWA.thediaryofsteve.Command.GetValue;

import com.XYccWA.thediaryofsteve.Capability.TechTree.LogicalThinking.PlayerLogicalThinkingProvider;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class GetLogicalThinkingCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("logicalthinking").executes((context) -> {
            context.getSource().getPlayer().getCapability(PlayerLogicalThinkingProvider.PLAYER_LOGICAL_THINKING_CAPABILITY).ifPresent((logicalthinking) -> {
                context.getSource().sendSuccess(() -> Component.literal("logicalthinking = "+logicalthinking.getLogicalThinking()), false);
            });
            return 0;
        }));
    }
}
