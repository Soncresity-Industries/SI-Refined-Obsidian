package dev.soncresityindustries.refinedobsidian.item;

import dev.soncresityindustries.refinedobsidian.RefinedObsidian;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item OBSIDIAN_DUST = register("obsidian_dust", Item::new, new Item.Settings());

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        Item item = itemFactory.apply(settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RefinedObsidian.MOD_ID, name))));
        Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RefinedObsidian.MOD_ID, name)), item);
        return item;
    }

    public static void registerModItems() {
        RefinedObsidian.LOGGER.info("Registering Items for " + RefinedObsidian.MOD_ID);
    }
}
