package dev.soncresityindustries.refinedobsidian.item;

import dev.soncresityindustries.refinedobsidian.RefinedObsidian;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item OBSIDIAN_DUST = registerItem("obsidian_dust", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(RefinedObsidian.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RefinedObsidian.LOGGER.info("Registering Items for " + RefinedObsidian.MOD_ID);
    }
}