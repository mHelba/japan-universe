package net.mhelba.japan_universe.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.mhelba.japan_universe.JapanUniverse;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
  public static final ScreenHandlerType<RiceGrinderScreenHandler> RICE_GRINDER_SCREEN_HANDLER =
      Registry.register(
          Registries.SCREEN_HANDLER,
          new Identifier(JapanUniverse.MOD_ID, "rice_grinder"),
          new ExtendedScreenHandlerType<>(RiceGrinderScreenHandler::new));

  public static void registerScreenHandlers() {
    JapanUniverse.LOGGER.info("Registering Screen Handlers for " + JapanUniverse.MOD_ID);
  }
}
