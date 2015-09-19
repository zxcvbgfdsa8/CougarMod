package com.johansenwest.cougarmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by jamey on 9/16/2015.
 */
public class ItemPigskin extends net.minecraft.item.Item {
    private final String name = "pigskinItem";
    public ItemPigskin() {
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(CougarMod.MODID + "_" + name);
        setCreativeTab(CreativeTabs.tabMaterials);
    }
    public String getName() {
        return name;
    }
}
