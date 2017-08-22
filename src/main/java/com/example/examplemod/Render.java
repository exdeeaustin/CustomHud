package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.EnumChatFormatting;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Render extends Gui {

	private final int background = 1140850688;
	Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void renderStuff(RenderGameOverlayEvent e) {
		if (!CustomHud.fpsEnabled && !CustomHud.coordsEnabled) {
			return;
		}

		if (e.isCancelable() || e.type != RenderGameOverlayEvent.ElementType.HOTBAR
				|| this.mc.gameSettings.showDebugInfo) {
			return;
		}

		if (fpsOnly()) {
			renderFPS();
		} else if (CustomHud.coordsEnabled) {
			renderCoords();
		}

	}

	public void renderCoords() {
		FontRenderer frender = Minecraft.getMinecraft().fontRendererObj;
		double coordsx = mc.thePlayer.posX;
		double coordsy = mc.thePlayer.posY;
		double coordsz = mc.thePlayer.posZ;

		int x = (int) Math.round(coordsx);
		int y = (int) Math.round(coordsy);
		int z = (int) Math.round(coordsz);
		String sx = Integer.toString(x);
		String sy = Integer.toString(y);
		String sz = Integer.toString(z);

		frender.drawString("X: " + sx, 5, 5, CustomHud.COORDS_COLOR, true);
		frender.drawString("Y: " + sy, 5, 15, CustomHud.COORDS_COLOR, true);
		frender.drawString("Z: " + sz, 5, 25, CustomHud.COORDS_COLOR, true);

	}

	public void renderFPS() {
		FontRenderer frender = Minecraft.getMinecraft().fontRendererObj;
		int fps = mc.getDebugFPS();
		String sfps = Integer.toString(fps);
		frender.drawString("FPS: " + sfps, 5, 35, CustomHud.FPS_COLOR, true);
	}

	public boolean fpsOnly() {
		return !CustomHud.coordsEnabled && CustomHud.fpsEnabled;
	}

}
