package com.tohu.tohumanagement.Commands;

import com.tohu.tohumanagement.Services.PlayerManagement;
import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Objects;

public class GameModeCommand {
    public static boolean gameModeCommand(String type, Player player, TohuManagement plugin) {
        if (type.equals("survival") || type.equals("creative") || type.equals("adventure") || type.equals("spectator")) {
            GameMode gameMode = GameMode.valueOf(type.toUpperCase());
            PlayerManagement.changeGameMode(player, gameMode);
            if (type.equals("survival")) player.sendMessage("ゲームモードをサバイバルに変更しました");
            if (type.equals("creative")) player.sendMessage("ゲームモードをクリエイティブに変更しました");
            if (type.equals("adventure")) player.sendMessage("ゲームモードをアドベンチャーに変更しました");
            if (type.equals("spectator")) player.sendMessage("ゲームモードをスペクテイターに変更しました");
            return true;
        }else {
            player.sendMessage(ChatColor.RED + "!!!" + ChatColor.WHITE + "コマンドが間違えてるよ" + ChatColor.RED + "!!!");
            return false;
        }
    }

    public static boolean gameModeToPlayerCommand(String type, String playerName, Player player) {
        if (type.equals("survival") || type.equals("creative") || type.equals("adventure") || type.equals("spectator")) {
            GameMode gameMode = GameMode.valueOf(type.toUpperCase());
            Player receivePlayer = Objects.requireNonNull(Bukkit.getPlayer(playerName)).getPlayer();
            World world = Objects.requireNonNull(receivePlayer).getWorld();
            if (player.getWorld().getName().equals(world.getName())) {
                receivePlayer.setGameMode(gameMode);
                if (type.equals("survival")) receivePlayer.sendMessage(player.getName()+"にゲームモードをサバイバルに変更されました");
                if (type.equals("creative")) receivePlayer.sendMessage(player.getName()+"にゲームモードをクリエイティブに変更されました");
                if (type.equals("adventure")) receivePlayer.sendMessage(player.getName()+"にゲームモードをアドベンチャーに変更されました");
                if (type.equals("spectator")) receivePlayer.sendMessage(player.getName()+"にゲームモードをスペクテイターに変更されました");
                return true;
            }
            return true;
        } else {
            player.sendMessage(ChatColor.RED + "!!!" + ChatColor.WHITE + "コマンドが間違えてるよ" + ChatColor.RED + "!!!");
            return false;
        }
    }
}
