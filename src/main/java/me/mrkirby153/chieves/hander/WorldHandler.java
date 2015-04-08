package me.mrkirby153.chieves.hander;

import me.mrkirby153.chieves.achievement.Chieves;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class WorldHandler {

    @Mod.EventHandler
    public void onPlayerTick(TickEvent.PlayerTickEvent event){
        World playerWorld = event.player.worldObj;
        if(playerWorld.isRaining()){
            event.player.addStat(Chieves.itsRaining.getAchievement(), 1);
        }
    }
}
