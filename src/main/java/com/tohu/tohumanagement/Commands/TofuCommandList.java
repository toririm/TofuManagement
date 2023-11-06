package com.tohu.tohumanagement.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TofuCommandList {
    public static void viewCommandList(CommandSender sender) {
        sender.sendMessage("Tofuはこちらから");
        sender.sendMessage(ChatColor.YELLOW + "https://tofu-66fa7.web.app/");
        sender.sendMessage("----------使えるコマンド----------");
        sender.sendMessage(ChatColor.YELLOW + "昼や夜に変える: " + ChatColor.WHITE + "/tofu time day/night");
        sender.sendMessage(ChatColor.YELLOW + "天気を<晴れ/雨/雷雨>にする: " + ChatColor.WHITE + "/tofu weather <clear/rain/thunder>");
        sender.sendMessage(ChatColor.YELLOW + "時間を固定(無効/有効): " + ChatColor.WHITE + "/tofu time <true/false>");
        sender.sendMessage(ChatColor.YELLOW + "天気を固定(無効/有効): " + ChatColor.WHITE + "/tofu weather <true/false>");
        sender.sendMessage(ChatColor.YELLOW + "Mobの湧き設定(有効/無効): " + ChatColor.WHITE + "/tofu mob <true/false>");
        sender.sendMessage(ChatColor.YELLOW + "mobたちをキルする: " + ChatColor.WHITE + "/tofu mob kill");
        sender.sendMessage(ChatColor.YELLOW + "ゲームモードの変更: " + ChatColor.WHITE + "/tofu gamemode <survival/creative/adventure/spectator>");
        sender.sendMessage(ChatColor.YELLOW + "人のゲームモードの変更: " + ChatColor.WHITE + "/tofu gamemode <survival/creative/adventure/spectator> [変えたい人の名前]");
//        sender.sendMessage(ChatColor.YELLOW + "Worldの情報を確認する: " + ChatColor.WHITE + "/tohu world info");
        sender.sendMessage(ChatColor.YELLOW + "特定のユーザにチャットをする: " + ChatColor.WHITE + "/tofu chat [メッセージ] [プレイヤー名]");
        sender.sendMessage(ChatColor.YELLOW + "現在地をリスポーン地点に設定: " + ChatColor.WHITE + "/tofu set spawn");
        sender.sendMessage(ChatColor.YELLOW + "特定のプレイヤーにテレポートします: " + ChatColor.WHITE + "/tofu tp [プレイヤー名]");
//        sender.sendMessage(ChatColor.YELLOW + "ワールド一覧を表示: " + ChatColor.WHITE + "/tohu world list");
        sender.sendMessage(ChatColor.YELLOW + "アイテム付与: " + ChatColor.WHITE + "/tofu give [アイテム名:STONE_AXEなど]");
        sender.sendMessage("--------------------------------");
    }
}
