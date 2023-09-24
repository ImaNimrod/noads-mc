package net.nimrod.noads.command;

import net.minecraft.client.MinecraftClient;

public abstract class Command {

    private final String name;
    private final String description;
    private final String syntax;
    private final String[] aliases;

    protected final MinecraftClient mc = MinecraftClient.getInstance();

    public Command(String name, String description, String syntax, String... aliases) {
        this.name = name;
        this.description = description;
        this.syntax = syntax;
        this.aliases = aliases;
    }

    public abstract void onExecute(String[] args) throws CommandExecutionException;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSyntax() {
        return syntax;
    }

    public String[] getAliases() {
        return aliases;
    }

}
