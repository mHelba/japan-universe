package net.mhelba.japan_universe;

import net.fabricmc.api.ModInitializer;
import net.mhelba.japan_universe.block.ModBlocks;
import net.mhelba.japan_universe.item.ModItemGroups;
import net.mhelba.japan_universe.item.ModItems;
import net.mhelba.japan_universe.util.ModCustomTrades;
import net.mhelba.japan_universe.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JapanUniverse implements ModInitializer {
  public static final String MOD_ID = "japan_universe";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    LOGGER.info("Hello Fabric world!");
    ModItemGroups.registerItemGroups();
    ModItems.registerModItems();
    ModBlocks.registerModBlocks();

    ModCustomTrades.registerCustomTrades();

    ModWorldGeneration.generateModWorldGen();
  }
}
