package com.tohu.tohumanagement.Events.Entity;

import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class PlaceEvent implements Listener {
    TohuManagement plugin;
    public PlaceEvent(TohuManagement plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }


}
