package dev.soncresityindustries.refinedobsidian.datagen;

import dev.soncresityindustries.refinedobsidian.block.ModBlocks;
import dev.soncresityindustries.refinedobsidian.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> OBSIDIAN_SMELTABLE = List.of(ModBlocks.COBBLED_OBSIDIAN);
    private static final List<ItemConvertible> OBSIDIAN_BLASTABLE = List.of(ModBlocks.COBBLED_OBSIDIAN);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(registryLookup, recipeExporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                offerSmelting(OBSIDIAN_SMELTABLE, RecipeCategory.BUILDING_BLOCKS, Blocks.OBSIDIAN, 0.5F, 400, "obsidian");
                offerBlasting(OBSIDIAN_BLASTABLE, RecipeCategory.BUILDING_BLOCKS, Blocks.OBSIDIAN, 0.5F, 200, "obsidian");

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_OBSIDIAN, 1)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .input('S', ModItems.OBSIDIAN_DUST)
                        .criterion(hasItem(ModItems.OBSIDIAN_DUST), conditionsFromItem(ModItems.OBSIDIAN_DUST))
                        .showNotification(true)
                        .offerTo(recipeExporter);

                //Chiseled
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_OBSIDIAN, 1)
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('S', ModBlocks.COBBLED_OBSIDIAN_SLAB)
                        .criterion(hasItem(ModBlocks.COBBLED_OBSIDIAN_SLAB), conditionsFromItem(ModBlocks.COBBLED_OBSIDIAN_SLAB))
                        .showNotification(true)
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_OBSIDIAN, ModBlocks.COBBLED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.MISC, ModItems.OBSIDIAN_DUST, Blocks.OBSIDIAN, 9);

                //Cracked
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_OBSIDIAN_BRICKS, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.OBSIDIAN_BRICKS)
                        .criterion(hasItem(ModBlocks.OBSIDIAN_BRICKS), conditionsFromItem(ModBlocks.OBSIDIAN_BRICKS))
                        .showNotification(true)
                        .offerTo(recipeExporter);
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_OBSIDIAN_TILES, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.OBSIDIAN_TILES)
                        .criterion(hasItem(ModBlocks.OBSIDIAN_TILES), conditionsFromItem(ModBlocks.OBSIDIAN_TILES))
                        .showNotification(true)
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_OBSIDIAN_BRICKS, ModBlocks.COBBLED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_OBSIDIAN_TILES, ModBlocks.OBSIDIAN_BRICKS, 1);

                //Slabs
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_OBSIDIAN_SLAB, ModBlocks.COBBLED_OBSIDIAN);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_SLAB, ModBlocks.OBSIDIAN_BRICKS);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_SLAB, ModBlocks.OBSIDIAN_TILES);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OBSIDIAN_SLAB, ModBlocks.POLISHED_OBSIDIAN);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_OBSIDIAN_SLAB, ModBlocks.COBBLED_OBSIDIAN, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_SLAB, ModBlocks.OBSIDIAN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_SLAB, ModBlocks.COBBLED_OBSIDIAN, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_SLAB, ModBlocks.OBSIDIAN_TILES, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_SLAB, ModBlocks.COBBLED_OBSIDIAN, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OBSIDIAN_SLAB, ModBlocks.POLISHED_OBSIDIAN, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OBSIDIAN_SLAB, ModBlocks.COBBLED_OBSIDIAN, 2);

                //Stairs
                createStairsRecipe(ModBlocks.COBBLED_OBSIDIAN_STAIRS, Ingredient.ofItems(ModBlocks.COBBLED_OBSIDIAN))
                        .criterion(hasItem(ModBlocks.COBBLED_OBSIDIAN), conditionsFromItem(ModBlocks.COBBLED_OBSIDIAN))
                        .offerTo(recipeExporter);
                createStairsRecipe(ModBlocks.OBSIDIAN_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.OBSIDIAN_BRICKS))
                        .criterion(hasItem(ModBlocks.OBSIDIAN_BRICKS), conditionsFromItem(ModBlocks.OBSIDIAN_BRICKS))
                        .offerTo(recipeExporter);
                createStairsRecipe(ModBlocks.OBSIDIAN_TILE_STAIRS, Ingredient.ofItems(ModBlocks.OBSIDIAN_TILES))
                        .criterion(hasItem(ModBlocks.OBSIDIAN_TILES), conditionsFromItem(ModBlocks.OBSIDIAN_TILES))
                        .offerTo(recipeExporter);
                createStairsRecipe(ModBlocks.POLISHED_OBSIDIAN_STAIRS, Ingredient.ofItems(ModBlocks.POLISHED_OBSIDIAN))
                        .criterion(hasItem(ModBlocks.POLISHED_OBSIDIAN), conditionsFromItem(ModBlocks.POLISHED_OBSIDIAN))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_OBSIDIAN_STAIRS, ModBlocks.COBBLED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_STAIRS, ModBlocks.OBSIDIAN_BRICKS, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_STAIRS, ModBlocks.COBBLED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_STAIRS, ModBlocks.OBSIDIAN_TILES, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_STAIRS, ModBlocks.COBBLED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OBSIDIAN_STAIRS, ModBlocks.POLISHED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OBSIDIAN_STAIRS, ModBlocks.COBBLED_OBSIDIAN, 1);

                //Walls
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_OBSIDIAN_WALL, ModBlocks.COBBLED_OBSIDIAN);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_WALL, ModBlocks.OBSIDIAN_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_WALL, ModBlocks.OBSIDIAN_TILES);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OBSIDIAN_WALL, ModBlocks.POLISHED_OBSIDIAN);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_OBSIDIAN_WALL, ModBlocks.COBBLED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_WALL, ModBlocks.OBSIDIAN_BRICKS, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_WALL, ModBlocks.COBBLED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_WALL, ModBlocks.OBSIDIAN_TILES, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_WALL, ModBlocks.COBBLED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OBSIDIAN_WALL, ModBlocks.POLISHED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OBSIDIAN_WALL, ModBlocks.COBBLED_OBSIDIAN, 1);

                //Bricks
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICKS, ModBlocks.COBBLED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICKS, ModBlocks.POLISHED_OBSIDIAN, 1);
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICKS, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.POLISHED_OBSIDIAN)
                        .criterion(hasItem(ModBlocks.POLISHED_OBSIDIAN), conditionsFromItem(ModBlocks.POLISHED_OBSIDIAN))
                        .showNotification(true)
                        .offerTo(recipeExporter);

                //Tiles
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILES, ModBlocks.COBBLED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILES, ModBlocks.OBSIDIAN_BRICKS, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILES, ModBlocks.POLISHED_OBSIDIAN, 1);
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILES, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.OBSIDIAN_BRICKS)
                        .criterion(hasItem(ModBlocks.OBSIDIAN_BRICKS), conditionsFromItem(ModBlocks.OBSIDIAN_BRICKS))
                        .showNotification(true)
                        .offerTo(recipeExporter);


                //Polished
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OBSIDIAN, ModBlocks.COBBLED_OBSIDIAN, 1);
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OBSIDIAN, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.COBBLED_OBSIDIAN)
                        .criterion(hasItem(ModBlocks.COBBLED_OBSIDIAN), conditionsFromItem(ModBlocks.COBBLED_OBSIDIAN))
                        .showNotification(true)
                        .offerTo(recipeExporter);

                //Random unorganized stuff (Good luck reading)
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_SLAB, ModBlocks.POLISHED_OBSIDIAN, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_STAIRS, ModBlocks.POLISHED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_WALL, ModBlocks.POLISHED_OBSIDIAN, 1);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_SLAB, ModBlocks.OBSIDIAN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_SLAB, ModBlocks.POLISHED_OBSIDIAN, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_STAIRS, ModBlocks.OBSIDIAN_BRICKS, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_STAIRS, ModBlocks.POLISHED_OBSIDIAN, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_WALL, ModBlocks.OBSIDIAN_BRICKS, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_TILE_WALL, ModBlocks.POLISHED_OBSIDIAN, 1);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
