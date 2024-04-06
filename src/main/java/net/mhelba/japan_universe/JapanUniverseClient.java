package net.mhelba.japan_universe;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.mhelba.japan_universe.block.ModBlocks;
import net.mhelba.japan_universe.screen.ModScreenHandlers;
import net.mhelba.japan_universe.screen.RiceGrinderScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class JapanUniverseClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RICE_CROP, RenderLayer.getCutout());

    HandledScreens.register(ModScreenHandlers.RICE_GRINDER_SCREEN_HANDLER, RiceGrinderScreen::new);
  }
}
