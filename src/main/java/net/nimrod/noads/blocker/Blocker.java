package net.nimrod.noads.blocker;

import net.minecraft.client.MinecraftClient;

public abstract class Blocker {

    private final String name;
    private final String description;
    private boolean enabled;

    protected final MinecraftClient mc = MinecraftClient.getInstance();

    public Blocker(String name, String description) {
        this.name = name;
        this.description = description;
        this.enabled = false;
    }

    public void onEnable() {}
    public void onDisable() {}

    public void toggle() {
        enabled = !enabled;

        if (enabled)
            onEnable();
        else
            onDisable();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
