package com.tohu.tohumanagement.Services;

import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerManagement {
    //サーバー移動
    public static void moveServer(Player player, TohuManagement plugin, String serverName) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeUTF("Connect");
        dos.writeUTF(serverName);
        player.sendPluginMessage(plugin, "WaterFall", baos.toByteArray());
        baos.close();
        dos.close();
    }
}
