package net.mhelba.japan_universe.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.mhelba.japan_universe.block.ModBlocks;
import net.mhelba.japan_universe.block.custom.RiceCropBlock;
import net.mhelba.japan_universe.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
  public ModModelProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TAMAHAGANE_ORE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TAMAHAGANE_ORE_BLOCK);

    blockStateModelGenerator.registerCrop(ModBlocks.RICE_CROP, RiceCropBlock.AGE, 0, 1, 2, 3, 4, 5);

    blockStateModelGenerator.registerSimpleState(ModBlocks.RICE_GRINDER);
  }

  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    itemModelGenerator.register(ModItems.ONIGIRI_SALMON, Models.GENERATED);
    itemModelGenerator.register(ModItems.RICE_WHITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.RICE_COOKED, Models.GENERATED);
    itemModelGenerator.register(ModItems.TAMAHAGANE_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.TAMAHAGANE_INGOT, Models.GENERATED);
  }
}
