package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;

public class MessagePinger {
	@EventHandler
	public void exdee(ClientChatReceivedEvent e) {
		String message = e.message.getUnformattedText();
		if(message.equals("From [")) {
			
		}
	}
	
}
