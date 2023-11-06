package com.tohu.tohumanagement.Commands;

import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.entity.*;

public class MobCommand {

    public static boolean mobCommand(String type, Player player, World world) {
        GameRule<Boolean> doMobSpawning = GameRule.DO_MOB_SPAWNING;
        if (type.equals("kill")) {
            for (Entity e: world.getEntities()) {
                if (e instanceof Monster) {
                    ((Monster) e).setHealth(0);
                    player.sendMessage(e.getName() + " をキルしました");
                } else if (e instanceof Slime) {
                    ((Slime) e).setHealth(0);
                    player.sendMessage(e.getName() + " をキルしました");
                } else if (e instanceof Villager) {
                    ((Villager) e).setHealth(0);
                    player.sendMessage(e.getName() + " をキルしました");
                }
            }
            return true;
        }if (type.equals("true") || type.equals("false")) {

            world.setGameRule(doMobSpawning, Boolean.valueOf(type));
            if (type.equals("true")) {
                player.sendMessage("Mobが発生するようになりました");
            } else {
                player.sendMessage("Mobが発生しないようになりました");
            }
            return true;
        } else {
            player.sendMessage("コマンドが間違えてるよ");
            return false;
        }
    }
}
