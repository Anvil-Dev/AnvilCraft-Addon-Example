package dev.anvilcraft.addon.forge;

import dev.anvilcraft.addon.ExampleMod;
import net.minecraftforge.fml.common.Mod;

@Mod(ExampleMod.MOD_ID)
public class ExampleModForge {
    public ExampleModForge() {
        ExampleMod.init();
    }
}