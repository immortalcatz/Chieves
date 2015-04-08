package me.mrkirby153.chieves.achievement;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ChieveItsRainingItsPouring extends Chieve {
    public ChieveItsRainingItsPouring() {
        super(Type.OTHER, -3, 0, new ItemStack(Items.water_bucket), "ItsRainingItsPouring", Chieves.mostlyHarmless.getAchievement());
    }

    @Override
    public boolean canAward(World world, EntityPlayer player, ItemStack itemStack) {
        return false;
    }
}
