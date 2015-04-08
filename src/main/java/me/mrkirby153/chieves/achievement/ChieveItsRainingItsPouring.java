package me.mrkirby153.chieves.achievement;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ChieveItsRainingItsPouring extends Chieve {
    public ChieveItsRainingItsPouring() {
        super(Type.OTHER, -3, 0, new ItemStack(Items.water_bucket), "ItsRainingItsPouring", Chieves.mostlyHarmless.getAchievement());
    }
}
