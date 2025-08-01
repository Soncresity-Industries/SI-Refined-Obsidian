package dev.soncresityindustries.refinedobsidian;

import dev.soncresityindustries.refinedobsidian.block.ModBlocks;
import dev.soncresityindustries.refinedobsidian.item.ModCreativeModeTabs;
import dev.soncresityindustries.refinedobsidian.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(RefinedObsidian.MOD_ID)
public class RefinedObsidian {
    public static final String MOD_ID = "si_refined_obsidian";
    public static final String MOD_VERSION = "1.0.0-1.21.4-neoforge";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RefinedObsidian(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Initializing Mod Refined Obsidian (Version " + MOD_VERSION + ") by Soncresity Industries");
    }
}
