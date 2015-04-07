package me.mrkirby153.chieves.proxy;

import me.mrkirby153.chieves.config.ConfigHandler;
import me.mrkirby153.chieves.updater.UpdateChecker;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        // Load configuration settings
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        UpdateChecker checker = new UpdateChecker();
        checker.init();
    }
}
