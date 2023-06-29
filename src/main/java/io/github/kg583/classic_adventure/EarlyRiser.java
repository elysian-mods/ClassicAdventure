package io.github.kg583.classic_adventure;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.world.GameMode;

public class EarlyRiser implements Runnable {
    @Override
    public void run() {
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();

        String worldCreatorMode = remapper.mapClassName("intermediary", "net.minecraft.class_8100$class_4539");
        String gameMode = remapper.mapClassName("intermediary", "net.minecraft.class_1934");
        ClassTinkerers.enumBuilder(worldCreatorMode, "Ljava/lang/String;", "L" + gameMode + ";").addEnum("ADVENTURE",
                () -> new Object[] {"adventure", GameMode.ADVENTURE}).build();
    }
}
