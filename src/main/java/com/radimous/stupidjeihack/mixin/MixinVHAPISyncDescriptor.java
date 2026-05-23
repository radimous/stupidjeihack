package com.radimous.stupidjeihack.mixin;

import com.radimous.stupidjeihack.StupidJEIHack;
import net.minecraftforge.network.NetworkEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.iwolfking.vhapi.networking.VHAPISyncDescriptor;

@Mixin(value = VHAPISyncDescriptor.class, remap = false)
public class MixinVHAPISyncDescriptor {
    @Inject(method = "handle", at = @At("HEAD"), cancellable = true)
    private void disableVHAPISync(NetworkEvent.Context context, CallbackInfo ci){
        if (StupidJEIHack.disableVHAPITemplateSync) {
            StupidJEIHack.LOGGER.info("VHAPI template sync disabled, skipping handle");
            context.setPacketHandled(true);
            StupidJEIHack.disableVHAPITemplateSync = false;
            ci.cancel();
        }
    }
}
