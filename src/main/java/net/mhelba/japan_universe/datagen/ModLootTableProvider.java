package net.mhelba.japan_universe.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.mhelba.japan_universe.block.ModBlocks;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
  public ModLootTableProvider(FabricDataOutput dataOutput) {
    super(dataOutput);
  }

  @Override
  public void generate() {
    this.addDrop(ModBlocks.TAMAHAGANE_ORE_BLOCK);
    this.addDrop(ModBlocks.DEEPSLATE_TAMAHAGANE_ORE_BLOCK);
  }
}
