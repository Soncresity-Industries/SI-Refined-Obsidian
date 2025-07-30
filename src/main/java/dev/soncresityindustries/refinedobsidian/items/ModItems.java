package dev.soncresityindustries.refinedobsidian.items;

import dev.soncresityindustries.refinedobsidian.RefinedObsidian;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RefinedObsidian.MODID);

    public static final RegistryObject<Item> OBSIDIAN_DUST = ITEMS.register("obsidian_dust", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
