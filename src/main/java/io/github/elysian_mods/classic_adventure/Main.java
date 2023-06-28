package io.github.elysian_mods.classic_adventure;

import io.github.elysian_mods.classic_adventure.item.FlintAxe;
import io.github.elysian_mods.classic_adventure.item.FlintMaterial;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
    public static final Item FLINT_AXE = Registry.register(Registries.ITEM, new Identifier("classic_adventure", "flint_axe"),
            new FlintAxe(FlintMaterial.INSTANCE, 2.0f, -2.0f, new Item.Settings()));

    @Override
    public void onInitialize() {
    }
}
