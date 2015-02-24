package lib;

import cpw.mods.fml.common.FMLLog;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Komoden on 05/03/14.
 */
public class LogHelper {
	private static Logger logger = Logger.getLogger(ModInfo.MOD_ID);


	public static void log(Level logLevel, String message)
	{
		logger.log(logLevel, message);
	}
}
