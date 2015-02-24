package lib;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

/**
 * Created by beringtom on 05-03-14.
 */
public class PacketHandler{

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.LOWERCASE_MOD_ID);

	public static void init()
	{

	}
}
