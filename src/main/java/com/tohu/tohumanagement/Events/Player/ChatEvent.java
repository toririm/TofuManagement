package com.tohu.tohumanagement.Events.Player;

import com.tohu.tohumanagement.Services.ChatLogManagement;
import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
    TohuManagement plugin;
    public ChatEvent(TohuManagement plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage();
        ChatLogManagement.saveChatLog(player, message);
        if (message.contains("tofu")) {
            player.sendMessage(ChatColor.BOLD + "/" + ChatColor.RESET + "を付けるの忘れてるかも？？");
        }
    }
}
