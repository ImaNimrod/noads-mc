package net.nimrod.noads;

import net.fabricmc.api.ModInitializer;
import net.nimrod.noads.blocker.BlockerManager;
import net.nimrod.noads.command.CommandManager;
import net.nimrod.noads.util.LogUtils;

public class NoAds implements ModInitializer {

    public static final String NAME = "noads";
    public static final String VERSION = "1.0.0";
    public static final String AUTHOR = "nimrod";

	@Override
	public void onInitialize() {
        BlockerManager.init();
        CommandManager.init();

		LogUtils.consoleLog(String.format("%s v%s - created by %s", NAME, VERSION, AUTHOR));
	}

}
