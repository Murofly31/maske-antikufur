package org.oyuncozucu.maskeAntiKufur;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.Arrays;
import java.util.List;

public class MaskeAntiKufurPlugin extends JavaPlugin {

    private static MaskeAntiKufurPlugin instance;
    private ConfigManager configManager;
    private WarningManager warningManager;
    private List<String> badWords = Arrays.asList("website", "ornek1", "ornek2");

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        configManager = new ConfigManager(this);
        warningManager = new WarningManager();

        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        getCommand("antikufur").setExecutor(new AntiKufurCommand());

        getLogger().info("Maske Anti Küfür başarıyla başlatıldı!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Maske Anti Küfür durduruldu!");
    }

    public static MaskeAntiKufurPlugin getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public WarningManager getWarningManager() {
        return warningManager;
    }

    public List<String> getBadWords() {
        return badWords;
    }
}