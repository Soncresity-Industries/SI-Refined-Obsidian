package dev.soncresityindustries.refinedobsidian.item;

import dev.soncresityindustries.refinedobsidian.RefinedObsidian;
import dev.soncresityindustries.refinedobsidian.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    // This creates the Creative mode tab
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RefinedObsidian.MODID);

    // And here we add items to it and customize it
    public static final Supplier<CreativeModeTab> REFINED_OBSIDIAN_TAB = CREATIVE_MODE_TABS.register("refined_obsidian_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.OBSIDIAN_DUST.get()))
            .title(Component.translatable("itemgroup.si_refined_obsidian"))
            .displayItems((params, output) -> {
                //Items
                output.accept(ModItems.OBSIDIAN_DUST.get());
                //Blocks
                //Bricks
                output.accept(ModBlocks.OBSIDIAN_BRICKS.get());
                output.accept(ModBlocks.OBSIDIAN_BRICK_SLAB.get());
                output.accept(ModBlocks.OBSIDIAN_BRICK_STAIRS.get());
                output.accept(ModBlocks.OBSIDIAN_BRICK_WALL.get());
                output.accept(ModBlocks.CRACKED_OBSIDIAN_BRICKS.get());
                //Tiles
                output.accept(ModBlocks.OBSIDIAN_TILES.get());
                output.accept(ModBlocks.OBSIDIAN_TILE_SLAB.get());
                output.accept(ModBlocks.OBSIDIAN_TILE_STAIRS.get());
                output.accept(ModBlocks.OBSIDIAN_TILE_WALL.get());
                output.accept(ModBlocks.CRACKED_OBSIDIAN_TILES.get());
                //Polished
                output.accept(ModBlocks.POLISHED_OBSIDIAN.get());
                output.accept(ModBlocks.POLISHED_OBSIDIAN_SLAB.get());
                output.accept(ModBlocks.POLISHED_OBSIDIAN_STAIRS.get());
                output.accept(ModBlocks.POLISHED_OBSIDIAN_WALL.get());
                //Cobbled
                output.accept(ModBlocks.COBBLED_OBSIDIAN.get());
                output.accept(ModBlocks.COBBLED_OBSIDIAN_SLAB.get());
                output.accept(ModBlocks.COBBLED_OBSIDIAN_STAIRS.get());
                output.accept(ModBlocks.COBBLED_OBSIDIAN_WALL.get());
                //Chiseled
                output.accept(ModBlocks.CHISELED_OBSIDIAN.get());
            })
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
