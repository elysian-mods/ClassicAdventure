package io.github.kg583.classic_adventure.mixin.common;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ServerPlayerEntity.class)
public abstract class OverrideBlockBreakingSpeed extends PlayerEntity {
    @Shadow @Final public ServerPlayerInteractionManager interactionManager;

    public OverrideBlockBreakingSpeed(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Override
    public float getBlockBreakingSpeed(BlockState block) {
        float f = super.getBlockBreakingSpeed(block);

        if (this.interactionManager.getGameMode() == GameMode.ADVENTURE && !this.getMainHandStack().isSuitableFor(block)) {
            f *= 0.0f;
        }

        return f;
    }
}
