package com.github.koxsosen.essxdiscordwhitelist;

import com.github.koxsosen.essxdiscordwhitelist.slashcommand.UnWhitelistSlashCommand;
import com.github.koxsosen.essxdiscordwhitelist.slashcommand.WhitelistSlashCommand;
import net.essentialsx.api.v2.services.discord.DiscordService;
import net.essentialsx.api.v2.services.discord.InteractionException;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Essxdiscordwhitelist extends JavaPlugin {

    @Override
    public void onEnable() {
        final DiscordService api = Bukkit.getServicesManager().load(DiscordService.class);
        try {
            api.getInteractionController().registerCommand(new WhitelistSlashCommand());
            api.getInteractionController().registerCommand(new UnWhitelistSlashCommand());
        } catch (InteractionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
