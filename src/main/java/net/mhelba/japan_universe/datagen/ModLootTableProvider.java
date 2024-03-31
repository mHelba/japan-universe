package net.mhelba.japan_universe.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.mhelba.japan_universe.block.ModBlocks;
import net.mhelba.japan_universe.block.custom.RiceCropBlock;
import net.mhelba.japan_universe.item.ModItems;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
  public ModLootTableProvider(FabricDataOutput dataOutput) {
    super(dataOutput);
  }

  @Override
  public void generate() {
    this.addDrop(ModBlocks.TAMAHAGANE_ORE_BLOCK);
    this.addDrop(ModBlocks.DEEPSLATE_TAMAHAGANE_ORE_BLOCK);

    BlockStatePropertyLootCondition.Builder builder =
        BlockStatePropertyLootCondition.builder(ModBlocks.RICE_CROP)
            .properties(StatePredicate.Builder.create().exactMatch(RiceCropBlock.AGE, 5));
    this.addDrop(
        ModBlocks.RICE_CROP,
        this.cropDrops(ModBlocks.RICE_CROP, ModItems.RICE_RAW, ModItems.RICE_RAW, builder));
  }
}
