package net.mhelba.japan_universe.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.mhelba.japan_universe.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
  public static void registerCustomTrades() {
    TradeOfferHelper.registerVillagerOffers(
        VillagerProfession.FARMER,
        1,
        factories -> {
          factories.add(
              (entity, random) ->
                  new TradeOffer(
                      new ItemStack(Items.EMERALD, 1),
                      new ItemStack(ModItems.RICE_RAW, 8),
                      6,
                      5,
                      0.05f));
        });
  }
}
