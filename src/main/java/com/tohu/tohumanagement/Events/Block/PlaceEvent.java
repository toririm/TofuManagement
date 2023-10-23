package com.tohu.tohumanagement.Events.Block;

import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener {
    TohuManagement plugin;
    World world;
    public PlaceEvent(TohuManagement plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
        this.world = this.plugin.getServer().getWorld("lobby");
    }
    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        switch (block.getType()) {
            case TNT:
                e.setCancelled(true);
        }

    }
}
