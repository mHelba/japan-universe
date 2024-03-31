package net.mhelba.japan_universe.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.mhelba.japan_universe.block.ModBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
  public ModModelProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TAMAHAGANE_ORE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TAMAHAGANE_ORE_BLOCK);
  }

  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {}
}
