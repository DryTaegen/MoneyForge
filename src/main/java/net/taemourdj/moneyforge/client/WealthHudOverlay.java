package net.taemourdj.moneyforge.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.taemourdj.moneyforge.MoneyForge;

public class WealthHudOverlay {
    private static final ResourceLocation MONEY = new ResourceLocation(MoneyForge.MOD_ID,
            "textures/money/ModItems.png");

    public static final IGuiOverlay HUD_WEALTH = (((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
        int x = screenWidth / 2;
        int y = screenHeight;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, MONEY);
            GuiComponent.blit(poseStack,x - 94 + (9), y - 54,0,0,12,12,
                    12,12);

    }));
}
