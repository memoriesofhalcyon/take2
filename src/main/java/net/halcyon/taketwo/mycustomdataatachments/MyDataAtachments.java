package net.halcyon.taketwo.mycustomdataatachments;

import com.mojang.serialization.Codec;
import net.halcyon.taketwo.TakeTwo;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

import static net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion.MOD_ID;

public class MyDataAtachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MOD_ID);

    public static final Supplier<AttachmentType<Boolean>> TIMELESS = ATTACHMENT_TYPES.register(
            "timeless", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build());


}
