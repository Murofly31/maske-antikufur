package org.oyuncozucu.maskeAntiKufur;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import java.util.List;

public class ChatListener implements Listener {
    private final MaskeAntiKufurPlugin plugin;

    public ChatListener(MaskeAntiKufurPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String msg = event.getMessage().toLowerCase().replaceAll("[^a-zA-Z0-9ğüşöçıİĞÜŞÖÇ]", "");
        List<String> badWords = plugin.getBadWords();

        for (String word : badWords) {
            String normalizedWord = word.toLowerCase().replaceAll("[^a-zA-Z0-9ğüşöçıİĞÜŞÖÇ]", "");
            if (msg.contains(normalizedWord)) {
                event.setCancelled(true);
                String warningMsg = plugin.getConfig().getString("settings.messages.warning", "Küfür kullanmak yasaktır!");
                event.getPlayer().sendMessage(warningMsg.replace("{player}", event.getPlayer().getName()));
                return;
            }
        }
    }
}