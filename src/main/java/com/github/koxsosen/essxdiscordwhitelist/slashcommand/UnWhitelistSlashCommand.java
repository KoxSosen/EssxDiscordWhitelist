package com.github.koxsosen.essxdiscordwhitelist.slashcommand;

import net.essentialsx.api.v2.services.discord.InteractionCommand;
import net.essentialsx.api.v2.services.discord.InteractionCommandArgument;
import net.essentialsx.api.v2.services.discord.InteractionCommandArgumentType;
import net.essentialsx.api.v2.services.discord.InteractionEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class UnWhitelistSlashCommand implements InteractionCommand {

    @Override
    public void onCommand(InteractionEvent event) {
        // The name of the argument here has to be the same you used in getArguments()
        final String playerName = event.getStringArgument("player");
        final Player player = Bukkit.getPlayerExact(playerName);




        // No offline mode check. You can't unwhitelist someone who haven't joined before, can you?
        if (player == null) {
            event.reply("A player by that name could not be found!");
            return;
        }

        // Un-whitelist player
        player.setWhitelisted(false);

        if (!player.isWhitelisted()) {
            event.reply("Un-whitelisted " + player.getName() + ".");
        } else {
            event.reply("Encountered an error while un-whitelisting the player.");
        }

    }

    @Override
    public String getName() {
        // Command name
        return "un-whitelist";
    }

    @Override
    public String getDescription() {
        // Command description
        return "Un-whitelist a player on the server.";
    }

    @Override
    public List <InteractionCommandArgument> getArguments() {
        // Should return a list of arguments that will be used in your command.
        return List.of(
                new InteractionCommandArgument(
                        "player",
                        "The name of the player to un-whitelist.",
                        InteractionCommandArgumentType.STRING,
                        true));
    }

    @Override
    public boolean isEphemeral() {
        // The command execution isn't hidden from others...Maybe will make a config for this or something.
        return false;
    }

    @Override
    public boolean isDisabled() {
        // Enabled.
        return false;
    }
}
