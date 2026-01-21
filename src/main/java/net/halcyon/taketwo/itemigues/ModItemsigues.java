package net.halcyon.taketwo.itemigues;

import net.halcyon.taketwo.TakeTwo;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItemsigues {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TakeTwo.MODID);

    public static final DeferredItem<Item> KNIFE = ITEMS.register("knife",()-> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}