package com.tohu.tohumanagement.Commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class GiveCommand {
    public static boolean giveCommand(String type, Player player, String item) {
        if (type.equals("give")) {
            Material material = Material.getMaterial(item);
            ItemStack itemStack = new ItemStack(Objects.requireNonNull(material));
            Inventory inventory = player.getInventory();
            inventory.setItem(inventory.firstEmpty(), itemStack);
            return true;
        } else {
            player.sendMessage("コマンドが間違えてるよ");
            return false;
        }
    }
}
