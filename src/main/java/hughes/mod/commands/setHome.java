package hughes.mod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import hughes.mod.Hughesmod;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;

public class setHome {
    public setHome(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("set").executes((command) -> {
            return setHomeCommand(command.getSource());
        })));
    }

    private int setHomeCommand(CommandSourceStack source) throws CommandSyntaxException{
        ServerPlayer player = source.getPlayer();
        Vec3 playerPos = player.position();
        String pos = "(" + playerPos.x + ", " + playerPos.y + ", " + playerPos.z + ")";

        player.getPersistentData().putIntArray(Hughesmod.MODID + "homepos", 
            new int[]{(int) playerPos.x, (int) playerPos.y, (int) playerPos.z}
        );

        source.sendSuccess(() -> Component.literal("set Home at " + pos), true);
        return 0;
    }

}
