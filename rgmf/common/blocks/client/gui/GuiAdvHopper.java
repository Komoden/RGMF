package blocks.client.gui;

import blocks.client.container.ContainerAdvHopper;
import blocks.tileEntities.TileEntityAdvHopper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lib.ModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Komoden on 06/03/14.
 */
@SideOnly(Side.CLIENT)
public class GuiAdvHopper extends GuiContainer
{
	public static final ResourceLocation texture = new ResourceLocation(ModInfo.TEXTURE_LOCATION, "textures/gui/advHopper.png");

	public GuiAdvHopper(InventoryPlayer inventoryPlayer, TileEntityAdvHopper entityAdvHopper)
	{
		super(new ContainerAdvHopper(inventoryPlayer, entityAdvHopper));
		xSize = 176;
		ySize = 165;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		fontRendererObj.drawString("Advanced Hopper", 8, 6, 0x404040);
	}

	@Override
	public void initGui()
	{
		super.initGui();
		buttonList.clear();
//		buttonList.add(new GuiButton(0, guiLeft+100, guiTop+14, 60, 20, "disable redstone"));
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.id == 0)
		{
			System.out.println("clicked");
		}
	}
}
