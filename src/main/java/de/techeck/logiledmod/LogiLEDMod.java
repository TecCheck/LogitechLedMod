package de.techeck.logiledmod;

import java.lang.reflect.Field;
import java.util.Set;

import com.logitech.gaming.LogiLED;

import io.netty.util.internal.SystemPropertyUtil;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LogiLEDMod.MODID, version = LogiLEDMod.VERSION)
public class LogiLEDMod {
	public static final String MODID = "logiledmod";
	public static final String VERSION = "0.1";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		LogiLED.LogiLedInit();
		LogiLED.LogiLedSetTargetDevice(LogiLED.LOGI_DEVICETYPE_PERKEY_RGB);
		LogiLED.LogiLedSaveCurrentLighting();
		LogiLED.LogiLedSetLighting(0, 0, 0);

		LED.makeNumbers(Colors.DisabledSlotRGB);
		LED.makeWASD(Colors.wasdRGB);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new Events());
		FMLCommonHandler.instance().bus().register(new Events());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		// GameSettings.keyBindings[];
		
		GameSettings gs = new GameSettings();
		
		KeyBinding[] keyBindings = gs.keyBindings;
		
		KeyBinding keyBinding = keyBindings[0];
		
		System.out.println(keyBinding.getKeyDescription() + ": " + keyBinding.getKeyCode());
	}
}
