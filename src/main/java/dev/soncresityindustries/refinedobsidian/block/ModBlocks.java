package dev.soncresityindustries.refinedobsidian.block;

import dev.soncresityindustries.refinedobsidian.RefinedObsidian;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //Bricks
    public static final Block OBSIDIAN_BRICKS = registerBlock("obsidian_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));
    public static final Block OBSIDIAN_BRICK_STAIRS = registerBlock("obsidian_brick_stairs",
            new StairsBlock(OBSIDIAN_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(OBSIDIAN_BRICKS)));
    public static final Block OBSIDIAN_BRICK_SLAB = registerBlock("obsidian_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(OBSIDIAN_BRICKS)));
    public static final Block OBSIDIAN_BRICK_WALL = registerBlock("obsidian_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(OBSIDIAN_BRICKS).solid()));
    public static final Block CRACKED_OBSIDIAN_BRICKS = registerBlock("cracked_obsidian_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));
    //Tiles
    public static final Block OBSIDIAN_TILES = registerBlock("obsidian_tiles",
            new Block(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));
    public static final Block OBSIDIAN_TILE_STAIRS = registerBlock("obsidian_tile_stairs",
            new StairsBlock(OBSIDIAN_TILES.getDefaultState(), AbstractBlock.Settings.copy(OBSIDIAN_TILES)));
    public static final Block OBSIDIAN_TILE_SLAB = registerBlock("obsidian_tile_slab",
            new SlabBlock(AbstractBlock.Settings.copy(OBSIDIAN_TILES)));
    public static final Block OBSIDIAN_TILE_WALL = registerBlock("obsidian_tile_wall",
            new WallBlock(AbstractBlock.Settings.copy(OBSIDIAN_TILES).solid()));
    public static final Block CRACKED_OBSIDIAN_TILES = registerBlock("cracked_obsidian_tiles",
            new Block(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));
    //Polished
    public static final Block POLISHED_OBSIDIAN = registerBlock("polished_obsidian",
            new Block(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));
    public static final Block POLISHED_OBSIDIAN_STAIRS = registerBlock("polished_obsidian_stairs",
            new StairsBlock(POLISHED_OBSIDIAN.getDefaultState(), AbstractBlock.Settings.copy(POLISHED_OBSIDIAN)));
    public static final Block POLISHED_OBSIDIAN_SLAB = registerBlock("polished_obsidian_slab",
            new SlabBlock(AbstractBlock.Settings.copy(POLISHED_OBSIDIAN)));
    public static final Block POLISHED_OBSIDIAN_WALL = registerBlock("polished_obsidian_wall",
            new WallBlock(AbstractBlock.Settings.copy(POLISHED_OBSIDIAN).solid()));
    //Cobbled
    public static final Block COBBLED_OBSIDIAN = registerBlock("cobbled_obsidian",
            new Block(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));
    public static final Block COBBLED_OBSIDIAN_STAIRS = registerBlock("cobbled_obsidian_stairs",
            new StairsBlock(COBBLED_OBSIDIAN.getDefaultState(), AbstractBlock.Settings.copy(COBBLED_OBSIDIAN)));
    public static final Block COBBLED_OBSIDIAN_SLAB = registerBlock("cobbled_obsidian_slab",
            new SlabBlock(AbstractBlock.Settings.copy(COBBLED_OBSIDIAN)));
    public static final Block COBBLED_OBSIDIAN_WALL = registerBlock("cobbled_obsidian_wall",
            new WallBlock(AbstractBlock.Settings.copy(COBBLED_OBSIDIAN).solid()));
    //Chiseled
    public static final Block CHISELED_OBSIDIAN = registerBlock("chiseled_obsidian",
            new Block(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));

    //Registries
    private static Block registerBlock(String name, Block block) {
        Block registeredBlock = Registry.register(Registries.BLOCK, Identifier.of(RefinedObsidian.MOD_ID, name), block);
        registerBlockItem(name, registeredBlock);
        return registeredBlock;
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, Identifier.of(RefinedObsidian.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RefinedObsidian.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        RefinedObsidian.LOGGER.info("Registering Blocks for " + RefinedObsidian.MOD_ID);
    }
}
