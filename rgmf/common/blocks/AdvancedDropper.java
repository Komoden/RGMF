package blocks;

import blocks.tileEntities.TileEntityAdvDropper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import rgmf.RGMF;
import lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by beringtom on 04-03-14.
 */
public class AdvancedDropper extends BlockContainer
{

	public AdvancedDropper() {
		super(Material.iron);
		setCreativeTab(RGMF.rgmfTab);
		setHardness(2f);
		setStepSound(Block.soundTypeMetal);
		setBlockName(BlockInfo.ADVDROPPER_UNLOCALIZED_NAME);
	}

	@SideOnly(Side.CLIENT)
	private IIcon topIcon;
	@SideOnly(Side.CLIENT)
	private IIcon sideOnIcon;
	@SideOnly(Side.CLIENT)
	private IIcon sideIcon;
	@SideOnly(Side.CLIENT)
	private IIcon botIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		topIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.ADVDROPPER_TOP);
		sideOnIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.ADVDROPPER_SIDE_ON);
		sideIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.ADVDROPPER_SIDE);
		botIcon = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.ADVDROPPER_BOTTOM);
	}


	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		if (side == 0){
			return botIcon;
		}else if(side == 1) {
			return topIcon;
		}else{
			if (isDisabled(meta))
				return sideIcon;
			else
				return sideOnIcon;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityAdvDropper();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			player.openGui(RGMF.instance, 0, world, x, y, z);
		}
		return true;
	}

	private boolean isDisabled(int meta)
	{
		return meta == 1;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if (!world.isRemote)
		{
			if (world.isBlockIndirectlyGettingPowered(x, y, z))
				world.setBlockMetadataWithNotify(x, y, z, 1, 3);
			else
				world.setBlockMetadataWithNotify(x, y, z, 0, 3);
		}
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof IInventory)
		{
			IInventory inventory = (IInventory)te;
			for (int i = 0; i<inventory.getSizeInventory(); i++)
			{
				ItemStack itemStack = inventory.getStackInSlotOnClosing(i);
				if (itemStack != null)
				{
					float spawnX = x+world.rand.nextFloat();
					float spawnY = y+world.rand.nextFloat();
					float spawnZ = z+world.rand.nextFloat();
					EntityItem droppedItem = new EntityItem(world, spawnX, spawnY, spawnZ, itemStack);

					float mult = 0.00F;
					droppedItem.motionX = -0.5F+world.rand.nextFloat() * mult;
					droppedItem.motionY = 4F+world.rand.nextFloat() * mult;
					droppedItem.motionZ = -0.5F+world.rand.nextFloat() * mult;

					world.spawnEntityInWorld(droppedItem);
				}
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}
}
