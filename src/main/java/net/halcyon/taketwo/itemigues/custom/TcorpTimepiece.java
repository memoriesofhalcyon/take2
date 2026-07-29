package net.halcyon.taketwo.itemigues.custom;

import net.halcyon.taketwo.screns.Myscrens;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static java.lang.Math.round;
import static net.halcyon.taketwo.mycustomdataatachments.MyDataAtachments.TIMELESS;

public class TcorpTimepiece extends Item {


    public TcorpTimepiece(Properties properties) {
        super(properties);
    }

    private String mode = "";
    private float timeStored = 0f;
    public Boolean collecting = false;
    public Boolean accelerating = true;
    public Boolean activated = false;

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean isTimelocked = player.getData(TIMELESS);
        boolean altFunc = player.isCrouching();
        if (isTimelocked && !altFunc) {
            player.displayClientMessage(Component.literal("You can't use this right now"), true);
            player.getCooldowns().removeCooldown(this);
            return InteractionResultHolder.fail(itemstack);
        }
        else if(!altFunc) {
            player.displayClientMessage(Component.literal("Accelerating..."), true);
            player.setData(TIMELESS, true);
            timeStored = 0;
            player.getCooldowns().addCooldown(this,10);
            return InteractionResultHolder.consume(itemstack);
        }
        else if (altFunc) {
            if (collecting){
                collecting = false;
                accelerating = true;
                mode = "Accelerating";
            } else if (accelerating) {
                collecting = true;
                accelerating = false;
                mode = "Collecting";
            }
            player.displayClientMessage(Component.literal("Current mode:" + mode), true);
            player.startUsingItem(hand);
            player.getCooldowns().addCooldown(this,10);
            return InteractionResultHolder.consume(itemstack);
        }
        else{
            return InteractionResultHolder.fail(itemstack);
        }
    }
    @Override
    public int getUseDuration(ItemStack stack, net.minecraft.world.entity.LivingEntity entity) {
        return 72000; // Can be held down continuously for a long time
    }

}
