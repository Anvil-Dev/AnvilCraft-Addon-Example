package dev.anvilcraft.addon;

import dev.anvilcraft.addon.data.ExampleModDatagen;
import dev.anvilcraft.addon.init.ModBlocks;
import dev.anvilcraft.addon.init.ModCreativeModeTab;
import dev.anvilcraft.addon.init.ModItems;
import dev.dubhe.anvilcraft.api.registry.AnvilCraftRegistrate;

public class ExampleMod {
    public static final String MOD_ID = "anvilcraft_addon_example";

    public static final AnvilCraftRegistrate REGISTRATE = AnvilCraftRegistrate.create(MOD_ID);

    public static void init() {
        // common init
        ModItems.register();
        ModBlocks.register();
        ModCreativeModeTab.register();

        // datagen init
        ExampleModDatagen.init();

        // fabric exclusive, squeeze this in here to register before stuff is used
        REGISTRATE.registerRegistrate();
    }
}
