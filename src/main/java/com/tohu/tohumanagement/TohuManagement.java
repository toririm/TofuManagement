package com.tohu.tohumanagement;

import com.tohu.tohumanagement.Commands.Tofu;
import com.tohu.tohumanagement.Events.Block.BreakEvent;
import com.tohu.tohumanagement.Events.Block.ExplodeEvent;
import com.tohu.tohumanagement.Events.Block.PlaceEvent;
import com.tohu.tohumanagement.Events.Entity.DamageEvent;
import com.tohu.tohumanagement.Events.Player.*;
import com.tohu.tohumanagement.Services.Ranking;
import com.tohu.tohumanagement.Services.TextUtil;
import com.tohu.tohumanagement.Services.WorldManagement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class TohuManagement extends JavaPlugin {
    Map<String, Integer> ranking = new HashMap<String, Integer>(){
        {
            put("player1", 10);
            put("player2", 20);
            put("player3", 40);
        }
    };

    @Override
    public void onEnable() {
        // Plugin startup log
        getLogger().info("TohuManagement is enabled");
        World main = Bukkit.getWorld("world");
        //remove all text displays
        for (TextDisplay display: Objects.requireNonNull(main).getEntitiesByClass(TextDisplay.class)) {
            display.remove();
        }
        TextDisplay display = Objects.requireNonNull(main).spawn(Config.textDisplaySpawn, TextDisplay.class);

        display.setText(ChatColor.RED + "チャットの内容を確認してください！");
        display.setRotation(90, 0);
        display.setShadowed(true);
        display.setDisplayWidth(5);

        Objects.requireNonNull(getCommand("tofu")).setExecutor(new Tofu());
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
        new ChatEvent(this);
        new DamageEvent(this);
        for (World world: Bukkit.getServer().getWorlds()) {
            for (Player player: world.getPlayers()) {
                player.sendMessage("サーバを再起動しました");
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        for (World world: Bukkit.getServer().getWorlds()) {
            for (Player player: world.getPlayers()) {
                player.sendMessage("サーバを再起動します");
            }
        }

    }
}
