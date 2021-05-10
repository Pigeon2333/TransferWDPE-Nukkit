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
        setPermission("wtransfer.command");
        setUsage("/wtransfer server | /wtransfer player server");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {

        if(!commandSender.hasPermission(getPermission())){
            return true;
        }

        if(strings.length < 1){
            return true;
        }

        if(strings.length < 2){
            if(commandSender.isPlayer()) {
                commandSender.sendMessage("§fYou will be transfered to §a" + strings[0]);
                TransferWDPE.transferPlayer((Player) commandSender, strings[0]);
                return true;
            }
            return true;
        }

        Player targetplayer = getPlugin().getServer().getPlayer(strings[0]);
        if(targetplayer != null) {
            commandSender.sendMessage("§fPlayer §a" + targetplayer.getName()  + " §fwill be transfered to §a" + strings[1]);
            TransferWDPE.transferPlayer(targetplayer, strings[1]);
            return true;
        }

        return true;

    }

    @Override
    public Plugin getPlugin() {
        return plugin;
    }
}
