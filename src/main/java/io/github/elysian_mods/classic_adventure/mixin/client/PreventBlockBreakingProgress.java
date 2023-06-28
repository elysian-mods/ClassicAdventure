package io.github.elysian_mods.classic_adventure.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ClientPlayerInteractionManager.class)
public abstract class PreventBlockBreakingProgress {
    @Final
    @Shadow
    private MinecraftClient client;

    @ModifyExpressionValue(method = "updateBlockBreakingProgress", at = @At(value = "INVOKE", target = "Lnet" +
            "/minecraft/block/BlockState;calcBlockBreakingDelta(Lnet/minecraft/entity/player/PlayerEntity;" +
            "Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)F"))
    public float setToZeroInAdventureMode(float original, BlockPos pos, Direction direction) {
        if (this.client.getNetworkHandler().getPlayerListEntry(this.client.player.getUuid()).getGameMode() == GameMode.ADVENTURE && !this.client.player.getMainHandStack().isSuitableFor(this.client.world.getBlockState(pos))) {
            return 0.0f;
        } else {
            return original;
        }
    }
}
