package net.mhelba.japan_universe.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.mhelba.japan_universe.JapanUniverse;
import net.mhelba.japan_universe.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
  public static final Item ONIGIRI_SALMON =
      ModItems.registerItem(
          "onigiri_salmon",
          new Item(new FabricItemSettings().food(ModFoodComponents.ONIGIRI_SALMON)));
  public static final Item RICE_RAW =
      ModItems.registerItem(
          "rice_raw", new AliasedBlockItem(ModBlocks.RICE_CROP, new FabricItemSettings()));
  public static final Item RICE_WHITE =
      ModItems.registerItem("rice_white", new Item(new FabricItemSettings()));
  public static final Item RICE_COOKED =
      ModItems.registerItem(
          "rice_cooked", new Item(new FabricItemSettings().food(ModFoodComponents.RICE_COOKED)));

  public static final Item TAMAHAGANE_NUGGET =
      ModItems.registerItem("tamahagane_nugget", new Item(new FabricItemSettings()));
  public static final Item TAMAHAGANE_INGOT =
      ModItems.registerItem("tamahagane_ingot", new Item(new FabricItemSettings()));

  private static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM, new Identifier(JapanUniverse.MOD_ID, name), item);
  }

  public static void registerModItems() {
    JapanUniverse.LOGGER.info("Registering Mod Items for " + JapanUniverse.MOD_ID);
  }
}
