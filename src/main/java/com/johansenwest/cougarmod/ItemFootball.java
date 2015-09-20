package com.johansenwest.cougarmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by jamey on 9/16/2015.
 */
public class ItemFootball extends Item {
    private final String name = "footballItem";
    public ItemFootball() {
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(CougarMod.MODID + "_" + name);
        setCreativeTab(CreativeTabs.tabCombat);
        this.setMaxStackSize(16);
    }
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par2World.isRemote)
        {
            par2World.spawnEntityInWorld(new EntityFootball(par2World, par3EntityPlayer));
            --par1ItemStack.stackSize;
        }
        return par1ItemStack;
    }
    public String getName() {
        return name;
    }
}
