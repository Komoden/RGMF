package lib;

import blocks.blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
}
