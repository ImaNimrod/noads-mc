package net.nimrod.noads.blocker.blockers;

import net.nimrod.noads.blocker.Blocker;

public class AdvancementBlocker extends Blocker {

    public AdvancementBlocker() {
        super("AdvancementBlocker", "Blocks in-game ads in the form of game advancements");
        setEnabled(true);
    }

}
