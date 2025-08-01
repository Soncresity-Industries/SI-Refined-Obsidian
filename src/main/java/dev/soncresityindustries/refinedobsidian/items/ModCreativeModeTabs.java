package dev.soncresityindustries.refinedobsidian.items;

import dev.soncresityindustries.refinedobsidian.RefinedObsidian;
import dev.soncresityindustries.refinedobsidian.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RefinedObsidian.MODID);

    public static final RegistryObject<CreativeModeTab> REFINED_OBSIDIAN_TAB = CREATIVE_MODE_TABS.register("refined_obsidian_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OBSIDIAN_DUST.get()))
            .title(Component.translatable("itemgroup.si_refined_obsidian"))
            .displayItems((pParameters, pOutput) -> {
                //Items
                pOutput.accept(ModItems.OBSIDIAN_DUST.get());

                //Blocks
                //Bricks
                pOutput.accept(ModBlocks.OBSIDIAN_BRICKS.get());
                pOutput.accept(ModBlocks.OBSIDIAN_BRICK_SLAB.get());
                pOutput.accept(ModBlocks.OBSIDIAN_BRICK_STAIRS.get());
                pOutput.accept(ModBlocks.OBSIDIAN_BRICK_WALL.get());
                pOutput.accept(ModBlocks.CRACKED_OBSIDIAN_BRICKS.get());
                //Tiles
                pOutput.accept(ModBlocks.OBSIDIAN_TILES.get());
                pOutput.accept(ModBlocks.OBSIDIAN_TILE_SLAB.get());
                pOutput.accept(ModBlocks.OBSIDIAN_TILE_STAIRS.get());
                pOutput.accept(ModBlocks.OBSIDIAN_TILE_WALL.get());
                pOutput.accept(ModBlocks.CRACKED_OBSIDIAN_TILES.get());
                //Polished
                pOutput.accept(ModBlocks.POLISHED_OBSIDIAN.get());
                pOutput.accept(ModBlocks.POLISHED_OBSIDIAN_SLAB.get());
                pOutput.accept(ModBlocks.POLISHED_OBSIDIAN_STAIRS.get());
                pOutput.accept(ModBlocks.POLISHED_OBSIDIAN_WALL.get());
                //Cobbled
                pOutput.accept(ModBlocks.COBBLED_OBSIDIAN.get());
                pOutput.accept(ModBlocks.COBBLED_OBSIDIAN_SLAB.get());
                pOutput.accept(ModBlocks.COBBLED_OBSIDIAN_STAIRS.get());
                pOutput.accept(ModBlocks.COBBLED_OBSIDIAN_WALL.get());
                //Chiseled
                pOutput.accept(ModBlocks.CHISELED_OBSIDIAN.get());
            })
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
