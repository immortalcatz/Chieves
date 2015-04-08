package me.mrkirby153.chieves.achievement;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public
class ChieveDiggyDiggy extends Chieve {

    public ChieveDiggyDiggy() {
        super(Type.PICKUP_ITEM, 0, 2, new ItemStack(Blocks.dirt), "DiggyDiggy", Chieves.mostlyHarmless.getAchievement());
    }

    @Override
    public boolean canAward(World world, EntityPlayer player, ItemStack itemStack) {
        return false;
    }
}
