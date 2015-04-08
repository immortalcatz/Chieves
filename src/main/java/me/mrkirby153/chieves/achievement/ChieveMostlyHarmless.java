package me.mrkirby153.chieves.achievement;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ChieveMostlyHarmless extends Chieve{

    public ChieveMostlyHarmless(){
        super(Type.OTHER, 0, 0, new ItemStack(Blocks.grass), "MostlyHarmless", null);
        setSpecial();
    }

    @Override
    public boolean canAward(World world, EntityPlayer player, ItemStack itemStack) {
        return false;
    }
}
