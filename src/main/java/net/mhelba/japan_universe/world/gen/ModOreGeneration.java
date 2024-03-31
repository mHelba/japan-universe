package net.mhelba.japan_universe.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mhelba.japan_universe.world.ModPlacedFeatures;
import net.minecraft.world.gen.GenerationStep.Feature;

public class ModOreGeneration {
  public static void generateOres() {
    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        Feature.UNDERGROUND_ORES,
        ModPlacedFeatures.TAMAHAGANE_ORE_PLACED_KEY);
  }
}
