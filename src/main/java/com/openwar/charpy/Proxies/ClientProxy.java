package com.openwar.charpy.Proxies;

import com.openwar.charpy.Entity.*;
import com.openwar.charpy.Handler.*;
import com.openwar.charpy.Hud.HudWarzone;
import com.openwar.charpy.Utils.ItemLoader;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        MinecraftForge.EVENT_BUS.register(new PlayerInfo());
        RenderingRegistry.registerEntityRenderingHandler(EntityPlane.class, RenderPlane.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityParachute.class, manager -> new RenderParachute(manager, new Parachuuute()));
    }

    @Override
    public void registerEventHandlers() {
        super.registerEventHandlers();
        ItemLoader il = new ItemLoader();
        List<ItemStack> items = il.readItemsFromCSV();
        List<String> admin= il.readAdminsFromCSV();
        MinecraftForge.EVENT_BUS.register(new TooltipHandler(items));
        MinecraftForge.EVENT_BUS.register(new GuiEventHandler(items, admin));
        MinecraftForge.EVENT_BUS.register(FogHandler.class);
    }
}