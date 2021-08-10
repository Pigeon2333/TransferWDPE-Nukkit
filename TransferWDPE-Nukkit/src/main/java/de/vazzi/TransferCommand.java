package de.vazzi;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginIdentifiableCommand;
import cn.nukkit.plugin.Plugin;

public class TransferCommand extends Command implements PluginIdentifiableCommand {
    private Plugin plugin = null;

    public TransferCommand(Plugin plugin) {
        super("wtransfer", "Transfer to another proxy server.");
        this.setPermission("wtransfer.command");
        this.setUsage("/wtransfer server | /wtransfer player server");
        this.plugin = plugin;
    }

    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (!commandSender.hasPermission(this.getPermission())) {
            return true;
        } else if (strings.length < 1) {
            return true;
        } else if (strings.length < 2) {
            if (commandSender.isPlayer()) {
                commandSender.sendMessage("§fYou will be transfered to §a" + strings[0]);
                TransferWDPE.transferPlayer((Player)commandSender, strings[0]);
                return true;
            } else {
                return true;
            }
        } else {
            Player targetplayer = this.getPlugin().getServer().getPlayer(strings[0]);
            if (targetplayer != null) {
                String var10001 = targetplayer.getName();
                commandSender.sendMessage("§fPlayer §a" + var10001 + " §fwill be transfered to §a" + strings[1]);
                TransferWDPE.transferPlayer(targetplayer, strings[1]);
                return true;
            } else {
                return true;
            }
        }
    }

    public Plugin getPlugin() {
        return this.plugin;
    }
}
