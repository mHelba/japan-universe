package net.mhelba.japan_universe.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.mhelba.japan_universe.JapanUniverse;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
  public static final Block TAMAHAGANE_ORE_BLOCK =
      ModBlocks.registerBlock(
          "tamahagane_ore_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));

  private static Block registerBlock(String name, Block block) {
    ModBlocks.registerBlockItem(name, block);

    return Registry.register(Registries.BLOCK, new Identifier(JapanUniverse.MOD_ID, name), block);
  }

  private static Item registerBlockItem(String name, Block block) {
    return Registry.register(
        Registries.ITEM,
        new Identifier(JapanUniverse.MOD_ID, name),
        new BlockItem(block, new FabricItemSettings()));
  }

  public static void registerModBlocks() {
    JapanUniverse.LOGGER.info("Registering ModBlocks for " + JapanUniverse.MOD_ID);
  }
}
