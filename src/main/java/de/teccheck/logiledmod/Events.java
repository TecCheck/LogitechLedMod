package de.teccheck.logiledmod;

import com.logitech.gaming.LogiLED;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.chunk.Chunk.EnumCreateEntityType;
import net.minecraftforge.client.event.GuiOpenEvent;

public class Events {

	@SubscribeEvent
	public void onPlayerHurt(LivingHurtEvent event) {
		if (event.entity instanceof EntityPlayerMP) {
			MainController.hit();
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		MainController.update();
	}

	@SubscribeEvent
	public void onGuiOpen(GuiOpenEvent event) {
		MainController.guiOpen(event);
	}
}