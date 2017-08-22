package com.example.examplemod;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;

import net.minecraft.client.Minecraft;

public class FileHandler {
	public static void loadSettings() {
		final File settings = new File(new File(Minecraft.getMinecraft().mcDataDir.getPath() + "/mods/CustomHud"),
				"customhud.settings");
		try {
			if (!settings.getParentFile().exists()) {
				settings.getParentFile().mkdir();
			}
			if (settings.createNewFile()) {
				return;
			}
			if (!settings.exists()) {
				return;
			}
			final BufferedReader reader = new BufferedReader(new FileReader(settings));
			final String[] options = reader.readLine().split(":");
			CustomHud.fpsEnabled = Boolean.valueOf(options[0]);
			CustomHud.coordsEnabled = Boolean.valueOf(options[1]);
			
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (NullPointerException e3) {
			e3.printStackTrace();
		}
	}

	public static void saveSettings() {
		final File settings = new File(new File(Minecraft.getMinecraft().mcDataDir.getPath() + "/mods/CustomHud"),
				"customhud.settings");
		try {
			final BufferedWriter writer = new BufferedWriter(new FileWriter(settings));
			writer.write(CustomHud.fpsEnabled + ":" + CustomHud.coordsEnabled);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
