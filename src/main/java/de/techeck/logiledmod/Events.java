package de.techeck.logiledmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Events {

	/**
	 * @SubscribeEvent public void onLogin(PlayerLoggedInEvent event){
	 * 
	 *                 System.out.println("Player logginEvent");
	 * 
	 *                 if(event.player == Minecraft.getMinecraft().thePlayer) {
	 *                 System.out.println("player hast joined"); }
	 * 
	 *                 }
	 * 
	 **/

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {

		if (event.player.worldObj.isRemote) {
			LED.setItemSlot(event.player.inventory.currentItem, Colors.ActiveSlotRGB, Colors.DisabledSlotRGB);
			LED.setHealth((int) event.player.getHealth(), Colors.FullRGB, Colors.HalfRGB, Colors.OffRGB);
			//Minecraft.getMinecraft().gameSettings.
			
			
		}

	}

	public void onClientTick(TickEvent.ClientTickEvent event) {
		int currentItem = Minecraft.getMinecraft().thePlayer.inventory.currentItem;

	}

}
