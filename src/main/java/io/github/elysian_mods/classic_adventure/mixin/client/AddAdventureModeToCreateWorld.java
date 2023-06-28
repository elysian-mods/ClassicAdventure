package io.github.elysian_mods.classic_adventure.mixin.client;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.client.gui.screen.world.WorldCreator;
import net.minecraft.client.gui.tab.GridScreenTab;
import net.minecraft.text.Text;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(targets = "net.minecraft.client.gui.screen.world.CreateWorldScreen$GameTab")
public abstract class AddAdventureModeToCreateWorld extends GridScreenTab {
    public AddAdventureModeToCreateWorld(Text title) {
        super(title);
    }

    @ModifyArg(method = "<init>", at = @At(value =
            "INVOKE", target = "Lnet/minecraft/client/gui/widget/CyclingButtonWidget$Builder;values" +
            "([Ljava/lang/Object;)Lnet/minecraft/client/gui/widget/CyclingButtonWidget$Builder;", ordinal = 0))
    public Object[] injectAdventureMode(Object[] original) {
        return ArrayUtils.insert(0, original, ClassTinkerers.getEnum(WorldCreator.Mode.class, "ADVENTURE"));
    }

}
