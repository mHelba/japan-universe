package net.mhelba.japan_universe.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.mhelba.japan_universe.JapanUniverse;
import net.mhelba.japan_universe.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
  public static final BlockEntityType<RiceGrinderBlockEntity> RICE_GRINDER_BLOCK_ENTITY =
      Registry.register(
          Registries.BLOCK_ENTITY_TYPE,
          new Identifier(JapanUniverse.MOD_ID, "rice_grinder_be"),
          FabricBlockEntityTypeBuilder.create(RiceGrinderBlockEntity::new, ModBlocks.RICE_GRINDER)
              .build());

  public static void registerBlockEntities() {
    JapanUniverse.LOGGER.info("Registering Block Entities for " + JapanUniverse.MOD_ID);
  }
}
