package blocks;

import blocks.tileEntities.TileEntityAdvHopper;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import rgmf.RGMF;
import lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * Created by beringtom on 04-03-14.
 */
public class AdvancedHopper extends BlockContainer {

    public AdvancedHopper(int id) {
        super(id, Material.iron);
        setCreativeTab(RGMF.rgmfTab);
        setHardness(2f);
        setStepSound(Block.soundMetalFootstep);
        setUnlocalizedName(BlockInfo.ADVHOPPER_UNLOCALIZED_NAME);
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


    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta) {
        if (side == 0){
            return botIcon;
        }else if(side == 1) {
            return topIcon;
        }else{
            return sideIcon;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityAdvHopper();
    }

//    @Override
//    public int getRenderType()
//    {
//        return 22;
//    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
 			FMLNetworkHandler.openGui(player, RGMF.instance, 1, world, x, y, z);
        }
        return true;
    }

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int id, int meta)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);
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
		super.breakBlock(world, x, y, z, id, meta);
	}
}
