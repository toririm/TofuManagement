package com.tohu.tohumanagement.Services;

import com.tohu.tohumanagement.Config;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class ChatLogManagement {
    public static void saveChatLog(Player player, String chat) {
        String url = Config.baseURL + "/mc/chat_logs";
        String uuid = player.getUniqueId().toString();
        String worldName = player.getWorld().getName();
        String serverName = player.getServer().getMotd();
        Map<String, Object> json = new HashMap<>();
        json.put("uuid", uuid);
        json.put("chat", chat);
        json.put("mc_world_name", worldName);
        json.put("server_name", serverName);
        HttpReq.Post(url, json);
    }
}
