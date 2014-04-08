package blocks.tileEntities;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

/**
 * Created by Komoden on 06/03/14.
 */
public class TileEntityAdvDropper extends TileEntity implements IInventory
{

	private ItemStack[] inventory;
	private Random advDropperRandom = new Random();
	private int dispenseCooldown = -1;

	public TileEntityAdvDropper()
	{
		this.inventory = new ItemStack[9];
	}

	@Override
	public int getSizeInventory()
	{
		return this.inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i)
	{
		return this.inventory[i];
	}

    @Override
	public ItemStack decrStackSize(int slot, int count)
	{
		ItemStack itemstack = getStackInSlot(slot);
		if (itemstack != null)
		{
			if (itemstack.stackSize <= count)
			{
				setInventorySlotContents(slot, null);
			}
			else
			{
				itemstack = itemstack.splitStack(count);
				onInventoryChanged();
			}
		}
		return itemstack;
    }

	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		ItemStack itemstack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return itemstack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack)
	{
		inventory[slot] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
			itemstack.stackSize = getInventoryStackLimit();
		onInventoryChanged();
	}

	@Override
	public String getInvName()
	{
		return "Advanced Dropper";
	}

	@Override
	public boolean isInvNameLocalized()
	{
		return true;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
	}

	@Override
	public void openChest()
	{

	}

	@Override
	public void closeChest()
	{

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return true;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		NBTTagList items = new NBTTagList();
		for (int i = 0; i < getSizeInventory(); i++)
		{
			ItemStack stack = getStackInSlot(i);
			if (stack != null)
			{
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte)i);
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		}
		compound.setTag("Items", items);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		NBTTagList items = compound.getTagList("Items");
		for (int i = 0; i<items.tagCount(); i++)
		{
			NBTTagCompound item = (NBTTagCompound)items.tagAt(i);
			int slot = item.getByte("Slot");
			if (slot >= 0 && slot < getSizeInventory())
			{
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}

	public int getRandomStackFromInventory()
	{
		int i = -1;
		int j = 1;

		for (int k = 0; k < this.inventory.length; ++k)
		{
			if (this.inventory[k] != null && this.advDropperRandom.nextInt(j++) == 0)
			{
				i = k;
			}
		}
		return i;
	}

	protected void dispense()
	{
		int l = this.getRandomStackFromInventory();
		if (l >= 0)
		{
			ItemStack itemstack1 = this.getStackInSlot(l);
			this.setInventorySlotContents(l, null);
			this.onInventoryChanged();

			double d0 = xCoord;
			double d1 = yCoord;
			double d2 = zCoord;
			EntityItem entityitem = new EntityItem(worldObj, d0+0.5D, d1-0.3D, d2+0.5D, itemstack1);
			entityitem.motionX = 0;
			entityitem.motionY = 0;
			entityitem.motionZ = 0;
			entityitem.motionX += worldObj.rand.nextGaussian() * 0.037499999832361937D * (double)1;
			entityitem.motionY += worldObj.rand.nextGaussian() * 0.037499999832361937D * (double)1;
			entityitem.motionZ += worldObj.rand.nextGaussian() * 0.037499999832361937D * (double)1;
			worldObj.spawnEntityInWorld(entityitem);
		}
	}

	private boolean isDisabled(int meta)
	{
		return meta == 1;
	}

	@Override
	public void updateEntity()
	{
//		System.out.println(!isDisabled(this.getBlockMetadata()));
		if (this.worldObj != null && !this.worldObj.isRemote && !isDisabled(this.getBlockMetadata()))
		{
			--this.dispenseCooldown;
			if (!this.isCoolingDown())
			{
				this.setDispenseCooldown(0);
				this.dispense();
				this.setDispenseCooldown(8);
			}
		}
	}

	public void setDispenseCooldown(int par1)
	{
		this.dispenseCooldown = par1;
	}

	public boolean isCoolingDown()
	{
		return this.dispenseCooldown > 0;
	}
}
