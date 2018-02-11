package de.techeck.logiledmod;

import com.logitech.gaming.LogiLED;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Events {

	boolean init = true;

	/*
	 * @SubscribeEvent public void onLogin(PlayerLoggedInEvent event){
	 * 
	 * System.out.println("Player logginEvent");
	 * 
	 * if(event.player == Minecraft.getMinecraft().thePlayer) {
	 * System.out.println("player hast joined"); }
	 * 
	 * }
	 * 
	 */

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {

		if (event.player.worldObj.isRemote) {
			LED.setItemSlot(event.player.inventory.currentItem, Colors.ActiveSlotRGB, Colors.DisabledSlotRGB);
			LED.setHealth((int) event.player.getHealth(), Colors.FullRGB, Colors.HalfRGB, Colors.OffRGB);

		}

	}

	public void onClientTick(TickEvent.ClientTickEvent event) {
		int currentItem = Minecraft.getMinecraft().thePlayer.inventory.currentItem;

	}

	@SubscribeEvent
	public void onHome(GuiOpenEvent event) {
		if (init) {

			if (event.gui instanceof GuiMainMenu) {

				System.out.println("LED Mod Init " + (LogiLED.LogiLedInit() ? "Succesfull!" : "Failed!"));
				LogiLED.LogiLedSetTargetDevice(LogiLED.LOGI_DEVICETYPE_PERKEY_RGB);
				LogiLED.LogiLedSaveCurrentLighting();
				LogiLED.LogiLedSetLighting(0, 0, 0);

				RGB useRGB = Colors.useRGB;

				for (String key : LogiLEDMod.keys) {
					LogiLED.LogiLedSetLightingForKeyWithKeyName(LED.getKeyNumber(key), useRGB.R, useRGB.G, useRGB.B);
				}

				init = false;
				
				LED.makeNumbers(Colors.DisabledSlotRGB);
				LED.makeWASD(Colors.wasdRGB);
				LED.makeFKeys(Colors.FullRGB);
			}
		}
	}

}
