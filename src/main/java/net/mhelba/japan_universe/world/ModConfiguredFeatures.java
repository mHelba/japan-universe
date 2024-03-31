package net.mhelba.japan_universe.world;

import java.util.List;
import net.mhelba.japan_universe.JapanUniverse;
import net.mhelba.japan_universe.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ModConfiguredFeatures {
  public static final RegistryKey<ConfiguredFeature<?, ?>> TAMAHAGANE_ORE_KEY =
      ModConfiguredFeatures.registerKey("tamahagane_ore");

  public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
    RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    RuleTest deepslateReplacable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    List<OreFeatureConfig.Target> overworldTamahaganeOres =
        List.of(
            OreFeatureConfig.createTarget(
                stoneReplacables, ModBlocks.TAMAHAGANE_ORE_BLOCK.getDefaultState()),
            OreFeatureConfig.createTarget(
                deepslateReplacable, ModBlocks.DEEPSLATE_TAMAHAGANE_ORE_BLOCK.getDefaultState()));

    ModConfiguredFeatures.register(
        context,
        TAMAHAGANE_ORE_KEY,
        Feature.ORE,
        new OreFeatureConfig(overworldTamahaganeOres, 12));
  }

  public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
    return RegistryKey.of(
        RegistryKeys.CONFIGURED_FEATURE, new Identifier(JapanUniverse.MOD_ID, name));
  }

  private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
      Registerable<ConfiguredFeature<?, ?>> context,
      RegistryKey<ConfiguredFeature<?, ?>> key,
      F feature,
      FC configuration) {
    context.register(key, new ConfiguredFeature<>(feature, configuration));
  }
}
