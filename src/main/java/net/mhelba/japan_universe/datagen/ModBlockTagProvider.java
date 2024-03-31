package net.mhelba.japan_universe.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mhelba.japan_universe.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
  public ModBlockTagProvider(
      FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  protected void configure(WrapperLookup arg) {
    this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
        .add(ModBlocks.TAMAHAGANE_ORE_BLOCK)
        .add(ModBlocks.DEEPSLATE_TAMAHAGANE_ORE_BLOCK);

    this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
        .add(ModBlocks.TAMAHAGANE_ORE_BLOCK)
        .add(ModBlocks.DEEPSLATE_TAMAHAGANE_ORE_BLOCK);
  }
}
