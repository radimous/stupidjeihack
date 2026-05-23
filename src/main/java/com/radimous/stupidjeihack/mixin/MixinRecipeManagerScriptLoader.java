package com.radimous.stupidjeihack.mixin;

import com.blamejared.crafttweaker.impl.script.RecipeManagerScriptLoader;
import com.radimous.stupidjeihack.StupidJEIHack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RecipeManagerScriptLoader.class, remap = false)
public class MixinRecipeManagerScriptLoader {
    @Inject(method = "updateState", at = @At("HEAD"), cancellable = true)
    private static void disableCraftTweaker(CallbackInfo ci){
        if (StupidJEIHack.disableCraftTweaker) {
            StupidJEIHack.LOGGER.info("CraftTweaker recipe sync disabled, skipping updateState");
            StupidJEIHack.disableCraftTweaker = false;
            ci.cancel();
        }
    }
}
