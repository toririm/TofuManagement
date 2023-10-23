package com.tohu.tohumanagement.Commands;

import com.tohu.tohumanagement.Services.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class WorldCommand {
    public static boolean setSpawnLocationCommand(String type, Player player) {
        if (type.equals("spawn")) {
            player.performCommand("mv set spawn");
            player.sendMessage("座標: " + player.getLocation().getBlockX() + ", " + player.getLocation().getBlockY() + ", " + player.getLocation().getBlockZ() + "にリスポーン地点が設定されました");
            return true;
        } else {
            player.sendMessage(ChatColor.RED + "!!!" + ChatColor.WHITE + "コマンドが間違えてるよ" + ChatColor.RED + "!!!");
            return false;
        }
    }

    public static boolean authWorld(String type, Player player) {
        if (type != null) {
            player.sendMessage("ワールド認証中です");
            String json = WorldManagement.authRole(player, type);
            boolean authorized = AuthorizedUtil.getAuthorized(json);
            String worldName = McWorldUtil.getName(json);
            if (authorized && worldName.equals(player.getWorld().getName())) {
                player.sendMessage("ワールド認証に成功しました");
                player.sendMessage("モデレーター権限を付与します");
                PermissionManagement.changeParentGroup(player, "moderator");
                return true;
            } else if (authorized && !worldName.equals(player.getWorld().getName())) {
                player.sendMessage("ワールドが違います");
                return false;
            } else {
                player.sendMessage("ワールド認証に失敗しました");
                return false;
            }
        } else {
            player.sendMessage(ChatColor.RED + "!!!" + ChatColor.WHITE + "コマンドが間違えてるよ" + ChatColor.RED + "!!!");
            return false;
        }
    }
}
