package com.johansenwest.cougarmod;

/**
 * Created by jamey on 9/13/2015.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = CougarMod.MODID, version = CougarMod.VERSION)
public class CougarMod
{
    public static final String MODID = "cougarmod";
    public static final String VERSION = "1.0";

    public static Item pigskinItem;
    public static Item footballItem;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        footballItem = new ItemFootball();
        pigskinItem = new ItemPigskin();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        if(event.getSide() == Side.CLIENT)
        {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            renderItem.getItemModelMesher().register(pigskinItem, 0, new ModelResourceLocation(CougarMod.MODID + ":" + ((ItemPigskin) pigskinItem).getName(), "inventory"));
            renderItem.getItemModelMesher().register(footballItem, 0, new ModelResourceLocation(CougarMod.MODID + ":" + ((ItemFootball) footballItem).getName(), "inventory"));
        }
    }
}