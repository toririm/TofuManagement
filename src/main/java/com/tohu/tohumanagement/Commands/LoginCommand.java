package com.tohu.tohumanagement.Commands;

import com.tohu.tohumanagement.Services.*;
import org.bukkit.entity.Player;

public class LoginCommand {

    public static boolean loginCommand(String authCode, Player player) {
        String worldName = player.getWorld().getName();
        String playerName = player.getName();
        //認証してるかどうか
        if (authCode != null) {
            player.sendMessage("認証中です");
            String json = AuthManagement.auth(authCode, player);
            boolean authorized = AuthorizedUtil.getAuthorized(json);
            String playerWorldName = McWorldUtil.getName(json);
            int userId = McWorldUtil.getUserId(json);
            int role = UserUtil.getRole(json);
            if (authorized && playerWorldName.equals(worldName)) {
                player.sendMessage("認証に成功しました");
                player.sendMessage("あなたのworldは、" + player.getWorld().getName() + "です");
                player.sendMessage("ようこそ！" + playerName + "さん!");
                player.sendMessage("権限を付与します");
                player.sendMessage("あなたの権限は" + role + "です");
                if (role == 3) {
                    PermissionManagement.changeParentGroup(player, "admin");

                } else {
                    PermissionManagement.changeParentGroup(player, "owner");
                }
                return true;
            } else {
                player.sendMessage("認証に失敗しました");
                return false;
            }
        } else {
            player.sendMessage("コマンドが間違えてるよ");
            return false;
        }
    }
}
