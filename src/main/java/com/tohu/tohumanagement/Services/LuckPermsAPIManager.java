package com.tohu.tohumanagement.Services;

import com.tohu.tohumanagement.TohuManagement;
import net.luckperms.api.LuckPerms;
import org.bukkit.plugin.RegisteredServiceProvider;

public class LuckPermsAPIManager {
    private static LuckPerms luckPerms;
    //LuckPermsのインスタンスを取得
    public static LuckPerms getLuckPerms() {
        if (luckPerms == null) {
            RegisteredServiceProvider<LuckPerms> provider = TohuManagement.getPlugin(TohuManagement.class).getServer().getServicesManager().getRegistration(LuckPerms.class);
            if (provider != null) {
                luckPerms = provider.getProvider();
            } else {
                throw new RuntimeException("LuckPerms is not installed");
            }
        }
        return luckPerms;
    }

}
