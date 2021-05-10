package de.vazzi;


import cn.nukkit.Player;
import cn.nukkit.network.protocol.TransferPacket;
import cn.nukkit.plugin.PluginBase;

public class TransferWDPE extends PluginBase {

    @Override
    public void onEnable() {
        getServer().getCommandMap().register("TransferWDPE", new TransferCommand(this));
    }

    public static void transferPlayer(Player player, String proxyserver){
        TransferPacket transferPacket = new TransferPacket();
        transferPacket.address = proxyserver;

        //port is default 19132
        player.dataPacket(transferPacket);
    }

}
