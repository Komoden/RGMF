package blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lib.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
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

    //@Override
//    public int getBlockTextureFromSideAndMetadata (int side, int metadata) {
//        return 16 + metadata;
//    }

//    @Override
//    public String getTextureFile () {
    //    return CommonProxy.ColoredStone_PNG;
   // }

    @Override
    public int damageDropped (int metadata) {
        return metadata;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
        for (int ix = 0; ix < 16; ix++) {
            subItems.add(new ItemStack(this, 1, ix));
        }
    }

}
