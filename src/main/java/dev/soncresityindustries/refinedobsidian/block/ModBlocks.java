package dev.soncresityindustries.refinedobsidian.block;

import dev.soncresityindustries.refinedobsidian.RefinedObsidian;
import dev.soncresityindustries.refinedobsidian.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RefinedObsidian.MODID);

    //Bricks
    public static final RegistryObject<Block> OBSIDIAN_BRICKS = registerBlock("obsidian_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));
    public static final RegistryObject<Block> OBSIDIAN_BRICK_STAIRS = registerBlock("obsidian_brick_stairs",
            () -> new StairBlock(OBSIDIAN_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(OBSIDIAN_BRICKS.get())));
    public static final RegistryObject<Block> OBSIDIAN_BRICK_SLAB = registerBlock("obsidian_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(OBSIDIAN_BRICKS.get())));
    public static final RegistryObject<Block> OBSIDIAN_BRICK_WALL = registerBlock("obsidian_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(OBSIDIAN_BRICKS.get())));
    public static final RegistryObject<Block> CRACKED_OBSIDIAN_BRICKS = registerBlock("cracked_obsidian_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));
    //Tiles
    public static final RegistryObject<Block> OBSIDIAN_TILES = registerBlock("obsidian_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));
    public static final RegistryObject<Block> OBSIDIAN_TILE_STAIRS = registerBlock("obsidian_tile_stairs",
            () -> new StairBlock(OBSIDIAN_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(OBSIDIAN_TILES.get())));
    public static final RegistryObject<Block> OBSIDIAN_TILE_SLAB = registerBlock("obsidian_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(OBSIDIAN_TILES.get())));
    public static final RegistryObject<Block> OBSIDIAN_TILE_WALL = registerBlock("obsidian_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(OBSIDIAN_TILES.get())));
    public static final RegistryObject<Block> CRACKED_OBSIDIAN_TILES = registerBlock("cracked_obsidian_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));
    //Polished
    public static final RegistryObject<Block> POLISHED_OBSIDIAN = registerBlock("polished_obsidian",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));
    public static final RegistryObject<Block> POLISHED_OBSIDIAN_STAIRS = registerBlock("polished_obsidian_stairs",
            () -> new StairBlock(POLISHED_OBSIDIAN.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_OBSIDIAN.get())));
    public static final RegistryObject<Block> POLISHED_OBSIDIAN_SLAB = registerBlock("polished_obsidian_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_OBSIDIAN.get())));
    public static final RegistryObject<Block> POLISHED_OBSIDIAN_WALL = registerBlock("polished_obsidian_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_OBSIDIAN.get())));
    //Cobbled
    public static final RegistryObject<Block> COBBLED_OBSIDIAN = registerBlock("cobbled_obsidian",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));
    public static final RegistryObject<Block> COBBLED_OBSIDIAN_STAIRS = registerBlock("cobbled_obsidian_stairs",
            () -> new StairBlock(COBBLED_OBSIDIAN.get().defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_OBSIDIAN.get())));
    public static final RegistryObject<Block> COBBLED_OBSIDIAN_SLAB = registerBlock("cobbled_obsidian_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_OBSIDIAN.get())));
    public static final RegistryObject<Block> COBBLED_OBSIDIAN_WALL = registerBlock("cobbled_obsidian_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLED_OBSIDIAN.get())));
    //Chiseled
    public static final RegistryObject<Block> CHISELED_OBSIDIAN = registerBlock("chiseled_obsidian",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
