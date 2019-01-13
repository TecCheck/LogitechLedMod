package de.teccheck.logiledmod.config;

import java.io.File;

import de.teccheck.logiledmod.MainController;
import de.teccheck.logiledmod.Settings;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Configs {
	public static final String CATEGORY_GENERAL = Configuration.CATEGORY_GENERAL;
	public static Configuration config = null;

	private static Property BackgroundRGBProp;
	private static Property ActiveSlotRGBProp;
	private static Property MouseRGBProp;
	private static Property DisabledSlotRGBProp;
	private static Property FullHeartRGBProp;
	private static Property HalfHeartRGBProp;
	private static Property OffHeartRGBProp;
	private static Property FullGoldHeartRGBProp;
	private static Property HalfGoldHeartRGBProp;
	private static Property WasdRGBProp;
	private static Property UseRGBProp;
	private static Property ChatPrimRGBProp;
	private static Property ChatSecRGBProp;
	private static Property FlashRGBProp;
	private static Property PressedKeysRGBProp;
	private static Property flashTimeProperty;
	private static Property useMouseProperty;

	public static boolean unfinishedFeatures = false;

	public static void LoadConfigSettings(File configFile) {
		ReadConfigSettings(configFile, true);
	}

	public static void SaveConfigSettings() {
		ReadConfigSettings(null, false);
		applyConfigs();
	}

	/**
	 * Creates the config file if it doesn't already exist. It loads/saves config
	 * values from/to the config file.
	 * 
	 * @param configFile
	 *            Standard Forge configuration file
	 * @param loadSettings
	 *            set to true to load the settings from the config file, or false to
	 *            save the settings to the config file
	 */
	public static void ReadConfigSettings(File configFile, boolean loadSettings) {
		// Configuration config = null;
		if (loadSettings) {
			config = new Configuration(configFile);
			config.load();
			BackgroundRGBProp = config.get(Configuration.CATEGORY_GENERAL, "BackgroundRGB",
					Settings.BackgroundRGB.toIntegerArray(), "Color for the Background").setIsListLengthFixed(true);
			ActiveSlotRGBProp = config.get(Configuration.CATEGORY_GENERAL, "ActiveSlotRGB",
					Settings.ActiveSlotRGB.toIntegerArray(), "Color for the active Slot").setIsListLengthFixed(true);
			DisabledSlotRGBProp = config.get(Configuration.CATEGORY_GENERAL, "DisabledSlotRGB",
					Settings.DisabledSlotRGB.toIntegerArray(), "Color for non used Slots").setIsListLengthFixed(true);
			MouseRGBProp = config.get(Configuration.CATEGORY_GENERAL, "MouseRGB", Settings.MouseColor.toIntegerArray(),
					"Color for the Mouse").setIsListLengthFixed(true);
			FullHeartRGBProp = config.get(Configuration.CATEGORY_GENERAL, "FullHeartRGB",
					Settings.FullHeartRGB.toIntegerArray(), "Color for the full hears").setIsListLengthFixed(true);
			HalfHeartRGBProp = config.get(Configuration.CATEGORY_GENERAL, "HalfHeartRGB",
					Settings.HalfHeartRGB.toIntegerArray(), "Color for the half hears").setIsListLengthFixed(true);
			OffHeartRGBProp = config.get(Configuration.CATEGORY_GENERAL, "OffHeartRGB",
					Settings.OffHeartRGB.toIntegerArray(), "Color for the empty hears").setIsListLengthFixed(true);
			FullGoldHeartRGBProp = config.get(Configuration.CATEGORY_GENERAL, "FullGoldHeartRGB",
					Settings.FullGoldHeartRGB.toIntegerArray(), "Color for the full gold hears")
					.setIsListLengthFixed(true);
			HalfGoldHeartRGBProp = config.get(Configuration.CATEGORY_GENERAL, "HalfGoldHeartRGB",
					Settings.HalfGoldHeartRGB.toIntegerArray(), "Color for the half hears").setIsListLengthFixed(true);
			WasdRGBProp = config.get(Configuration.CATEGORY_GENERAL, "WasdRGB", Settings.WasdRGB.toIntegerArray(),
					"Color for the main control keys (like wasd)").setIsListLengthFixed(true);
			UseRGBProp = config.get(Configuration.CATEGORY_GENERAL, "UseRGB", Settings.UseRGB.toIntegerArray(),
					"Color for all keys with keybindings").setIsListLengthFixed(true);
			ChatPrimRGBProp = config.get(Configuration.CATEGORY_GENERAL, "PrimChatRGB",
					Settings.ChatRGBPrim.toIntegerArray(), "Normal keys for the chat").setIsListLengthFixed(true);
			ChatSecRGBProp = config.get(Configuration.CATEGORY_GENERAL, "SecChatRGB",
					Settings.ChatRGBPrim.toIntegerArray(), "special keys for the chat").setIsListLengthFixed(true);
			FlashRGBProp = config.get(Configuration.CATEGORY_GENERAL, "FlashRGB", Settings.FlashRGB.toIntegerArray(),
					"Color for the Blink").setIsListLengthFixed(true);
			PressedKeysRGBProp = config.get(Configuration.CATEGORY_GENERAL, "PreesedKeysRGB",
					Settings.PressedKeysRGB.toIntegerArray(), "Color for pressed Keys").setIsListLengthFixed(true);
			flashTimeProperty = config.get(Configuration.CATEGORY_GENERAL, "FlashTime", Settings.flashTimeMillis,
					"Blink Time in millis");
			useMouseProperty = config.get(Configuration.CATEGORY_GENERAL, "UseMouse", Settings.useMouse, "Use Mouse?");
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Save props to config if config changed
			if (config.hasChanged())
				config.save();
		}
	}

	public static void applyConfigs() {
		System.out.println("applying configs");
		Settings.BackgroundRGB.fromIntegerArray(BackgroundRGBProp.getIntList());
		Settings.ActiveSlotRGB.fromIntegerArray(ActiveSlotRGBProp.getIntList());
		Settings.MouseColor.fromIntegerArray(MouseRGBProp.getIntList());
		Settings.DisabledSlotRGB.fromIntegerArray(DisabledSlotRGBProp.getIntList());
		Settings.FullHeartRGB.fromIntegerArray(FullHeartRGBProp.getIntList());
		Settings.HalfHeartRGB.fromIntegerArray(HalfHeartRGBProp.getIntList());
		Settings.OffHeartRGB.fromIntegerArray(OffHeartRGBProp.getIntList());
		Settings.FullGoldHeartRGB.fromIntegerArray(FullGoldHeartRGBProp.getIntList());
		Settings.HalfGoldHeartRGB.fromIntegerArray(HalfGoldHeartRGBProp.getIntList());
		Settings.WasdRGB.fromIntegerArray(WasdRGBProp.getIntList());
		Settings.UseRGB.fromIntegerArray(UseRGBProp.getIntList());
		Settings.ChatRGBPrim.fromIntegerArray(ChatPrimRGBProp.getIntList());
		Settings.FlashRGB.fromIntegerArray(FlashRGBProp.getIntList());
		Settings.PressedKeysRGB.fromIntegerArray(PressedKeysRGBProp.getIntList());
		Settings.flashTimeMillis = flashTimeProperty.getInt();
		Settings.useMouse = useMouseProperty.getBoolean();

		MainController.updateConfig();
	}
}
