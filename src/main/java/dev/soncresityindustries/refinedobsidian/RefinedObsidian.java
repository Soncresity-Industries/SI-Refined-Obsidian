package dev.soncresityindustries.refinedobsidian;

import com.mojang.logging.LogUtils;
import dev.soncresityindustries.refinedobsidian.block.ModBlocks;
import dev.soncresityindustries.refinedobsidian.items.ModCreativeModeTabs;
import dev.soncresityindustries.refinedobsidian.items.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(RefinedObsidian.MODID)
public class RefinedObsidian {
    public static final String MODID = "si_refined_obsidian";
    public static final String MOD_VERSION = "1.0.0-1.21.1-forge";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RefinedObsidian(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Initializing Mod Refined Obsidian (Version " + MOD_VERSION + ") by Soncresity Industries");
    }
}
