package com.example.examplemod;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiButtonExt;

public class Gui extends GuiScreen {

	boolean toggle = true;

	public GuiButton button1;
	public GuiButton button2;

	String message = "test";

	public void updateButtons() {
		if (toggle == true) {
			button1.displayString = "Disable FPS";
			button2.displayString = "Disable Coords";
		} else {
			button1.displayString = "Enable FPS";
			button2.displayString = "Enable Coords";
		}
	

	}

	@Override
	public void initGui() {
		buttonList.clear();
		button1 = new GuiButton(0, 10, 10, 100, 20, "");
		button2 = new GuiButton(1, 10, 35, 100, 20, "");
		buttonList.add(button1);
		buttonList.add(button2);
		super.initGui();

	}

	@Override
	public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
		drawDefaultBackground();
		updateScreen();
		updateButtons();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id == 0) {
			if(CustomHud.fpsEnabled) {
				CustomHud.fpsEnabled = false;
			} else {
				CustomHud.fpsEnabled = true;
			}
			updateScreen();
			updateButtons();
			
		}	
		
		if (button.id == 1) {
			if(CustomHud.coordsEnabled) {
				CustomHud.coordsEnabled = false;
			} else {
				CustomHud.coordsEnabled = true;
			}
			updateScreen();
			updateButtons();
			
		}

		super.actionPerformed(button);
	}
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
