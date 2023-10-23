package com.tohu.tohumanagement.Services;

import com.tohu.tohumanagement.Config;
import com.tohu.tohumanagement.Services.HttpReq;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class AuthManagement {
    public static String auth(String authCode, Player player) {
        String url = Config.baseURL + "/mc/auth";
        Map<String, Object> json = new HashMap<>();
        json.put("uuid", player.getUniqueId().toString());
        json.put("world_name", player.getWorld().getName());
        json.put("auth_code", authCode);
        return HttpReq.Post(url, json);
    }
}
