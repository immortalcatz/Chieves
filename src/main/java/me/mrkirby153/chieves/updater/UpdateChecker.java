package me.mrkirby153.chieves.updater;

import me.mrkirby153.chieves.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class UpdateChecker {

    public static final String updateCheckFile = "https://dl.dropboxusercontent.com/u/121954827/modding/Chieves/version.json";

    public static boolean updateDone = false;
    public static boolean updateFailure = false;
    public static boolean notifiedPlayer = false;
    public static String newVersion = null;

    public void init() {
        new ThreadUpdateChecker();
        FMLCommonHandler.instance().bus().register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        /*if (updateDone && event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().thePlayer != null && !notifiedPlayer && !updateFailure) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            player.addChatComponentMessage(new ChatComponentText("UPDATE! " + newVersion));
            notifiedPlayer = true;
        }
        if(updateDone && event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().thePlayer != null && !notifiedPlayer && updateFailure){
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            player.addChatComponentMessage(new ChatComponentText("UPDATE FAILED!"));
            notifiedPlayer = true;
        }*/
        if (updateDone && event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().thePlayer != null && !notifiedPlayer) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            if (updateFailure) {
                player.addChatComponentMessage(new ChatComponentTranslation("version.updateFailed").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED).setBold(true)));
            } else {
                if (newVersion != null) {
                    player.addChatComponentMessage(new ChatComponentTranslation("version.updateFound", newVersion, Reference.VERSION).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.AQUA)));
                }
            }
            notifiedPlayer = true;
        }
    }
}
