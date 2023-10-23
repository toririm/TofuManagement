package com.tohu.tohumanagement.Services;

import com.tohu.tohumanagement.Config;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class WorldManagement {

    //ワールド情報を保存する
    public static void saveWorld(World world) {
        String url = Config.baseURL + "/mc/worlds";
        String name = world.getName();
        String serverName = Bukkit.getServer().getMotd();
        HashMap<String, Object> json = new HashMap<>();
        json.put("name", name);
        json.put("server_name", serverName);
        HttpReq.Post(url, json);
    }

    public static String authRole(Player player, String authCode) {
        String url = Config.baseURL + "/mc/world_role_auth";
        String uuid = player.getUniqueId().toString();
        String worldName = player.getWorld().getName();
        HashMap<String, Object> json = new HashMap<>();
        json.put("uuid", uuid);
        json.put("world_name", worldName);
        json.put("auth_code", authCode);
        return HttpReq.Post(url, json);
    }
}
