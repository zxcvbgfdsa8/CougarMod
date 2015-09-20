package com.johansenwest.cougarmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by jamey on 9/20/2015.
 */
public class FootballClient extends FootballCommon
{
    @Override
    public void registerRenderThings()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityFootball.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), CougarMod.footballItem, Minecraft.getMinecraft().getRenderItem()));
    }

    @Override
    public void registerSounds() {}
}