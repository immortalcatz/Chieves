package me.mrkirby153.chieves.updater;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class UpdateChecker {

    public static final String updateCheckUrl = "http://mrkirby153.tk:8080/job/Chieves/lastSuccessfulBuild/api/json"; // Use jenkins
    public static final String latestBuildNumber = "http://mrkirby153.tk:8080/job/Chieves/lastSuccessfulBuild/buildNumber";
    public static final String updateDownloadUrl = ""; // Download from jenkins?

    public static boolean updateDone = false;
    public static boolean updateFailure = false;
    public static boolean updateAvalable = false;
    public static boolean notifiedPlayer = false;
    public static int newVersion = -1;

    public void init() {
        new ThreadUpdateChecker();
        FMLCommonHandler.instance().bus().register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (updateDone && event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().thePlayer != null && !notifiedPlayer && !updateFailure) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            player.addChatComponentMessage(new ChatComponentText("UPDATE! " + newVersion));
            notifiedPlayer = true;
        }
        if(updateDone && event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().thePlayer != null && !notifiedPlayer && updateFailure){
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            player.addChatComponentMessage(new ChatComponentText("UPDATE FAILED!"));
            notifiedPlayer = true;
        }
    }

    public enum Channel {
        STABLE,
        DEV;
    }

}
