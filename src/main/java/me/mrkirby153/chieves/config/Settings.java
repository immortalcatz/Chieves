package me.mrkirby153.chieves.config;

import me.mrkirby153.chieves.updater.UpdateChecker;

public class Settings {

    public static class Version {
        public static boolean enableVersionCheck = false;
        public static final boolean enableVersionCheckDefault = true;

        public static UpdateChecker.Channel versionChannel = UpdateChecker.Channel.STABLE;
        public static final UpdateChecker.Channel versionChannelDefault = UpdateChecker.Channel.STABLE;
    }

    public static class General {
        public static boolean debug = false;
        public static final boolean debugDefault = false;
    }
}
