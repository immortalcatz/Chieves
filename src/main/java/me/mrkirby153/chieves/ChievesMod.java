package me.mrkirby153.chieves;

import me.mrkirby153.chieves.achievement.Chieves;
import me.mrkirby153.chieves.proxy.CommonProxy;
import me.mrkirby153.chieves.reference.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name=Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class ChievesMod {

    @Mod.Instance(Reference.MOD_ID)
    public static ChievesMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        // TODO: Add initializations to proxy
        Chieves.initalize();
    }
}
