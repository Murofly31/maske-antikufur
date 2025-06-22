package org.oyuncozucu.maskeAntiKufur;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AntiKufurCommand implements CommandExecutor {
    private MaskeAntiKufurPlugin plugin = null;

    public AntiKufurCommand() {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Maske Anti Küfür eklentisi aktif!");
        return true;
    }
}