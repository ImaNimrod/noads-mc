package net.nimrod.noads.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.nimrod.noads.NoAds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

    private static final Logger logger = LoggerFactory.getLogger(NoAds.NAME);
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void chatLog(String message) {
        mc.inGameHud.getChatHud().addMessage(Text.of("§5[noads]§f " + message));
    }

    public static void consoleLog(String message) {
        logger.info(message);
    }

}
