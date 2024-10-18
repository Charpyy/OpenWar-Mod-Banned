package com.openwar.charpy.Proxies;

import com.openwar.charpy.Handler.EventBanned;
import com.openwar.charpy.Utils.ItemLoader;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import java.util.List;

public class CommonProxy {

    public void registerEventHandlers() {
        ItemLoader il = new ItemLoader();
        List<ItemStack> items = il.readItemsFromCSV();
        List<String> admin= il.readAdminsFromCSV();
        MinecraftForge.EVENT_BUS.register(new EventBanned(items, admin));
    }
}