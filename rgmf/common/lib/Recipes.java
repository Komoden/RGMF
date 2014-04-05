package lib;

import blocks.blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
						    'I', Item.ingotIron,
						    'L', Block.lever,
						    'R', Item.redstone,
						    'D', Block.dropper
				    });


	    if (RGMF.IsIC2Loaded) {
		    if (ConfigHandler.CLAYDUST_TO_CLAY) {
			    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.clay, ConfigHandler.CLAYOUTPUT),
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
                                'S', Block.stone,
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
								'B', Block.brick,
								'D', colorDye
						});
	}
}
