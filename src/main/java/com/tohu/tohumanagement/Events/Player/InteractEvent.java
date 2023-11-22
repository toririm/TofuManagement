package com.tohu.tohumanagement.Events.Player;

import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class InteractEvent implements Listener {
    TohuManagement plugin;

    public InteractEvent(TohuManagement plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action action = e.getAction();
        ItemStack item = e.getItem();
        if (item != null) {
            Material material = item.getType();
            if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
                switch (material) {
                    case LAVA_BUCKET:
                    case FLINT_AND_STEEL:
                    case FIRE_CHARGE:
                        player.sendMessage("このアイテムは使用できません");
                        e.setUseItemInHand(Event.Result.DENY);
                }
            }
        }
    }


}
