package items.itemBlocks;

import blocks.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by Komoden on 03/04/14.
 */
public class ColoredBricksItemBlock extends ItemBlock
{
	public ColoredBricksItemBlock(Block block) {
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return getUnlocalizedName() + "." + BlockInfo.COLORED_SUBNAMES[itemstack.getItemDamage()];
	}
}
