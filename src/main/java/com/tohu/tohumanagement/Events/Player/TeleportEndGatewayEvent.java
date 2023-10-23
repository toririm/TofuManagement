package com.tohu.tohumanagement.Events.Player;

import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportEndGatewayEvent implements Listener {
    TohuManagement plugin;

    public TeleportEndGatewayEvent(TohuManagement plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onTeleportEndGatewayEvent(PlayerTeleportEvent e) {
        if (e.getCause().equals(PlayerTeleportEvent.TeleportCause.END_GATEWAY) ||
                e.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL) ||
        e.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)) e.setCancelled(true);
    }
}
