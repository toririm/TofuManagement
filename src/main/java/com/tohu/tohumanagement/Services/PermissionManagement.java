package com.tohu.tohumanagement.Services;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import org.bukkit.entity.Player;

public class PermissionManagement {
    LuckPerms luckPerms;
    //プレイヤーの権限グループを変更
    public static void changeParentGroup(Player player, String newGroupName) {
        LuckPerms luckPerms = LuckPermsAPIManager.getLuckPerms();
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());
        Group newParentGroup = luckPerms.getGroupManager().getGroup(newGroupName);
        if (user != null && newParentGroup != null ) {
            String oldParentGroupName = user.getPrimaryGroup();
            user.data().remove(Node.builder("group." + oldParentGroupName).build());
            user.data().add(Node.builder("group." + newGroupName).build());
            luckPerms.getUserManager().saveUser(user);
        }
    }
}
