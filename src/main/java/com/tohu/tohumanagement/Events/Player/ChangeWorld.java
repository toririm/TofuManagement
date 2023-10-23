package com.tohu.tohumanagement.Events.Player;

import com.tohu.tohumanagement.Services.PlayerManagement;
import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import java.util.ArrayList;

public class ChangeWorld implements Listener {
    TohuManagement plugin;
    ArrayList<Player> players;

    String test;


    public ChangeWorld(TohuManagement plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
        this.players = new ArrayList<>();
        this.test = "test";
    }

    @EventHandler
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        PlayerManagement.saveWorldAccessLog(player);
    }
}
