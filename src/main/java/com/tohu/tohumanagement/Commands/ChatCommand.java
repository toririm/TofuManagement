package com.tohu.tohumanagement.Commands;

import org.bukkit.entity.Player;

import java.util.Objects;

public class ChatCommand {
    public static boolean chatCommand(String type, String playerName, Player player) {
        if (type != null && playerName.equals(player.getName())) {
            Player toPlayer = player.getPlayer();
            Objects.requireNonNull(toPlayer).sendMessage("From " + player.getName() + ": " + type);
            return true;
        } if (!playerName.equals(player.getName())) {
            player.sendMessage("プレイヤー名を間違えてるよ");
        } else {
            player.sendMessage("コマンドが間違えてるよ");
        }
        return false;
    }
}
