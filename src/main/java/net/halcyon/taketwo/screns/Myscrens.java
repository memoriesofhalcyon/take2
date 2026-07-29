package net.halcyon.taketwo.screns;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class Myscrens extends Screen {
    public Myscrens(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();

        // Add widgets and precomputed values
        this.addRenderableWidget(new EditBox(this.font, 100, 50, 200, 20, Component.literal("fineeeeeeeeeeeeeee >=(")));
      //  this.addRenderableWidget(new ImageButton(100,50,200,20, );

    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        // Render things here before widgets (background textures)

        // Then the widgets if this is a direct child of the Screen
        super.render(graphics, mouseX, mouseY, partialTick);

        // Render things after widgets (tooltips)
    }

    @Override
    public void tick() {
        super.tick();
    }
    @Override
    public void onClose() {
        // Stop any handlers here

        // Call last in case it interferes with the override
        super.onClose();
    }

    @Override
    public void removed() {
        // Reset initial states here

        // Call last in case it interferes with the override
        super.removed()
        ;}
    @Override
    public boolean isPauseScreen(){
        return (false);
    }
}
