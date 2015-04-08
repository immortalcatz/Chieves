package me.mrkirby153.chieves.achievement;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import java.util.*;

public class AchievementHandler {

    public static AchievementPage chievesPage;
    public static Map<String, Achievement> achievements = new HashMap<>();

    public static void postInit() {
        ArrayList<Achievement> achievementArrayList = getAllAchievements();
        chievesPage = new AchievementPage("Chieves", achievementArrayList.toArray(new Achievement[achievementArrayList.size()]));
        AchievementPage.registerAchievementPage(chievesPage);
    }

    public static ArrayList<Achievement> getAllAchievements() {
        ArrayList<Achievement> ach = new ArrayList<>();
        for (String s : achievements.keySet()) {
            ach.add(achievements.get(s));
        }
        return ach;
    }

    public static Achievement findAchievementByName(String name){
        return achievements.get(name);
    }

    public static void registerAchievement(String name, Achievement achievement){
        if(achievements.get(name) != null){
            throw new RuntimeException("The achievement with the name "+name+" already exists!");
        }
        achievements.put(name, achievement);
    }
}
