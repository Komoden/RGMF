package blocks.client;

import blocks.client.container.ContainerAdvDropper;
import blocks.client.container.ContainerAdvHopper;
import blocks.client.gui.GuiAdvDropper;
import blocks.client.gui.GuiAdvHopper;
import blocks.tileEntities.TileEntityAdvDropper;
import blocks.tileEntities.TileEntityAdvHopper;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import rgmf.RGMF;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Komoden on 06/03/14.
 */
public class RGMFGuiHandler implements IGuiHandler
{
	public RGMFGuiHandler()
	{
		NetworkRegistry.instance().registerGuiHandler(RGMF.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		System.out.println(ID);
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		switch (ID)
		{
			case 0:
				if (entity != null && entity instanceof TileEntityAdvDropper)
					return new ContainerAdvDropper(player.inventory, (TileEntityAdvDropper)entity);
				else
					return null;
			case 1:
				if (entity != null && entity instanceof TileEntityAdvHopper)
					return new ContainerAdvHopper(player.inventory, (TileEntityAdvHopper)entity);
				else
					return null;
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		switch (ID)
		{
			case 0:
				if (entity != null && entity instanceof TileEntityAdvDropper)
					return new GuiAdvDropper(player.inventory, (TileEntityAdvDropper)entity);
				else
					return null;
			case 1:
				if (entity != null && entity instanceof TileEntityAdvHopper)
					return new GuiAdvHopper(player.inventory, (TileEntityAdvHopper)entity);
				else
					return null;
			default:
				return null;
		}
	}
}
