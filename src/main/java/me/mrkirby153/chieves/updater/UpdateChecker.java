package me.mrkirby153.chieves.updater;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class UpdateChecker {

    public static final String updateCheckFile = "https://dl.dropboxusercontent.com/u/121954827/modding/Chieves/version.json";
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
}
