package com.skyss0fly.WelcomeMessage;

package skyss0fly.welcomemessage;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;

public class Main extends PluginBase implements Listener {
    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String servername = this.getConfig().getString("ServerName");
        String prefix = this.getConfig().getString("Prefix");
        String message = this.getConfig().getString("Message");
        boolean broadcasttoserver = this.getConfig().getBoolean("BroadcastToServer");
        message = message.replace("{player}", player.getName());
        prefix = prefix.replace("&", "§");
        servername = servername.replace("&", "§");
        message = message.replace("&", "§");
        message = prefix + ": " + message + servername;

        if (broadcasttoserver) {
            this.getServer().broadcastMessage(message);
        } else {
            player.sendMessage(message);
        }
    }
}
