package blocks;

import blocks.tileEntities.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import items.itemBlocks.ColoredStoneItemBlock;
import items.itemBlocks.ColoredBricksItemBlock;
import lib.Recipes;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by beringtom on 04-03-14.
 */
public class blocks {

	public static Block advDropper;
	public static Block advHopper;
    public static Block colStone;
	public static Block colBricks;

	public static void init() {
		advDropper = new AdvancedDropper();
		advHopper = new AdvancedHopper();
		colStone = new ColoredStone();
		colBricks = new ColoredBricks();

		GameRegistry.registerBlock(advDropper, BlockInfo.ADVDROPPER_KEY);
		GameRegistry.registerBlock(advHopper, BlockInfo.ADVHOPPER_KEY);
		GameRegistry.registerBlock(colStone, ColoredStoneItemBlock.class, BlockInfo.COLOREDSTONE_KEY);
		GameRegistry.registerBlock(colBricks, ColoredBricksItemBlock.class, BlockInfo.COLOREDBRICKS_KEY);
	}

	public static void addNames() {
		LanguageRegistry.addName(advDropper, BlockInfo.ADVDROPPER_NAME);
		LanguageRegistry.addName(advHopper, BlockInfo.ADVHOPPER_NAME);

		for (int ix = 0; ix < 16; ix++) {
			ItemStack colordye  = new ItemStack(Items.dye, 1, ix);
			//coloredStone
			ItemStack colStoneStack = new ItemStack(colStone, 8, ix);
			Recipes.addColoredStone(colStoneStack, colordye);
			LanguageRegistry.addName(colStoneStack, BlockInfo.COLOREDSTONE_NAMES[colStoneStack.getItemDamage()]);
			//ColoredBricks
			ItemStack colBricksStack = new ItemStack(colBricks, 8, ix);
			Recipes.addColoredBricks(colBricksStack, colordye);
			LanguageRegistry.addName(colBricksStack, BlockInfo.COLOREDBRICKS_NAMES[colBricksStack.getItemDamage()]);
		}
	}

	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityAdvDropper.class, TileEntityInfo.AVD_DROPPER_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityAdvHopper.class, TileEntityInfo.AVD_HOPPER_TE_KEY);
	}
}
