package net.nimrod.noads.blocker;

import net.nimrod.noads.blocker.blockers.*;

import java.util.ArrayList;
import java.util.List;

public class BlockerManager {

    private static final List<Blocker> blockers = new ArrayList<Blocker>();

    public static void init() {
        blockers.clear();

        blockers.add(new AdvancementBlocker());
    }

    public static Blocker getBlocker(Class<?> blocker) {
        return blockers.stream().filter(b -> b.getClass() == blocker).findFirst().orElse(null);
    }

    public static Blocker getBlocker(String name) {
        return blockers.stream().filter(b -> b.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public static List<Blocker> getBlockers() {
        return blockers;
    }

    public static List<Blocker> getEnabledBlockers() {
        List<Blocker> enabledBlockers = new ArrayList<Blocker>();

        for (Blocker blocker : blockers) {
            if (blocker.getEnabled())
                enabledBlockers.add(blocker);
        }

        return enabledBlockers;
    }

}
