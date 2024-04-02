package net.mhelba.japan_universe.block.custom;

import net.mhelba.japan_universe.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.IntProperty;

public class RiceCropBlock extends CropBlock {
  public static final int MAX_AGE = 5;
  public static final IntProperty AGE = IntProperty.of("age", 0, 5);

  public RiceCropBlock(Settings settings) {
    super(settings);
  }

  @Override
  protected ItemConvertible getSeedsItem() {
    return ModItems.RICE_RAW;
  }

  @Override
  protected IntProperty getAgeProperty() {
    return RiceCropBlock.AGE;
  }

  @Override
  public int getMaxAge() {
    return RiceCropBlock.MAX_AGE;
  }

  @Override
  protected void appendProperties(Builder<Block, BlockState> builder) {
    builder.add(RiceCropBlock.AGE);
  }
}
