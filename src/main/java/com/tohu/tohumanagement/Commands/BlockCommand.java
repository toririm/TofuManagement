package com.tohu.tohumanagement.Commands;

import org.bukkit.entity.Player;

public class BlockCommand {
    public static boolean checkBlockId(String type, Player player) {
        if (type.equals("check")) {
            String blockId = player.getInventory().getItemInMainHand().getType().name();
            player.sendMessage("このブロックのIDは、" + blockId + "です");
            return true;
        } else {
            player.sendMessage("コマンドが間違えてるよ");
            return false;
        }
    }
}
