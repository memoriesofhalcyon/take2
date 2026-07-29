package net.halcyon.taketwo.itemigues;

import net.halcyon.taketwo.TakeTwo;
import net.halcyon.taketwo.itemigues.custom.SubKnife;
import net.halcyon.taketwo.itemigues.custom.TcorpTimepiece;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItemsigues {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TakeTwo.MODID);

    public static final DeferredItem<Item> KNIFE = ITEMS.register("knife",()-> new SubKnife(new Item.Properties()));

    public static final DeferredItem<Item> HBKNIFE = ITEMS.register("hbknife",() -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POCKET_WATCH = ITEMS.register("pocket_watch",() -> new TcorpTimepiece(new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}