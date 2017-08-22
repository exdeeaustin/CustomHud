package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = CustomHud.MODID, version = CustomHud.VERSION)
public class CustomHud

{
	public static final String MODID = "examplemod";
	public static final String VERSION = "1.0";
	
	public static int FPS_COLOR = 0xFFFFFF;
	public static int COORDS_COLOR = 0xFFFF;
	public static boolean fpsEnabled;
	public static boolean coordsEnabled;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ClientCommandHandler.instance.registerCommand((ICommand) new Command());
		MinecraftForge.EVENT_BUS.register(new MessagePinger());
		MinecraftForge.EVENT_BUS.register(new Render());
		MinecraftForge.EVENT_BUS.register(new Gui());
		MinecraftForge.EVENT_BUS.register(this);
		FileHandler.loadSettings();

	}

	@SubscribeEvent
	public void xd(ClientChatReceivedEvent e ) {
		String message = e.message.getUnformattedText();
		if(message.contains("o")) {
			Minecraft.getMinecraft().displayGuiScreen(new Gui());
			
		}
	}
	static {
		CustomHud.fpsEnabled = true;
		CustomHud.coordsEnabled = true;
	}
}
