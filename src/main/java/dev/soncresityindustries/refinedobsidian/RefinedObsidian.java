package dev.soncresityindustries.refinedobsidian;

import dev.soncresityindustries.refinedobsidian.block.ModBlocks;
import dev.soncresityindustries.refinedobsidian.item.ModItemGroups;
import dev.soncresityindustries.refinedobsidian.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RefinedObsidian implements ModInitializer {
	public static final String MOD_ID = "si_refined_obsidian";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final String MOD_VERSION = "1.0.0-1.21.1-fabric";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Mod Refined Obsidian (Version " + MOD_VERSION + ") by Soncresity Industries");
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}