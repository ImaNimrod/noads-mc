package net.nimrod.noads.command.commands;

import net.nimrod.noads.blocker.Blocker;
import net.nimrod.noads.blocker.BlockerManager;
import net.nimrod.noads.command.Command;
import net.nimrod.noads.command.CommandExecutionException;
import net.nimrod.noads.util.LogUtils;

public class Toggle extends Command {
    
    public Toggle() {
        super("Toggle", "Toggles the selected blocker on or off", "toggle [blocker]", "t", "toggle");
    }

    @Override
    public void onExecute(String[] args) throws CommandExecutionException {
        if (args.length != 1)
            throw new CommandExecutionException("Provide blocker name");

        Blocker blocker = BlockerManager.getBlocker(args[0]);
        if (blocker == null) {
            throw new CommandExecutionException(String.format("Blocker '%s' not found", args[0]));
        } else {
            blocker.toggle();
            LogUtils.chatLog(String.format("Blocker '%s' toggled %s", args[0], (blocker.getEnabled() ? "on" : "off")));
        }
    }

}
