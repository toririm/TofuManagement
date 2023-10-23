package com.tohu.tohumanagement.Commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class WeatherCommand {
    public static boolean weatherCommand(String type, Player player, World world) {


        switch (type) {
            case "rain":
                world.setStorm(true);
                world.setThundering(false);
                player.sendMessage("雨を降らせました");
                return true;
            case "thunder":
                world.setStorm(true);
                world.setThundering(true);
                player.sendMessage("雷雨を降らせました");
                return true;
            case "clear":
                world.setStorm(false);
                world.setThundering(false);
                player.sendMessage("天気を晴れにしました");
                return true;
        }
        if (type.equals("true") || type.equals("false")) {
            world.setGameRuleValue("doWeatherCycle", type);
            if (type.equals("true")) {
                player.sendMessage("天気の固定を無効化しました");
            } if (type.equals("false")) {
                player.sendMessage("天気の固定を有効化しました");
            }
            return true;
        }
        else {
            player.sendMessage(ChatColor.RED + "!!!" + ChatColor.WHITE + "コマンドが間違えてるよ" + ChatColor.RED + "!!!");
            return false;
        }
    }
}
