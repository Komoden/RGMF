package blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lib.CommonProxy;
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
public class ColoredStone extends Block {

	public ColoredStone (int id) {
		super(id, Material.rock);
		setCreativeTab(RGMF.rgmfTab);
		setHardness(2f);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(BlockInfo.COLOREDSTONE_UNLOCALIZED_NAME);
	}

	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideIcon;
	@SideOnly(Side.CLIENT)
	private Icon botIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		topIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.ADVHOPPER_TOP);
		sideIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.ADVHOPPER_SIDE);
		botIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.ADVHOPPER_BOTTOM);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		if (side == 0){
			return botIcon;
		}else if(side == 1) {
			return topIcon;
		}else{
			return sideIcon;
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
