package com.tohu.tohumanagement.Services;

import com.tohu.tohumanagement.Config;
import com.tohu.tohumanagement.Services.HttpReq;
import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PlayerManagement {

    //プレイヤーのログインログを保存する
    public static void savePlayerLog(Player player) {
        String url = Config.baseURL + "/mc/players";
        Map<String, Object> json = new HashMap<>();
        String uuid = player.getUniqueId().toString();
        String playerName = player.getName();
        json.put("uuid", uuid);
        json.put("name", playerName);
        HttpReq.Post(url, json);

    }

    //プレイヤーのワールドアクセスログを保存する
    public static void saveWorldAccessLog(Player player) {
        String uuid = player.getUniqueId().toString();
        String name = player.getWorld().getName();
        String ip = player.getAddress().getAddress().getHostAddress();
        String worldName = player.getWorld().getName();
        player.sendMessage(worldName);
        String url = Config.baseURL + "/mc/worlds/" + worldName;
        player.sendMessage(url);
        Map<String, Object> json = new HashMap<>();
        json.put("uuid", uuid);
        json.put("name", name);
        json.put("ip_address", ip);
        HttpReq.Post(url, json);

    }

    //プレイヤーを各サーバのロビーに戻す
    public static void moveWorld(Player player) {
        World world  = Bukkit.getWorld("lobby");
        String serverName = Bukkit.getServer().getName();
        switch (serverName) {
            case "S001":
                if (world != null) {
                        player.teleport(Config.s001Spawn);
                    } else {
                        player.sendMessage("ワールドが存在しません");
                    }
                    break;
            case "P001":
                if (world != null) {
                        player.teleport(Config.p001Spawn);
                    } else {
                        player.sendMessage("ワールドが存在しません");
                    }
                    break;
            case "Unknown Server":
                if (world != null) {
                        player.teleport(Config.lobbySpawn);
                    } else {
                        player.sendMessage("ワールドが存在しません");
                    }
                    break;
        }
    }

    //ログアウト時間の差分からロビーに戻すかどうかを判断する
    public static void logoutPlayer(Player player, TohuManagement plugin) throws ParseException, IOException {
        int hour = 4;
        String url = Config.baseURL + "/mc/access_logs/" + player.getUniqueId().toString();
        String createdTime = McAccessLogUtil.getCreatedAt(url);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date();
        Date createdDate = sdf.parse(createdTime);
        long diff = nowDate.getTime() - createdDate.getTime();
        if (diff > hour * 60 * 60 * 1000) {
            player.sendMessage("Lobbyサーバに戻します。");
            ServerManagement.moveServer(player, plugin, "lobby");
        } else {
            player.sendMessage("現在のサーバのロビーに戻ります");
            moveWorld(player);
        }

    }

    //プレイヤーのインベントリにアイテムを追加する
//    public static void setItem(Player player, String itemDisplayName) {
//        player.getInventory().clear();
//        ItemStack item = new ItemStack(Material.WHITE_BED);
//        ItemMeta meta = item.getItemMeta();
//        if (itemDisplayName != null && meta != null) {
//            meta.setDisplayName(itemDisplayName);
//            item.setItemMeta(meta);
//            player.getInventory().setItem(9, item);
//        }
//    }

    public static void changeGameMode(Player player, GameMode gameMode) {
        Bukkit.getScheduler().runTaskLater(TohuManagement.getPlugin(TohuManagement.class), () -> {
            player.setGameMode(gameMode);
        }, 20L);
    }
}
