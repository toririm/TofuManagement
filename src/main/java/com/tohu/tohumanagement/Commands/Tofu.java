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
                }
            }
            return false;
        }
    }

