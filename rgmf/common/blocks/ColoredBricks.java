package blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import rgmf.RGMF;

import java.util.List;

/**
 * Created by beringtom on 29-03-14.
 */

public class ColoredBricks extends Block {

	public ColoredBricks(int id) {
		super(id, Material.rock);
		setCreativeTab(RGMF.rgmfTab);
		setHardness(2f);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(BlockInfo.COLOREDBRICKS_UNLOCALIZED_NAME);
	}

	@SideOnly(Side.CLIENT)
	private Icon white, orange, magenta, lightBlue, yellow, lightGreen, pink, darkGrey, lightGrey, cyan, purple, blue, brown, green, red, black;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		white = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"white");
		orange = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"orange");
		magenta = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"magenta");
		lightBlue = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"lightBlue");
		yellow = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"yellow");
		lightGreen = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"lightGreen");
		pink = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"pink");
		darkGrey = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"darkGrey");
		lightGrey = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"lightGrey");
		cyan = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"cyan");
		purple = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"purple");
		blue = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"blue");
		brown = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"brown");
		green = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"green");
		red = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"red");
		black = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.COLOREDBRICKS_TEXTURE+"black");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		switch(meta)
		{
			case 0:
				return black;
			case 1:
				return red;
			case 2:
				return green;
			case 3:
				return brown;
			case 4:
				return blue;
			case 5:
				return purple;
			case 6:
				return cyan;
			case 7:
				return lightGrey;
			case 8:
				return darkGrey;
			case 9:
				return pink;
			case 10:
				return lightGreen;
			case 11:
				return yellow;
			case 12:
				return lightBlue;
			case 13:
				return magenta;
			case 14:
				return orange;
			case 15:
				return white;
			default:
				return null;
		}
	}

	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems)
	{
		for (int ix = 0; ix < 16; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
	}
}
