package lib;

import blocks.BlockInfo;
import net.minecraftforge.common.Configuration;

import java.io.File;

/**
 * Created by Komoden on 25/03/14.
 */
public class ConfigHandler {

	// General part of config
	public static final String CATEGORY_GENERAL = "General";
	public static boolean HARD_MODE;
	public static final String HARD_MODE_KEY = "Hard_Mode";
	public static final boolean HARD_MODE_DEFAULT = false;

	//Mod tweeks
	// dustClay to clay.
	public static final String CATEGORY_TWEEKS = "Mod Tweeks";
	public static boolean CLAYDUST_TO_CLAY;
	public static final String CLAYDUST_TO_CLAY_KEY = "Claydust_To_Clay";
	public static final boolean CLAYDUST_TO_CLAY_DEFAULT = false;

	public static void init(File file)
	{
		Configuration config = new Configuration(file);
		config.load();

		HARD_MODE = config.get(CATEGORY_GENERAL, HARD_MODE_KEY, HARD_MODE_DEFAULT).getBoolean(false);
		CLAYDUST_TO_CLAY = config.get(CATEGORY_TWEEKS, CLAYDUST_TO_CLAY_KEY, CLAYDUST_TO_CLAY_DEFAULT).getBoolean(false);

		BlockInfo.ADVDROPPER_ID = config.getBlock(BlockInfo.ADVDROPPER_KEY, BlockInfo.ADVDROPPER_DEFAULT).getInt();
		BlockInfo.ADVHOPPER_ID = config.getBlock(BlockInfo.ADVHOPPER_KEY, BlockInfo.ADVHOPPER_DEFAULT).getInt();
		BlockInfo.COLOREDSTONE_ID = config.getBlock(BlockInfo.COLOREDSTONE_KEY, BlockInfo.COLOREDSTONE_DEFAULT).getInt();
		BlockInfo.COLOREDBRICKS_ID = config.getBlock(BlockInfo.COLOREDBRICKS_KEY, BlockInfo.COLOREDBRICKS_DEFAULT).getInt();

		config.save();
	}
}

