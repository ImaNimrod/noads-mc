package net.nimrod.noads.command;

import net.nimrod.noads.command.commands.*;
import net.nimrod.noads.util.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {

    private static final List<Command> commands = new ArrayList<Command>();
    private static final String prefix = "$";

    public static void execute(String command) {
        if (command.isEmpty() || command.isBlank())
            return;

        String[] commandTokens = command.trim().split(" ");
        if (commandTokens.length == 0)
            return;

        Command cmd = getCommand(commandTokens[0]);
        String[] args = Arrays.copyOfRange(commandTokens, 1, commandTokens.length);

        if (cmd != null) {
            try {
                cmd.onExecute(args);
            } catch (CommandExecutionException cee) {
                LogUtils.chatLog(cee.getMessage());
            } catch (Exception e) {
                LogUtils.chatLog(String.format("Error while running command '%s'", cmd.getName()));
                e.printStackTrace();
            }
        } else {
            LogUtils.chatLog(String.format("Command '%s' not found", commandTokens[0]));
        }
    }

    public static void init() {
        commands.clear();

        commands.add(new Help());
        commands.add(new Info());
        commands.add(new net.nimrod.noads.command.commands.List());
        commands.add(new Toggle());
    }

    public static Command getCommand(Class<?> command) {
        return commands.stream().filter(c -> c.getClass() == command).findFirst().orElse(null);
    }

    public static Command getCommand(String alias) {
        for (Command command : commands) {
            for (String a : command.getAliases()) {
                if (a.equalsIgnoreCase(alias))
                    return command;
            }
        }

        return null;
    }

    public static List<Command> getCommands() {
        return commands;
    }

    public static String getPrefix() {
        return prefix;
    }

}
