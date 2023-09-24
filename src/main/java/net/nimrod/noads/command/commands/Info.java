package net.nimrod.noads.command.commands;

import net.nimrod.noads.NoAds;
import net.nimrod.noads.command.Command;
import net.nimrod.noads.command.CommandExecutionException;
import net.nimrod.noads.util.LogUtils;

public class Info extends Command {
    
    public Info() {
        super("Info", "Displays info about NoAds", "info", "i", "info");
    }

    @Override
    public void onExecute(String[] args) throws CommandExecutionException {
        if (args.length == 0) {
            LogUtils.chatLog(String.format("%s v%s - created by %s", NoAds.NAME, NoAds.VERSION, NoAds.AUTHOR));
        } else {
            throw new CommandExecutionException("Syntax: " + getSyntax());
        }
    }

}
