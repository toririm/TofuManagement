package com.tohu.tohumanagement;

import com.tohu.tohumanagement.Commands.Tofu;
import com.tohu.tohumanagement.Events.Block.BreakEvent;
import com.tohu.tohumanagement.Events.Block.ExplodeEvent;
import com.tohu.tohumanagement.Events.Block.PlaceEvent;
import com.tohu.tohumanagement.Events.Player.ChangeWorld;
import com.tohu.tohumanagement.Events.Player.InteractEvent;
import com.tohu.tohumanagement.Events.Player.JoinServer;
import com.tohu.tohumanagement.Events.Player.TeleportEndGatewayEvent;
import com.tohu.tohumanagement.Services.WorldManagement;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class TohuManagement extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup log
        getLogger().info("TohuManagement is enabled");
        getCommand("tofu").setExecutor(new Tofu());
        List<World> worlds = Bukkit.getServer().getWorlds();
        for (World world : worlds) {
            WorldManagement.saveWorld(world);
        }
        getLogger().info("Worlds are saved");
        getLogger().info(Bukkit.getServer().getMotd());
        new ChangeWorld(this);
        new JoinServer(this);
        new BreakEvent(this);
        new PlaceEvent(this);
        new ExplodeEvent(this);
        new InteractEvent(this);
        new TeleportEndGatewayEvent(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
