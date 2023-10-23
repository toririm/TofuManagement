package com.tohu.tohumanagement.Events.Block;

import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

public class ExplodeEvent implements Listener {
    TohuManagement plugin;
    World world;
    public ExplodeEvent(TohuManagement plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
        this.world = this.plugin.getServer().getWorld("lobby");
    }
    @EventHandler
    public void onBlockExplodeEvent(BlockExplodeEvent e) {
        e.setCancelled(true);
    }
}
