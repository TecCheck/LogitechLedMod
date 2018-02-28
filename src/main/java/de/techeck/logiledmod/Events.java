package de.techeck.logiledmod;

import com.logitech.gaming.LogiLED;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Events {

	@SubscribeEvent
	public void onPlayerHurt(LivingHurtEvent event) {

		if (event.entity instanceof EntityPlayer) {
			int hurtTime = event.entityLiving.maxHurtTime;
			hurtTime *= 20;
			LED.playerHit(Colors.Flash, hurtTime, hurtTime - 1);
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {

		if (event.player.worldObj.isRemote) {
			LED.setItemSlot(event.player.inventory.currentItem, Colors.ActiveSlotRGB, Colors.DisabledSlotRGB);
			LED.setHealth((int) event.player.getHealth(), Colors.FullHeartRGB, Colors.HalfHeartRGB, Colors.OffHeartRGB);
			LED.setGoldHealth((int) event.player.getAbsorptionAmount(), Colors.FullGoldHeartRGB,
					Colors.HalfGoldHeartRGB, Colors.OffHeartRGB);

		}

	}

	@SubscribeEvent
	public void onGuiOpen(GuiOpenEvent event) {
		if (event.gui != null) {

			if (LED.init) {
				LED.initLED(event);
			} else if (event.gui instanceof GuiChat) {
				LED.onChatOpen();
				LED.lastGui = event.gui;
			}

		} else {
			if (LED.lastGui instanceof GuiChat) {
				LED.onChatClose();
			}
		}
	}

}
