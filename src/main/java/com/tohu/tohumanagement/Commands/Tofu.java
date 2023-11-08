package com.tohu.tohumanagement.Commands;

import com.tohu.tohumanagement.TohuManagement;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tofu implements CommandExecutor {
    private static final TohuManagement plugin = TohuManagement.getPlugin(TohuManagement.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        Player player = (Player) commandSender;
        World world = player.getWorld();
        if (command.getName().equalsIgnoreCase("tofu")) {
            if (args.length == 0) {
                TofuCommandList.viewCommandList(commandSender);
                return true;
            } else {
                switch (args[0]) {
                    case "login":
                        if (player.hasPermission("custom.default")) return LoginCommand.loginCommand(args[1], player);
                        else player.sendMessage("権限がありません");
                        break;
                    case "auth":
                        if (player.hasPermission("custom.default")) return WorldCommand.authWorld(args[1], player);
                        else player.sendMessage("権限がありません");
                        break;
                    case "spawn":
                        if (player.hasPermission("custom.tofu")) return WorldCommand.setSpawnLocationCommand(args[1], player);
                        else player.sendMessage("権限がありません");
                        break;
                    case "tp":
                        if (player.hasPermission("custom.tofu")) return TeleportCommand.teleportCommand(args[0], player, args[1]);
                        else player.sendMessage("権限がありません");
                        break;
                    case "time":
                        if (player.hasPermission("custom.tofu")) return TimeCommand.timeCommand(args[1], player, world);
                        else player.sendMessage("権限がありません");
                        break;
                    case "gamemode":
                        if (player.hasPermission("custom.tofu")) return GameModeCommand.gameModeCommand(args[1], player, plugin);
                        else player.sendMessage("権限がありません");
                        break;
                    case "weather":
                        if (player.hasPermission("custom.tofu")) return WeatherCommand.weatherCommand(args[1], player, world);
                        else player.sendMessage("権限がありません");
                        break;
                    case "mob":
                        if (player.hasPermission("custom.tofu")) return MobCommand.mobCommand(args[1], player, world);
                        else player.sendMessage("権限がありません");
                        break;
                    case "give":
                        if (player.hasPermission("custom.tofu")) return GiveCommand.giveCommand(args[0], player, args[1]);
                        else player.sendMessage("権限がありません");
                        break;
                    case "chat":
                        if (player.hasPermission("custom.tofu")) return ChatCommand.chatCommand(args[1], args[2], player);
                        else player.sendMessage("権限がありません");
                        break;
                    case "check":
                        if (player.hasPermission("custom.tofu")) return BlockCommand.checkBlockId(args[0], player);
                        else player.sendMessage("権限がありません");
                        break;
                    default:
                        player.sendMessage("コマンドが間違えてるよ");
                        break;
                }
//                if (args[0].equals("login") && player.hasPermission("custom.default"))return LoginCommand.loginCommand(args[1], player);
//                if (args[0].equals("auth") && player.hasPermission("custom.default")) return WorldCommand.authWorld(args[1], player);
//                if (args[0].equals("spawn") && player.hasPermission("custom.tofu")) return WorldCommand.setSpawnLocationCommand(args[1], player);
//                if (args[0].equals("tp") && player.hasPermission("custom.tofu")) return TeleportCommand.teleportCommand(args[0], player, args[1]);
//                if (args[0].equals("time") && player.hasPermission("custom.tofu")) return TimeCommand.timeCommand(args[1], player, world);
//                if (args[0].equals("gamemode") && player.hasPermission("custom.tofu")) return GameModeCommand.gameModeCommand(args[1], player, plugin);
//                if (args[0].equals("weather") && player.hasPermission("custom.tofu")) return WeatherCommand.weatherCommand(args[1], player, world);
//                if (args[0].equals("mob") && player.hasPermission("custom.tofu")) return MobCommand.mobCommand(args[1], player, world);
//                if (args[0].equals("give") && player.hasPermission("custom.tofu")) return GiveCommand.giveCommand(args[0], player, args[1]);
//                if (args[0].equals("chat") && player.hasPermission("custom.tofu")) return ChatCommand.chatCommand(args[1], args[2], player);
//                if (args[0].equals("check") && player.hasPermission("custom.tofu")) return BlockCommand.checkBlockId(args[0], player);
//                if (!player.hasPermission("custom.tofu") || !player.hasPermission("custom.default")) player.sendMessage("権限がありません");
//                else player.sendMessage("コマンドが間違えてるよ");
                }
            }
            return false;
        }
    }

