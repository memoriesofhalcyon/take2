package net.halcyon.taketwo.itemigues.custom;

import net.halcyon.taketwo.screns.Myscrens;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.client.event.ScreenEvent;

public class SubKnife extends Item {

    public SubKnife(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        MutableComponent mytext = Component.literal("Hello World!");
        Myscrens Thisscren = new Myscrens(mytext);
        if(level.isClientSide()){
            Minecraft.getInstance().setScreen(Thisscren);

        }

        return InteractionResultHolder.consume(itemstack);

        }

    }

