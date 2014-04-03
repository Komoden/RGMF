package blocks;

import blocks.tileEntities.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import lib.Recipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by beringtom on 04-03-14.
 */
public class blocks {

	public static Block advDropper;
	public static Block advHopper;
    public static Block colStone;

	public static void init() {
		advDropper = new AdvancedDropper(BlockInfo.ADVDROPPER_ID);
		advHopper = new AdvancedHopper(BlockInfo.ADVHOPPER_ID);
		colStone = new ColoredStone(BlockInfo.COLOREDSTONE_ID);


		GameRegistry.registerBlock(advDropper, BlockInfo.ADVDROPPER_KEY);
		GameRegistry.registerBlock(advHopper, BlockInfo.ADVHOPPER_KEY);
		GameRegistry.registerBlock(colStone, BlockInfo.COLOREDSTONE_KEY);
	}

	public static void addNames() {
		LanguageRegistry.addName(advDropper, BlockInfo.ADVDROPPER_NAME);
		LanguageRegistry.addName(advHopper, BlockInfo.ADVHOPPER_NAME);

		for (int ix = 0; ix < 16; ix++) {
			ItemStack colordye  = new ItemStack(Item.dyePowder, 1, ix);
			ItemStack colStoneStack = new ItemStack(colStone, 1, ix);
			Recipes.addColoredStone(colStoneStack, colordye);
			LanguageRegistry.addName(colStoneStack, BlockInfo.COLOREDSTONE_NAMES[colStoneStack.getItemDamage()]);
		}
	}

	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityAdvDropper.class, TileEntityInfo.AVD_DROPPER_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityAdvHopper.class, TileEntityInfo.AVD_HOPPER_TE_KEY);
	}
}
