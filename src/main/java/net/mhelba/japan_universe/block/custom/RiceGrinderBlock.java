package net.mhelba.japan_universe.block.custom;

import com.mojang.serialization.MapCodec;
import net.mhelba.japan_universe.block.entity.ModBlockEntities;
import net.mhelba.japan_universe.block.entity.RiceGrinderBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RiceGrinderBlock extends BlockWithEntity implements BlockEntityProvider {
  public static final MapCodec<RiceGrinderBlock> CODEC =
      RiceGrinderBlock.createCodec(RiceGrinderBlock::new);
  private static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 12, 16);

  public RiceGrinderBlock(Settings settings) {
    super(settings);
  }

  @Override
  protected MapCodec<? extends BlockWithEntity> getCodec() {
    return CODEC;
  }

  @Override
  public VoxelShape getOutlineShape(
      BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return SHAPE;
  }

  @Override
  public BlockRenderType getRenderType(BlockState state) {
    return BlockRenderType.MODEL;
  }

  @Nullable
  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new RiceGrinderBlockEntity(pos, state);
  }

  @Override
  public void onStateReplaced(
      BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
    if (state.getBlock() != newState.getBlock()) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof RiceGrinderBlockEntity) {
        ItemScatterer.spawn(world, pos, (RiceGrinderBlockEntity) blockEntity);
        world.updateComparators(pos, this);
      }
      super.onStateReplaced(state, world, pos, newState, moved);
    }
  }

  @Override
  public ActionResult onUse(
      BlockState state,
      World world,
      BlockPos pos,
      PlayerEntity player,
      Hand hand,
      BlockHitResult hit) {
    if (!world.isClient) {
      NamedScreenHandlerFactory screenHandlerFactory =
          ((RiceGrinderBlockEntity) world.getBlockEntity(pos));

      if (screenHandlerFactory != null) {
        player.openHandledScreen(screenHandlerFactory);
      }
    }

    return ActionResult.SUCCESS;
  }

  @Nullable
  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
      World world, BlockState state, BlockEntityType<T> type) {
    return validateTicker(
        type,
        ModBlockEntities.RICE_GRINDER_BLOCK_ENTITY,
        (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
  }
}
