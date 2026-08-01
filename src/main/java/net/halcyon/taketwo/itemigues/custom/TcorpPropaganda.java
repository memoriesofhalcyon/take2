package net.halcyon.taketwo.itemigues.custom;

import io.netty.util.AttributeMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TcorpPropaganda extends Item {
    int nextChange = 0;
    ResourceLocation id = ResourceLocation.fromNamespaceAndPath("TakeTwo", "net.halcyon.taketwo.itemigues.custom.TcorpPropaganda");
    AttributeModifier speed = new AttributeModifier(
            // The name we defined earlier.
            id,
            // The amount by which we modify the attribute value.
            (Math.random()*2),
            // The operation used to apply the modifier. Possible values are:
            // - AttributeModifier.Operation.ADD_VALUE: Adds the value to the total attribute value.
            // - AttributeModifier.Operation.ADD_MULTIPLIED_BASE: Multiplies the value with the attribute base value
            //   and adds it to the total attribute value.
            // - AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL: Multiplies the value with the total attribute value,
            //   i.e. the attribute base value with all previous modifications already performed,
            //   and adds it to the total attribute value.
            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
    );


    public TcorpPropaganda(Properties properties) {
        super(properties);
    }
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        if (!level.isClientSide) {
            if(entity instanceof LivingEntity livingEntity){
                if (nextChange>0){
                    nextChange -=1;
                }
                else if (nextChange ==0) {
                    AttributeMap attributes = (AttributeMap) livingEntity.getAttributes();
                    attributes.attr(SPEED)
                    nextChange = ((int) (Math.random()*100));
                }
            }
        }
        }
}
