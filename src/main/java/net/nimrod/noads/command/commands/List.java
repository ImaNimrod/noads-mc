package net.nimrod.noads.command.commands;

import net.nimrod.noads.blocker.Blocker;
import net.nimrod.noads.blocker.BlockerManager;
import net.nimrod.noads.command.Command;
import net.nimrod.noads.command.CommandExecutionException;
import net.nimrod.noads.util.LogUtils;

public class List extends Command {
    
    public List() {
        super("List", "Lists all available ad blockers", "list", "l", "list");
    }

    @Override
    public void onExecute(String[] args) throws CommandExecutionException {
        if (args.length == 0) {
            StringBuilder stringBuilder = new StringBuilder();

            for (Blocker blocker : BlockerManager.getBlockers())
                stringBuilder.append(String.format("%s - Status: %s\n", blocker.getName(), (blocker.getEnabled() ? "on" : "off")));

            LogUtils.chatLog("AdBlockers:\n" + stringBuilder.toString());
        } else {
            throw new CommandExecutionException("Syntax: " + getSyntax());
        }
    }

}
