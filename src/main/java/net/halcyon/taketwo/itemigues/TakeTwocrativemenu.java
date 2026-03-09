package net.halcyon.taketwo.itemigues;

import net.halcyon.taketwo.TakeTwo;
import net.halcyon.taketwo.blockigues.ModBlocksigues;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TakeTwocrativemenu {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TakeTwo.MODID);

    public static final Supplier<CreativeModeTab> TAKETWO_TAB = CREATIVE_MODE_TAB.register("taketwo_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItemsigues.KNIFE.get()))
            .title(Component.translatable("creativetab.taketwo.taketwo_tab"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItemsigues.HBKNIFE);
                output.accept(ModItemsigues.KNIFE);

                //blocks

                output.accept(ModBlocksigues.KNIFE_BLOCK);
                output.accept(ModBlocksigues.SPIKE);
            })
            .build());
}
