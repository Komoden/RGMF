package lib;

import blocks.BlockInfo;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

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
	public static int CLAYOUTPUT;
	public static final String CLAYDUST_TO_CLAY_KEY = "Claydust_To_Clay";
	public static final boolean CLAYDUST_TO_CLAY_DEFAULT = false;
	public static final String CLAYDUST_OUTPUT_KEY = "Clay_Output";
	public static final int CLAYDUST_TO_CLAY_DEFAULT_OUTPUT = 8;

	public static void init(File file)
	{
		Configuration config = new Configuration(file);
		config.load();

		// General
		HARD_MODE = config.get(CATEGORY_GENERAL, HARD_MODE_KEY, HARD_MODE_DEFAULT, "This does nothing!").getBoolean(false);

		// Mod Tweeks
		CLAYDUST_TO_CLAY = config.get(CATEGORY_TWEEKS, CLAYDUST_TO_CLAY_KEY, CLAYDUST_TO_CLAY_DEFAULT).getBoolean(false);
		CLAYOUTPUT = config.get(CATEGORY_TWEEKS, CLAYDUST_OUTPUT_KEY, CLAYDUST_TO_CLAY_DEFAULT_OUTPUT, "Default Clay Output = 8").getInt();

		// Items

		// Blocks

		config.save();
	}
}

