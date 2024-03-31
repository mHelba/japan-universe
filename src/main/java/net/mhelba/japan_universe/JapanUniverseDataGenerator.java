package net.mhelba.japan_universe;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.mhelba.japan_universe.datagen.ModBlockTagProvider;
import net.mhelba.japan_universe.datagen.ModItemTagProvider;
import net.mhelba.japan_universe.datagen.ModLootTableProvider;
import net.mhelba.japan_universe.datagen.ModModelProvider;
import net.mhelba.japan_universe.datagen.ModRecipeProvider;
import net.mhelba.japan_universe.datagen.ModWorldGenerator;
import net.mhelba.japan_universe.world.ModConfiguredFeatures;
import net.mhelba.japan_universe.world.ModPlacedFeatures;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class JapanUniverseDataGenerator implements DataGeneratorEntrypoint {
  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

    pack.addProvider(ModBlockTagProvider::new);
    pack.addProvider(ModItemTagProvider::new);
    pack.addProvider(ModLootTableProvider::new);
    pack.addProvider(ModModelProvider::new);
    pack.addProvider(ModRecipeProvider::new);
    pack.addProvider(ModWorldGenerator::new);
  }

  @Override
  public void buildRegistry(RegistryBuilder registryBuilder) {
    registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
    registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
  }
}
