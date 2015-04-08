package me.mrkirby153.chieves.achievement;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ChieveDiggyDiggy extends Chieve {

    public ChieveDiggyDiggy() {
        super(Type.PICKUP_ITEM, 0, 2, new ItemStack(Blocks.dirt), "DiggyDiggy", Chieves.mostlyHarmless.getAchievement());
    }

}
