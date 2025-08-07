package com.XYccWA.thediaryofsteve.ModBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ResearchTable extends HorizontalDirectionalBlock {
    protected static final VoxelShape EAST_SHAPE = Shapes.or(Block.box(0D,0D,0D,16D,16D,16D),Block.box(-2D,14D,-2D,18D,17D,18D));
    protected static final VoxelShape SOUTH_SHAPE = Shapes.or(Block.box(16D,0D,0D,0D,16D,16D),Block.box(18D,14D,-2D,-2D,17D,18D));
    protected static final VoxelShape WEST_SHAPE =Shapes.or(Block.box(16D,0D,16D,0D,16D,0D),Block.box(18D,14D,18D,-2D,17D,-2D));
    protected static final VoxelShape NORTH_SHAPE =Shapes.or(Block.box(0D,0D,16D,16D,16D,0D),Block.box(-2D,14D,18D,18D,17D,-2D));
    protected static final VoxelShape EAST_COLLISION_SHAPE = Shapes.or(Block.box(0D,0D,0D,16D,16D,16D),Block.box(-2D,14D,-2D,18D,17D,18D));
    protected static final VoxelShape SOUTH_COLLISION_SHAPE = Shapes.or(Block.box(16D,0D,0D,0D,16D,16D),Block.box(18D,14D,-2D,-2D,17D,18D));
    protected static final VoxelShape WEST_COLLISION_SHAPE =Shapes.or(Block.box(16D,0D,16D,0D,16D,0D),Block.box(18D,14D,18D,-2D,17D,-2D));
    protected static final VoxelShape NORTH_COLLISION_SHAPE =Shapes.or(Block.box(0D,0D,16D,16D,16D,0D),Block.box(-2D,14D,18D,18D,17D,-2D));


    public ResearchTable(Properties p_54120_) {
        super(p_54120_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.EAST));
    }


    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        var facing = blockState.getValue(FACING);
        return switch (facing){
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> EAST_SHAPE;
        };
    }
    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        var facing = blockState.getValue(FACING);
        return switch (facing){
            case NORTH -> NORTH_COLLISION_SHAPE;
            case SOUTH -> SOUTH_COLLISION_SHAPE;
            case WEST -> WEST_COLLISION_SHAPE;
            default -> EAST_COLLISION_SHAPE;
        };
    }
}
