package net.mhelba.japan_universe.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
  public static final FoodComponent ONIGIRI_SALMON =
      new FoodComponent.Builder()
          .hunger(3)
          .saturationModifier(0.25f)
          .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 0.25f)
          .build();
  public static final FoodComponent RICE_COOKED =
      new FoodComponent.Builder().hunger(3).saturationModifier(0.25f).build();
}
