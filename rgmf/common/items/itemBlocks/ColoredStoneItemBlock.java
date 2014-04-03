package items.itemBlocks;

import blocks.BlockInfo;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by Komoden on 03/04/14.
 */
public class ColoredStoneItemBlock extends ItemBlock
{
	private final static String[] subNames = {
			"white", "orange",  "magenta", "lightBlue", "yellow", "lightGreen",
			"pink", "darkGrey", "lightGrey", "cyan", "purple", "blue", "brown",
			"green", "red", "black"
	};

	public ColoredStoneItemBlock(int id) {
		super(id);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return getUnlocalizedName() + "." + subNames[itemstack.getItemDamage()];
	}
}
