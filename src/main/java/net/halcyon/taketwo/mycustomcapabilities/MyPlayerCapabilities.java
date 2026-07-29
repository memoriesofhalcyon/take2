package net.halcyon.taketwo.mycustomcapabilities;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.capabilities.EntityCapability;

public class MyPlayerCapabilities {

    public static final EntityCapability<Boolean,Void>READY_TO_BORROW_TIME = EntityCapability.create(
            ResourceLocation.fromNamespaceAndPath("taketwo", "ready_to_borrow_time"),
            Boolean.class,
            Void.class
    );


}
