package org.oyuncozucu.maskeAntiKufur;

import java.util.HashMap;
import java.util.UUID;

public class WarningManager {
    private final MaskeAntiKufurPlugin plugin;
    private final HashMap<UUID, Integer> warnings = new HashMap<>();

    public WarningManager() {
        this.plugin = plugin;
    }

    public void addWarning(UUID uuid) {
        warnings.put(uuid, warnings.getOrDefault(uuid, 0) + 1);
        // Burada isterseniz uyarı sayısına göre ceza verebilirsiniz.
    }

    public int getWarnings(UUID uuid) {
        return warnings.getOrDefault(uuid, 0);
    }
}