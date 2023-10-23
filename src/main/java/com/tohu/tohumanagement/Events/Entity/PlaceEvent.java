package com.tohu.tohumanagement.Events.Entity;

import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPlaceEvent;


public class PlaceEvent implements Listener {
    TohuManagement plugin;
    public PlaceEvent(TohuManagement plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onEntityPlaceEvent(EntityPlaceEvent e) {
        e.setCancelled(true);
    }


}
