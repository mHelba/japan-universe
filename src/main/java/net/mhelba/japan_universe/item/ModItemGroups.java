package net.mhelba.japan_universe.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.mhelba.japan_universe.JapanUniverse;
import net.mhelba.japan_universe.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
  public static final ItemGroup JAPAN_UNIVERSE_ITEM_GROUP =
      Registry.register(
          Registries.ITEM_GROUP,
          new Identifier(JapanUniverse.MOD_ID, "japan_universe"),
          FabricItemGroup.builder()
              .displayName(Text.translatable("itemgroup.japan_universe"))
              .icon(() -> new ItemStack(ModBlocks.TAMAHAGANE_ORE_BLOCK))
              .entries(
                  (displayContext, entries) -> {
                    entries.add(ModBlocks.TAMAHAGANE_ORE_BLOCK);
                  })
              .build());

  public static void registerItemGroups() {
    JapanUniverse.LOGGER.info("Registering Item Groups for " + JapanUniverse.MOD_ID);
  }
}
