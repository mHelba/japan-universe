package net.mhelba.japan_universe.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.mhelba.japan_universe.JapanUniverse;
import net.mhelba.japan_universe.block.custom.RiceCropBlock;
import net.mhelba.japan_universe.block.custom.RiceGrinderBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
  public static final Block TAMAHAGANE_ORE_BLOCK =
      ModBlocks.registerBlock(
          "tamahagane_ore_block",
          new ExperienceDroppingBlock(
              UniformIntProvider.create(0, 2), FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
  public static final Block DEEPSLATE_TAMAHAGANE_ORE_BLOCK =
      ModBlocks.registerBlock(
          "deepslate_tamahagane_ore_block",
          new ExperienceDroppingBlock(
              UniformIntProvider.create(0, 2),
              FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE)));

  public static final Block TAMAHAGANE_BLOCK =
      ModBlocks.registerBlock(
          "tamahagane_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

  public static final Block RICE_CROP =
      Registry.register(
          Registries.BLOCK,
          new Identifier(JapanUniverse.MOD_ID, "rice_crop"),
          new RiceCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

  public static final Block RICE_GRINDER =
      ModBlocks.registerBlock(
          "rice_grinder",
          new RiceGrinderBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

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
