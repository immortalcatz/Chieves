package me.mrkirby153.chieves.achievement;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.world.World;

public abstract class Chieve {

    private final Type type;
    private final Achievement achievement;

    public Chieve(Type type, int xCoord, int yCoord, ItemStack displayIcon, String name, Achievement requirement) {
        Achievement achievement = new Achievement(name.toLowerCase(), name, xCoord, yCoord, displayIcon.getItem(), requirement);
        achievement.registerStat();

        this.type = type;
        this.achievement = achievement;
        AchievementHandler.registerAchievement(name.toLowerCase(), achievement);
    }

    public Type getType() {
        return type;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setSpecial() {
        achievement.setSpecial();
    }

    public abstract boolean canAward(World world, EntityPlayer player, ItemStack itemStack);

    public enum Type {
        CRAFT_ITEM,
        SMELT_ITEM,
        PICKUP_ITEM,
        OTHER
    }
}
