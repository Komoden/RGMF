package rgmf;

import blocks.client.RGMFGuiHandler;
import cpw.mods.fml.common.Loader;
import lib.ConfigHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;
import lib.*;
import blocks.blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.network.ForgePacketHandler;

import java.util.logging.Level;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
@NetworkMod(channels = {ModInfo.NETWORK_CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = ForgePacketHandler.class)
public class RGMF
{
	public static boolean IsIC2Loaded;

	@Instance(ModInfo.MOD_ID)
	public static RGMF instance;

	@SidedProxy(clientSide = "lib.ClientProxy", serverSide = "lib.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs rgmfTab = new RGMFTab(CreativeTabs.getNextID(), ModInfo.MOD_NAME);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		LogHelper.log(Level.INFO, "Setting up camp, Rød grød med?");
		IsIC2Loaded = Loader.isModLoaded("IC2");
		if (IsIC2Loaded) {
			LogHelper.log(Level.INFO, "IC2: Fløde!");
		}else{
			LogHelper.log(Level.INFO, "IC2: What?");
		}
		proxy.initSounds();
		proxy.initRenderers();
		LogHelper.init();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		blocks.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		LogHelper.log(Level.INFO, "Lighting the fire");
		LanguageRegistry.instance().addStringLocalization("itemGroup." + ModInfo.MOD_NAME, "en_US", ModInfo.MOD_NAME);
		LanguageRegistry.instance().addStringLocalization("itemGroup.rgmfTab", "en_US", "RGMF");
		blocks.registerTileEntities();
		blocks.addNames();
		Recipes.init();
		new RGMFGuiHandler();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		LogHelper.log(Level.INFO, "Roasting Marshmallows");
	}
}
