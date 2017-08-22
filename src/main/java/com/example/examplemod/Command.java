package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.EnumChatFormatting;
import sun.awt.image.PNGImageDecoder.Chromaticities;

public class Command extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "customhud";
	}

	public int getRequiredPermissionLevel() {
		return 0;
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "customhud";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		if (args[0].equalsIgnoreCase("coords") && args[1].equalsIgnoreCase("setcolor")) {
			if (args[2].equalsIgnoreCase("aqua")) {
				CustomHud.COORDS_COLOR = 0xFFFF;
			} else if (args[2].equalsIgnoreCase("white")) {
				CustomHud.COORDS_COLOR = 0xFFFFFF;
			}

		}

		else if (args[0].equalsIgnoreCase("fps") && args[1].equalsIgnoreCase("setcolor")) {

			if (args[2].equalsIgnoreCase("black")) {
				CustomHud.FPS_COLOR = 0x000000;
			} else if (args[2].equalsIgnoreCase("dark_blue")) {
				CustomHud.FPS_COLOR = 0x000080;
			} else if (args[2].equalsIgnoreCase("dark_green")) {
				CustomHud.FPS_COLOR = 0x00FF00;
			} else if (args[2].equalsIgnoreCase("dark_aqua")) {
				CustomHud.FPS_COLOR = 0x00aaaa;
			} else if (args[2].equalsIgnoreCase("dark_red")) {
				CustomHud.FPS_COLOR = 0xaa0000;
			} else if (args[2].equalsIgnoreCase("dark_purple")) {
				CustomHud.FPS_COLOR = 0xaa00aa;
			} else if (args[2].equalsIgnoreCase("gold")) {
				CustomHud.FPS_COLOR = 0xffaa00;
			} else if (args[2].equalsIgnoreCase("gray")) {
				CustomHud.FPS_COLOR = 0xAAAAAA;
			} else if (args[2].equalsIgnoreCase("dark_gray")) {
				CustomHud.FPS_COLOR = 0x555555;
			} else if (args[2].equalsIgnoreCase("blue")) {
				CustomHud.FPS_COLOR = 0x5555FF;
			}
			
		}

	}

}
