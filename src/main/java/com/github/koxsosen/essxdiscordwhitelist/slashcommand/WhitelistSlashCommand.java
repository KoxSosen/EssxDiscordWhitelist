package com.github.koxsosen.essxdiscordwhitelist.slashcommand;

import net.essentialsx.api.v2.services.discord.InteractionCommand;
import net.essentialsx.api.v2.services.discord.InteractionCommandArgument;
import net.essentialsx.api.v2.services.discord.InteractionCommandArgumentType;
import net.essentialsx.api.v2.services.discord.InteractionEvent;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.List;

public class WhitelistSlashCommand implements InteractionCommand {

    @Override
    public void onCommand(InteractionEvent event) {
        // The name of the argument here has to be the same you used in getArguments()
        final String playerUuid = event.getStringArgument("player-uuid");
        final Player player = Bukkit.getPlayer(playerUuid); // Must use uuid
        final OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playerUuid);
        

        // If the player haven't joined before.
        if (player == null) {

            offlinePlayer.setWhitelisted(true);
            event.reply("Whitelisted a player named " +  offlinePlayer.getName()  +  " who haven't joined before.");
            return;

        }

        // Whitelist player.
        player.setWhitelisted(true);

        if (player.isWhitelisted()) {
            event.reply("Whitelisted " + player.getName() + " who have joined before.");
        } else {
            event.reply("Encountered an error while whitelisting the player.");
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
                        "player-uuid",
                        "The uuid of the player to whitelist.",
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
