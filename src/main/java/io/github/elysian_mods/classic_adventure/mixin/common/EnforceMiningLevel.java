package io.github.elysian_mods.classic_adventure.mixin.common;

import net.fabricmc.fabric.api.mininglevel.v1.MiningLevelManager;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class EnforceMiningLevel {
    @Inject(
            method = "isSuitableFor",
            at = @At(value = "RETURN"),
            cancellable = true)
    private void enforceMiningLevel(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(MiningLevelManager.getRequiredMiningLevel(state) < 0);
    }
}
