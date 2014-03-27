package blocks;

import blocks.tileEntities.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;

/**
 * Created by beringtom on 04-03-14.
 */
public class blocks {

	public static Block advDropper;
	public static Block advHopper;

	public static void init() {
		advDropper = new AdvancedDropper(BlockInfo.ADVDROPPER_ID);
		advHopper = new AdvancedHopper(BlockInfo.ADVHOPPER_ID);
		GameRegistry.registerBlock(advDropper, BlockInfo.ADVDROPPER_KEY);
		GameRegistry.registerBlock(advHopper, BlockInfo.ADVHOPPER_KEY);
	}

	public static void addNames() {
		LanguageRegistry.addName(advDropper, BlockInfo.ADVDROPPER_NAME);
		LanguageRegistry.addName(advHopper, BlockInfo.ADVHOPPER_NAME);
	}

	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityAdvDropper.class, TileEntityInfo.AVD_DROPPER_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityAdvHopper.class, TileEntityInfo.AVD_HOPPER_TE_KEY);
	}
}
