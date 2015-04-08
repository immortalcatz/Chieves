package me.mrkirby153.chieves.achievement;

public class Chieves {

    public static ChieveMostlyHarmless mostlyHarmless;
    public static ChieveDiggyDiggy diggyDiggy;
    public static ChieveItsRainingItsPouring itsRaining;

    public static void initalize(){
        mostlyHarmless = new ChieveMostlyHarmless();
        diggyDiggy = new ChieveDiggyDiggy();
        itsRaining = new ChieveItsRainingItsPouring();
        AchievementHandler.postInit();
    }
}
