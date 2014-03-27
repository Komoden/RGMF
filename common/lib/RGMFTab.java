package lib;

import blocks.blocks;
import net.minecraft.creativetab.CreativeTabs;

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
	public int getTabIconItemIndex()
	{
		return blocks.advDropper.blockID;
	}
}
