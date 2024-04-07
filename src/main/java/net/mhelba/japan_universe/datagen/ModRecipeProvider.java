package net.mhelba.japan_universe.datagen;

import java.util.List;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mhelba.japan_universe.block.ModBlocks;
import net.mhelba.japan_universe.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {
  private static final List<ItemConvertible> SMELTABLES_TO_RICE_COOKED =
      List.of(ModItems.RICE_WHITE);
  private static final List<ItemConvertible> SMELTABLES_TO_TAMAHAGANE_NUGGET =
      List.of(ModBlocks.TAMAHAGANE_ORE_BLOCK, ModBlocks.DEEPSLATE_TAMAHAGANE_ORE_BLOCK);

  public ModRecipeProvider(FabricDataOutput output) {
    super(output);
  }

  private static void offerSmoking(
      RecipeExporter exporter,
      List<ItemConvertible> inputs,
      RecipeCategory category,
      ItemConvertible output,
      float experience,
      int cookingTime,
      String group) {
    RecipeProvider.offerMultipleOptions(
        exporter,
        RecipeSerializer.SMOKING,
        SmokingRecipe::new,
        inputs,
        category,
        output,
        experience,
        cookingTime,
        group,
        "_from_smoking");
  }

  @Override
  public void generate(RecipeExporter exporter) {
    ModRecipeProvider.offerSmelting(
        exporter,
        SMELTABLES_TO_RICE_COOKED,
        RecipeCategory.MISC,
        ModItems.RICE_COOKED,
        0.7f,
        200,
        "rice_cooked");
    ModRecipeProvider.offerBlasting(
        exporter,
        SMELTABLES_TO_RICE_COOKED,
        RecipeCategory.MISC,
        ModItems.RICE_COOKED,
        0.7f,
        100,
        "rice_cooked");
    ModRecipeProvider.offerSmoking(
        exporter,
        SMELTABLES_TO_RICE_COOKED,
        RecipeCategory.MISC,
        ModItems.RICE_COOKED,
        0.7f,
        100,
        "rice_cooked");

    ModRecipeProvider.offerSmelting(
        exporter,
        SMELTABLES_TO_TAMAHAGANE_NUGGET,
        RecipeCategory.MISC,
        ModItems.TAMAHAGANE_NUGGET,
        1f,
        200,
        "tamahagane_nugget");
    ModRecipeProvider.offerBlasting(
        exporter,
        SMELTABLES_TO_TAMAHAGANE_NUGGET,
        RecipeCategory.MISC,
        ModItems.TAMAHAGANE_NUGGET,
        1f,
        100,
        "tamahagane_nugget");

    ModRecipeProvider.offerCompactingRecipe(
        exporter, RecipeCategory.MISC, ModItems.TAMAHAGANE_INGOT, ModItems.TAMAHAGANE_NUGGET);
    ModRecipeProvider.offerShapelessRecipe(
        exporter, ModItems.TAMAHAGANE_NUGGET, ModItems.TAMAHAGANE_INGOT, "tamahagane_nugget", 9);

    ModRecipeProvider.offerCompactingRecipe(
        exporter, RecipeCategory.MISC, ModBlocks.TAMAHAGANE_BLOCK, ModItems.TAMAHAGANE_INGOT);
    ModRecipeProvider.offerShapelessRecipe(
        exporter, ModItems.TAMAHAGANE_INGOT, ModBlocks.TAMAHAGANE_BLOCK, "tamahagane_ingot", 9);

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

    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RICE_GRINDER, 1)
        .pattern("SFS")
        .pattern("TRT")
        .pattern("TTT")
        .input('S', Blocks.STONE)
        .input('F', Items.FLINT)
        .input('R', Items.REDSTONE)
        .input('T', ModItems.TAMAHAGANE_INGOT)
        .criterion(
            ModRecipeProvider.hasItem(Blocks.STONE),
            ModRecipeProvider.conditionsFromItem(Blocks.STONE))
        .criterion(
            ModRecipeProvider.hasItem(Items.FLINT),
            ModRecipeProvider.conditionsFromItem(Items.FLINT))
        .criterion(
            ModRecipeProvider.hasItem(Items.REDSTONE),
            ModRecipeProvider.conditionsFromItem(Items.REDSTONE))
        .criterion(
            ModRecipeProvider.hasItem(ModItems.TAMAHAGANE_INGOT),
            ModRecipeProvider.conditionsFromItem(ModItems.TAMAHAGANE_INGOT))
        .offerTo(exporter, new Identifier(ModRecipeProvider.getRecipeName(ModBlocks.RICE_GRINDER)));
  }
}
