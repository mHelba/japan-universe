package net.mhelba.japan_universe.world;

import java.util.List;
import net.mhelba.japan_universe.JapanUniverse;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

public class ModPlacedFeatures {
  public static final RegistryKey<PlacedFeature> TAMAHAGANE_ORE_PLACED_KEY =
      ModPlacedFeatures.registerKey("tamahagane_ore_placed");

  public static void bootstrap(Registerable<PlacedFeature> context) {
    var configuredFeatureRegistryEntryLookup =
        context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

    ModPlacedFeatures.register(
        context,
        TAMAHAGANE_ORE_PLACED_KEY,
        configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TAMAHAGANE_ORE_KEY),
        ModOrePlacement.modifiersWithCount(
            12, HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(80))));
  }

  public static RegistryKey<PlacedFeature> registerKey(String name) {
    return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(JapanUniverse.MOD_ID, name));
  }

  private static void register(
      Registerable<PlacedFeature> context,
      RegistryKey<PlacedFeature> key,
      RegistryEntry<ConfiguredFeature<?, ?>> configuration,
      List<PlacementModifier> modifiers) {
    context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
  }
}
