package me.mrkirby153.chieves.proxy;

import me.mrkirby153.chieves.config.ConfigHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event){
        ConfigHandler.init(event.getSuggestedConfigurationFile());
    }
}
