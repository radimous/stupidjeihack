package com.radimous.stupidjeihack;

import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onClientChatReceived(ClientChatReceivedEvent event) {
        if (event.getMessage() instanceof TextComponent tc && "Saving your data before transfer...".equals(tc.getText())) {
            StupidJEIHack.LOGGER.info("DETECTED SERVER TRANSFER");
            StupidJEIHack.disableJEIRefresh = true;
            StupidJEIHack.disableVHAPITemplateSync = true;
            StupidJEIHack.disableCraftTweaker = true;
        }
    }
}
