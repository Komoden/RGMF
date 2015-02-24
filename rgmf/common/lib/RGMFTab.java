package lib;

import blocks.blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Komoden on 06/03/14.
 */
public class RGMFTab extends CreativeTabs
{

	public RGMFTab(int id, String name)
	{
		super(id, name);
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(blocks.advDropper);
	}
}
