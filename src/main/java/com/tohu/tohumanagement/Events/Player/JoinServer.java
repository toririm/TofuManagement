package com.tohu.tohumanagement.Events.Player;

import com.tohu.tohumanagement.Config;
import com.tohu.tohumanagement.Services.PermissionManagement;
import com.tohu.tohumanagement.Services.PlayerManagement;
import com.tohu.tohumanagement.Services.ServerManagement;
import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class JoinServer implements Listener {
    TohuManagement plugin;
    public JoinServer(TohuManagement plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) throws IOException {
        Player player = e.getPlayer();
        World world = player.getWorld();
        String serverName = Bukkit.getServer().getMotd();
        PlayerManagement.savePlayerLog(player);
//        if (!serverName.equals("Lobby")) {
//            ServerManagement.moveServer(player, plugin, "Lobby");
//        } else {
            player.sendMessage(player.getName() + "さん!こんにちわ！");
            player.sendTitle("ようこそ", "ToFuサーバーへ", 20, 20, 20);
            player.teleport(Config.tofuSpawn);
            PlayerManagement.changeGameMode(player, GameMode.ADVENTURE);
            PermissionManagement.changeParentGroup(player, "default");
            player.sendMessage("このリンクをクリックして、ToFuのWebサイトにログインしよう！");
            player.sendMessage(ChatColor.YELLOW + "https://tofu-66fa7.web.app/");
            player.sendMessage("ログインが終わったら、" + ChatColor.BLUE + "/tofu login 認証コード" + ChatColor.WHITE + "で認証を行ってください");
            player.sendMessage(ChatColor.YELLOW + "コマンドが'tohu'から'tofu'に変更されたので注意してください\n" +
                    "詳しくは /tofuを実行し使えるコマンドの一覧を見てみてください");
//        }
    }
}
