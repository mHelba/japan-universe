package net.mhelba.japan_universe.world;

import java.util.List;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class ModOrePlacement {
  public static List<PlacementModifier> modifiers(
      PlacementModifier countModifier, PlacementModifier heightModifier) {
    return List.of(
        countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
  }

  public static List<PlacementModifier> modifiersWithCount(
      int count, PlacementModifier heightModifier) {
    return ModOrePlacement.modifiers(CountPlacementModifier.of(count), heightModifier);
  }

  public static List<PlacementModifier> modifiersWithRarity(
      int chance, PlacementModifier heightModifier) {
    return ModOrePlacement.modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
  }
}
