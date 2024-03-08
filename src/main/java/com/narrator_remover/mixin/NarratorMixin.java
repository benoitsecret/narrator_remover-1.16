package com.narrator_remover.mixin;

import net.minecraft.client.Keyboard;
import net.minecraft.client.gui.screen.options.ChatOptionsScreen;
import net.minecraft.client.options.CyclingOption;
import net.minecraft.client.options.GameOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Keyboard.class)
abstract class NarratorMixin {


    @Redirect(method = "onKey",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/options/CyclingOption;cycle(Lnet/minecraft/client/options/GameOptions;I)V"))
    public void cycle(CyclingOption instance, GameOptions options, int amount) {

    }

    @Redirect(method="onKey",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screen/options/ChatOptionsScreen;setNarratorMessage()V"))
    public void setNarratorMessage(ChatOptionsScreen instance) {

    }

}