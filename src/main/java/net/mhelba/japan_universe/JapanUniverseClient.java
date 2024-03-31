package net.mhelba.japan_universe;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.mhelba.japan_universe.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class JapanUniverseClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RICE_CROP, RenderLayer.getCutout());
  }
}
