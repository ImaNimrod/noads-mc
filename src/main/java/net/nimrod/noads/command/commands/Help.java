package net.nimrod.noads.command.commands;

import net.nimrod.noads.blocker.Blocker;
import net.nimrod.noads.blocker.BlockerManager;
import net.nimrod.noads.command.Command;
import net.nimrod.noads.command.CommandExecutionException;
import net.nimrod.noads.command.CommandManager;
import net.nimrod.noads.util.LogUtils;

public class Help extends Command {
    
    public Help() {
        super("Help", "Displays helpful information about a command", "help <command>", "h", "help");
    }

    @Override
    public void onExecute(String[] args) throws CommandExecutionException {
        if (args.length == 0) {
            StringBuilder stringBuilder = new StringBuilder();

            for (Command command : CommandManager.getCommands())
                stringBuilder.append(command.getName() + ", ");

            LogUtils.chatLog("Commands: " + stringBuilder.substring(0, stringBuilder.length() - 2));
        } else if (args.length == 1) {
            Command command = CommandManager.getCommand(args[0]);
            if (command != null) {
                LogUtils.chatLog(String.format("%s - %s\nSyntax: %s\nAliases: %s",
                            command.getName(), command.getDescription(), 
                            command.getSyntax(), String.join(", ", command.getAliases())));
            } else {
                throw new CommandExecutionException(String.format("Command '%s' not found", args[0]));
            }
        } else {
            throw new CommandExecutionException("Syntax: " + getSyntax());
        }
    }

}
