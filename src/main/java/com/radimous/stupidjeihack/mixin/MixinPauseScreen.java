package com.radimous.stupidjeihack.mixin;

import com.radimous.stupidjeihack.StupidJEIHack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PauseScreen.class)
public class MixinPauseScreen extends Screen {
    protected MixinPauseScreen(Component pTitle) {
        super(pTitle);
    }

    @Inject(method = "createPauseMenu", at = @At("TAIL"))
    private void addButton(CallbackInfo ci){
        this.addRenderableWidget(new Button(this.width - 20, this.height / 4 + 72 + -16, 20, 20,
            new TextComponent("JEI").withStyle(style -> style.withColor(StupidJEIHack.disableJEIRefresh ? ChatFormatting.RED.getColor() : ChatFormatting.GREEN.getColor())),
            (btn) -> StupidJEIHack.disableJEIRefresh = !StupidJEIHack.disableJEIRefresh));

        this.addRenderableWidget(new Button(this.width - 20, this.height / 4 + 72+20 + -16, 20, 20,
            new TextComponent("VHAPI").withStyle(style -> style.withColor(StupidJEIHack.disableVHAPITemplateSync ? ChatFormatting.RED.getColor() : ChatFormatting.GREEN.getColor())),
            (btn) -> StupidJEIHack.disableVHAPITemplateSync = !StupidJEIHack.disableVHAPITemplateSync));

        this.addRenderableWidget(new Button(this.width - 20, this.height / 4 + 72+20+20 + -16, 20, 20,
            new TextComponent("CT").withStyle(style -> style.withColor(StupidJEIHack.disableCraftTweaker ? ChatFormatting.RED.getColor() : ChatFormatting.GREEN.getColor())),
            (btn) -> StupidJEIHack.disableCraftTweaker = !StupidJEIHack.disableCraftTweaker));
    }
}
