package de.techeck.logiledmod;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LogiLEDMod.MODID, name = LogiLEDMod.NAME, version = LogiLEDMod.VERSION)
public class LogiLEDMod {
	public static final String MODID = "logiledmod";
	public static final String VERSION = "0.4";
	public static final String NAME = "LogiLEDMod";

	public static ArrayList<String> keys = new ArrayList<>();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new Events());
		FMLCommonHandler.instance().bus().register(new Events());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		GameSettings gs = Minecraft.getMinecraft().gameSettings;

		KeyBinding[] keyBindings = gs.keyBindings;

		for (KeyBinding keyBinding : keyBindings) {
			int code = keyBinding.getKeyCode();

			if (code > 0) {
				System.out.println(keyBinding.getKeyDescription() + ": " + keyBinding.getKeyCode() + ": "
						+ Keyboard.getKeyName(code));
				keys.add(Keyboard.getKeyName(code));

			}
		}
		System.out.println("lenght: " + keyBindings.length);
	}
}
