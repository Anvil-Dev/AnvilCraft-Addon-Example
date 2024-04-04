package dev.anvilcraft.addon.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import dev.dubhe.anvilcraft.api.registry.AnvilCraftRegistrate;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import javax.annotation.Nonnull;

import static dev.anvilcraft.addon.ExampleMod.REGISTRATE;


public class ModCreativeModeTab {
    public static final RegistryEntry<CreativeModeTab> EXAMPLE_TAB = REGISTRATE
            .defaultCreativeTab("example_tab", builder -> builder
                    .displayItems(new RegistrateDisplayItemsGenerator("example_tab", REGISTRATE))
                    .icon(ModItems.EXAMPLE_ITEM::asStack)
                    .build()
            ).register();

    public static void register() {

    }
    public static class RegistrateDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {

        public final String name;
        public final AnvilCraftRegistrate registrate;

        public RegistrateDisplayItemsGenerator(String name, AnvilCraftRegistrate registrate) {
            this.name = name;
            this.registrate = registrate;
        }

        @Override
        public void accept(@Nonnull CreativeModeTab.ItemDisplayParameters itemDisplayParameters, @Nonnull CreativeModeTab.Output output) {
            var tab = registrate.get(name, Registries.CREATIVE_MODE_TAB);
            for (var entry : registrate.getAll(Registries.BLOCK)) {
                if (!registrate.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get().asItem();
                if (item == Items.AIR)
                    continue;
                else {
                    output.accept(item);
                }
            }
            for (var entry : registrate.getAll(Registries.ITEM)) {
                if (!registrate.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get();
                if (item instanceof BlockItem)
                    continue;
                else {
                    output.accept(item);
                }
            }
        }
    }
}
