package lib;

import blocks.blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import rgmf.RGMF;

/**
 * Created by Komoden on 05/03/14.
 */
public class Recipes {

	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(blocks.advDropper, 1),
			new Object[]
					{
							"ILI",
							"RRR",
							"DDD",
							'I', Items.iron_ingot,
							'L', Blocks.lever,
							'R', Items.redstone,
							'D', Blocks.dropper
					});

		GameRegistry.addRecipe(new ItemStack(blocks.advHopper, 1),
				new Object[]
						{
								"PCP",
								"RTR",
								"RHR",
								'P', Blocks.unpowered_comparator,
								'C', Blocks.chest,
								'R', Items.redstone,
								'T', Blocks.trapdoor,
								'H', Blocks.hopper,
						});

        /* Temp recipe for glowstone, as glowstone is an finite item. */
        ItemStack yellowDye = new ItemStack(Items.dye, 1, 11);
        ItemStack redstoneDust = new ItemStack(Items.redstone);
        ItemStack glowstoneDust = new ItemStack(Items.glowstone_dust);
        GameRegistry.addShapelessRecipe(glowstoneDust, yellowDye, redstoneDust);

		if (RGMF.IsIC2Loaded) {
			if (ConfigHandler.CLAYDUST_TO_CLAY) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.clay_ball, ConfigHandler.CLAYOUTPUT),
						new Object[]
								{
										"DD",
										"DD",
										'D', "dustClay"
								}));
			}
		}
	}

	public static void addColoredStone(ItemStack coloredStone, ItemStack colorDye)
	{
		GameRegistry.addRecipe(coloredStone,
				new Object[]
						{
								"SSS",
								"SDS",
								"SSS",
								'S', Blocks.stone,
								'D', colorDye
						});
	}

	public static void addColoredBricks(ItemStack coloredBricks, ItemStack colorDye)
	{
		GameRegistry.addRecipe(coloredBricks,
				new Object[]
						{
								"BBB",
								"BDB",
								"BBB",
								'B', Blocks.brick_block,
								'D', colorDye
						});
	}
}
