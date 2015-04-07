package me.mrkirby153.chieves;

import me.mrkirby153.chieves.proxy.CommonProxy;
import me.mrkirby153.chieves.reference.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name=Reference.MOD_NAME, version = Reference.VERSION)
public class Chieves {

    @Mod.Instance(Reference.MOD_ID)
    public static Chieves instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
    }
}
