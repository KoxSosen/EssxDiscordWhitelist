package com.github.koxsosen.essxdiscordwhitelist.slashcommand;

import net.essentialsx.api.v2.services.discord.InteractionCommand;
import net.essentialsx.api.v2.services.discord.InteractionCommandArgument;
import net.essentialsx.api.v2.services.discord.InteractionCommandArgumentType;
import net.essentialsx.api.v2.services.discord.InteractionEvent;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.List;

public class WhitelistSlashCommand implements InteractionCommand {

    @Override
    public void onCommand(InteractionEvent event) {
        // The name of the argument here has to be the same you used in getArguments()
        final String playername = event.getStringArgument("player");
        final OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playername);

        // If the player haven't joined before.
        if (offlinePlayer == null) {
            event.reply("Error occurred while whitelisting " + playername);
            return;
        }

        offlinePlayer.setWhitelisted(true);

        if (offlinePlayer.isWhitelisted()) {
            event.reply("Whitelisted " + playername + ".");
        } else {
            event.reply("Encountered an error while whitelisting " + playername + ".");
        }
    }

    @Override
    public String getName() {
        // Command name
        return "whitelist";
    }

    @Override
    public String getDescription() {
        // Command description
        return "Whitelist a player on the server.";
    }

    @Override
    public List <InteractionCommandArgument> getArguments() {
        // Should return a list of arguments that will be used in your command.
        return List.of(
                new InteractionCommandArgument(
                        "player",
                        "The name of the player to whitelist.",
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
