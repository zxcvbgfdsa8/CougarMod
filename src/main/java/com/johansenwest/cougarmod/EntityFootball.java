package com.johansenwest.cougarmod;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by jamey on 9/20/2015.
 */
public class EntityFootball extends EntityThrowable {
    public EntityFootball(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    public EntityFootball(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
    public EntityFootball(World par1World)
    {
        super(par1World);
    }
    @Override
    protected void onImpact(MovingObjectPosition movingObjectPos)
    {
        if (movingObjectPos.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
        {
            Block block = this.worldObj.getBlockState(movingObjectPos.getBlockPos()).getBlock();

            if(block == Blocks.tallgrass || block == Blocks.vine || block == Blocks.red_flower || block == Blocks.yellow_flower || block == Blocks.brown_mushroom_block || block == Blocks.red_mushroom || block == Blocks.reeds || block == Blocks.double_plant || block == Blocks.deadbush || block == Blocks.brown_mushroom_block || block == Blocks.wheat || block == Blocks.waterlily || block == Blocks.carrots || block == Blocks.potatoes || block == Blocks.snow_layer)
            {
                BlockPos blockPos = movingObjectPos.getBlockPos();
                IBlockState blockstate = this.worldObj.getBlockState(blockPos);
                TileEntity tile_entity = this.worldObj.getTileEntity(blockPos);

                if(this.getThrower() instanceof EntityPlayer)
                {
                    EntityPlayer player = (EntityPlayer)this.getThrower();
                    this.worldObj.destroyBlock(blockPos, false);
                    block.harvestBlock(this.worldObj, player, blockPos, blockstate, tile_entity); //allows blocks to drop the items they would normally drop if harvested with a tool
                }
                else if(this.getThrower() instanceof EntityTameable)
                {
                    EntityTameable tameableEntity = (EntityTameable)this.getThrower();
                    if(tameableEntity != null && tameableEntity.isTamed())
                    {
                        EntityPlayer player = (EntityPlayer)tameableEntity.getOwner();

                    }
                }
            }
            else
            {
                this.setDead();
            }
        }
    }
}
