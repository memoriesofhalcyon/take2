package net.halcyon.taketwo.blockigues;

import net.halcyon.taketwo.TakeTwo;
import net.halcyon.taketwo.itemigues.ModItemsigues;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocksigues {

    public static Boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }


    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TakeTwo.MODID);

    public static final DeferredBlock<Block> KNIFE_BLOCK = registerBlock("knife_block", () -> new TransparentBlock(BlockBehaviour.Properties.of().friction(1.1F).ignitedByLava().speedFactor(1.0f).noOcclusion().isViewBlocking(ModBlocksigues::never)));

    public static final DeferredBlock<Block> SPIKE = registerBlock("spike", () -> new TransparentBlock(BlockBehaviour.Properties.of().isViewBlocking(ModBlocksigues::never).noOcclusion().lightLevel(state ->8).noCollission()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItemsigues.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    }
