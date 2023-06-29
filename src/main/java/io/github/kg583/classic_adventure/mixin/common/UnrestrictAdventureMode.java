package io.github.kg583.classic_adventure.mixin.common;

import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameMode.class)
public abstract class UnrestrictAdventureMode {
    @Final
    @Shadow
    private int id;

    @Inject(method = "isBlockBreakingRestricted", at = @At(value = "HEAD"), cancellable = true)
    public void restrictSpectatorOnly(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(this.id == GameMode.SPECTATOR.getId());
    }
}
