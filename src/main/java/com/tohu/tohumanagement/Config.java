package com.tohu.tohumanagement;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Config {
    //本番用のURL
    public static String baseURL = "https://tohu-server-prod-ibldvcwaka-an.a.run.app/api";
//    public static String baseURL = "http://host.docker.internal:8000/api";
    //開発用のURL
//    public static String devBaseURL = "http://host.docker.internal:8000/api";
    //各サーバのロビー情報
    public static World world = Bukkit.getWorld("lobby");

    public static World TofuLobby = Bukkit.getWorld("world");
    //S001のロビースポーン地点
    public static Location s001Spawn = new Location(world, 997.384, 4, 1052.602, 174, 3);
    //P001のロビースポーン地点
    public static Location p001Spawn = new Location(world, 1000, 5, 1000);
    //Lobbyのロビースポーン地点
    public static Location lobbySpawn = new Location(world, -1521, 4, 514, 88, 2);
    //Tofuのロビースポーン地点
    public static Location tofuSpawn = new Location(TofuLobby, -52, 88, 8, -91, 6);

    public static Location textDisplaySpawn = new Location(TofuLobby, -52, 90, 8, -91, 6);
}
