package dev.soncresityindustries.refinedobsidian.item;

import dev.soncresityindustries.refinedobsidian.RefinedObsidian;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RefinedObsidian.MOD_ID);

    public static final DeferredItem<Item> OBSIDIAN_DUST = ITEMS.register("obsidian_dust",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
