package com.radimous.stupidjeihack.mixin;

import com.radimous.stupidjeihack.StupidJEIHack;
import mezz.jei.forge.startup.ClientLifecycleHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ClientLifecycleHandler.class, remap = false)
public class MixinClientLifecycleHandler {
    @Inject(method = "startJei", at = @At("HEAD"), cancellable = true)
    private void disableJEIStart(CallbackInfo ci){
        if (StupidJEIHack.disableJEIRefresh) {
            StupidJEIHack.LOGGER.info("JEI refresh disabled, skipping startJei");
            ci.cancel();
        }
        StupidJEIHack.disableJEIRefresh = false;
    }

    @Inject(method = "stopJei", at = @At("HEAD"), cancellable = true)
    private void disableJEIStop(CallbackInfo ci){
        if (StupidJEIHack.disableJEIRefresh) {
            StupidJEIHack.LOGGER.info("JEI refresh disabled, skipping stopJei");
            ci.cancel();
        }
    }
}
