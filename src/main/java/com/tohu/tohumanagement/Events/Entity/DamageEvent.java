package com.tohu.tohumanagement.Events.Entity;

import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class DamageEvent implements Listener {
    TohuManagement plugin;
    public DamageEvent(TohuManagement plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent e) {
        Entity entity = e.getEntity();
        if (entity.getType() == EntityType.PLAYER) {
            e.setCancelled(true);
        }
    }

}
