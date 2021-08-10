package vazzi;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginIdentifiableCommand;
import cn.nukkit.plugin.Plugin;

public class TransferCommand extends Command implements PluginIdentifiableCommand {
    private Plugin plugin = null;

    public TransferCommand(Plugin plugin) {
        super("wtransfer", "传送到另一个下游服务器.");
        this.setPermission("wtransfer.command");
        this.setUsage("/wtransfer server");
        this.plugin = plugin;
    }

    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (!commandSender.hasPermission(this.getPermission())) {
            return true;
        } else if (strings.length < 1) {
            return true;
        } else if (strings.length < 2) {
            if (commandSender.isPlayer()) {
                commandSender.sendMessage("§l§a正在将您转发至 §r§f" + strings[0]);
                TransferWDPE.transferPlayer((Player) commandSender, strings[0]);
                return true;
            }

        }
        return true;
    }

    public Plugin getPlugin() {
        return this.plugin;
    }
}
