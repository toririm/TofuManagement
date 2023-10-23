package com.tohu.tohumanagement.Events.Block;

import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakEvent implements Listener {
    TohuManagement plugin;
    World world;
    public BreakEvent(TohuManagement plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
        this.world = this.plugin.getServer().getWorld("lobby");
    }
    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        if (world != this.world) return;
        e.setCancelled(true);
    }
}
