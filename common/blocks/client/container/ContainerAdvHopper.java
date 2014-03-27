package blocks.client.container;

import blocks.tileEntities.TileEntityAdvHopper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Komoden on 06/03/14.
 */
public class ContainerAdvHopper extends Container
{
	private TileEntityAdvHopper entityAdvHopper;

	public ContainerAdvHopper(InventoryPlayer inventoryPlayer, TileEntityAdvHopper entityAdvDropper)
	{
		this.entityAdvHopper = entityAdvDropper;

		for (int x = 0; x < 9; x++)
		{
			addSlotToContainer(new Slot(inventoryPlayer, x, 8 + 18 * x, 142));
		}

		for (int y=0; y<3; y++)
		{
			for (int x=0; x<9; x++)
			{
				addSlotToContainer(new Slot(inventoryPlayer, x+y*9+9, 8+18*x, 84+y*18));
			}
		}

		for (int y=0; y<3; y++)
		{
			for (int x=0; x<3; x++)
			{
				addSlotToContainer(new Slot(entityAdvDropper, x+y*3, 62+18*x, 17+y*18));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return this.entityAdvHopper.isUseableByPlayer(entityplayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i)
	{
		Slot slot = getSlot(i);
		if (slot != null && slot.getHasStack())
		{
			ItemStack stack = slot.getStack();
			ItemStack result = slot.getStack();

			if (i >= 36)
			{
				if (!mergeItemStack(stack, 0, 36, false))
					return null;
			}
			else if (!mergeItemStack(stack, 36, 36 + entityAdvHopper.getSizeInventory(), false))
			{
				return null;
			}

			if (stack.stackSize == 0)
				slot.putStack(null);
			else
				slot.onSlotChanged();

			slot.onPickupFromSlot(player, stack);

			return result;
		}
		return null;
	}
}
