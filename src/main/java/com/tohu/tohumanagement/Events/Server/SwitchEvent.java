package com.tohu.tohumanagement.Events.Server;

import com.tohu.tohumanagement.Config;
import com.tohu.tohumanagement.Services.PermissionManagement;
import com.tohu.tohumanagement.Services.PlayerManagement;
import com.tohu.tohumanagement.TohuManagement;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class SwitchEvent implements Listener {
    TohuManagement plugin;
    public SwitchEvent(TohuManagement plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((org.bukkit.event.Listener) this, this.plugin);
    }

    @EventHandler
    public void onServerSwitchEvent(ServerSwitchEvent e) {
        Player player = (Player) e.getPlayer();
        String serverName = e.getPlayer().getServer().getInfo().getMotd();
        if (serverName.equals("lobby")) {
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
        }

    }
}
