package net.mhelba.japan_universe.datagen;

import java.util.List;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mhelba.japan_universe.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {
  private static final List<ItemConvertible> SMELTABLES = List.of(ModItems.RICE_WHITE);

  public ModRecipeProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generate(RecipeExporter exporter) {
    ModRecipeProvider.offerSmelting(
        exporter, SMELTABLES, RecipeCategory.MISC, ModItems.RICE_COOKED, 0.7f, 200, "rice_cooked");
    ModRecipeProvider.offerBlasting(
        exporter, SMELTABLES, RecipeCategory.MISC, ModItems.RICE_COOKED, 0.7f, 100, "rice_cooked");

    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ONIGIRI_SALMON, 8)
        .pattern(" R ")
        .pattern("RSR")
        .pattern("RKR")
        .input('R', ModItems.RICE_COOKED)
        .input('S', Items.COOKED_SALMON)
        .input('K', Items.DRIED_KELP)
        .criterion(
            ModRecipeProvider.hasItem(ModItems.RICE_COOKED),
            ModRecipeProvider.conditionsFromItem(ModItems.RICE_COOKED))
        .criterion(
            ModRecipeProvider.hasItem(Items.COOKED_SALMON),
            ModRecipeProvider.conditionsFromItem(Items.COOKED_SALMON))
        .criterion(
            ModRecipeProvider.hasItem(Items.DRIED_KELP),
            ModRecipeProvider.conditionsFromItem(Items.DRIED_KELP))
        .offerTo(
            exporter, new Identifier(ModRecipeProvider.getRecipeName(ModItems.ONIGIRI_SALMON)));
  }
}
