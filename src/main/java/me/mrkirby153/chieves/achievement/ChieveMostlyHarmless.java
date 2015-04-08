package me.mrkirby153.chieves.achievement;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ChieveMostlyHarmless extends Chieve{

    public ChieveMostlyHarmless(){
        super(Type.OTHER, 0, 0, new ItemStack(Blocks.grass), "MostlyHarmless", null);
        setSpecial();
    }
}
