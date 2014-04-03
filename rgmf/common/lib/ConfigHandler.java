package lib;

import blocks.BlockInfo;
import net.minecraftforge.common.Configuration;

import java.io.File;

/**
 * Created by Komoden on 25/03/14.
 */
public class ConfigHandler {

	public static final String CATEGORY_GENERAL = "General";
	public static boolean HARD_MODE;
	public static final String HARD_MODE_KEY = "Hard_Mode";
	public static final boolean HARD_MODE_DEFAULT = false;

	public static void init(File file)
	{
		Configuration config = new Configuration(file);
		config.load();

		HARD_MODE = config.get(CATEGORY_GENERAL, HARD_MODE_KEY, HARD_MODE_DEFAULT).getBoolean(false);

		BlockInfo.ADVDROPPER_ID = config.getBlock(BlockInfo.ADVDROPPER_KEY, BlockInfo.ADVDROPPER_DEFAULT).getInt();
		BlockInfo.ADVHOPPER_ID = config.getBlock(BlockInfo.ADVHOPPER_KEY, BlockInfo.ADVHOPPER_DEFAULT).getInt();
		BlockInfo.COLOREDSTONE_ID = config.getBlock(BlockInfo.COLOREDSTONE_KEY, BlockInfo.COLOREDSTONE_DEFAULT).getInt();

		config.save();
	}
}

