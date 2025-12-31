package hughes.mod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import hughes.mod.Hughesmod;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class returnHome {
    public returnHome(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("home").executes((command) -> {
            return returnHomeCommand(command.getSource());
        }));
    }
    private int returnHomeCommand(CommandSourceStack source) throws CommandSyntaxException{
        ServerPlayer player = source.getPlayer();
        boolean hasHomepos = player.getPersistentData().getIntArray(Hughesmod.MODID + "homepos").length != 0;
        if (hasHomepos){
            int[] playerPos = player.getPersistentData().getIntArray(Hughesmod.MODID + "homepos");
            player.setPos((double) playerPos[0], (double) playerPos[1], (double) playerPos[2]);
            source.sendSuccess(()-> Component.literal(player.getName().getString() + " has returned home"), true);
        } else {
            source.sendFailure(Component.literal("No Home Position Set"));
        }
        return 0;
    }
}
