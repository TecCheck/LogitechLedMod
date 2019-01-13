package de.teccheck.logiledmod.config;

import java.awt.Color;
import java.util.Arrays;

import de.teccheck.logiledmod.RGB;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.GuiConfigEntries.ArrayEntry;
import net.minecraftforge.fml.client.config.GuiConfigEntries.IConfigEntry;
import net.minecraftforge.fml.client.config.IConfigElement;

public class CustomGuiConfigArrayEntry extends ArrayEntry {

	public CustomGuiConfigArrayEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList,
			IConfigElement configElement) {
		super(owningScreen, owningEntryList, configElement);
	}

	public static CustomGuiConfigArrayEntry fromSuperClass(IConfigEntry entry) {

		if (!(entry instanceof CustomGuiConfigArrayEntry)) {
			GuiConfig owningScreen = null;
			GuiConfigEntries owningEntryList = null;
			IConfigElement configElement = null;
			try {

				owningScreen = (GuiConfig) FastReflection.superSuperGetFieldValue(entry, "owningScreen");
				owningEntryList = (GuiConfigEntries) FastReflection.superSuperGetFieldValue(entry, "owningEntryList");
				configElement = (IConfigElement) FastReflection.superSuperGetFieldValue(entry, "configElement");
				// configElement = entry.getConfigElement();
				return new CustomGuiConfigArrayEntry(owningScreen, owningEntryList, configElement);

			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			if (owningScreen != null && owningEntryList != null && configElement != null) {
				return new CustomGuiConfigArrayEntry(owningScreen, owningEntryList, configElement);
			}
		}
		return null;
	}

	@Override
	public void valueButtonPressed(int slotIndex) {
		mc.displayGuiScreen(
				new CustomGuiEditArray(this.owningScreen, configElement, slotIndex, currentValues, enabled()));
	}

	@Override
	public void updateValueButtonText() {
		super.updateValueButtonText();
		Integer r = (int) ((int) currentValues[0] * 2.55);
		Integer g = (int) ((int) currentValues[1] * 2.55);
		Integer b = (int) ((int) currentValues[2] * 2.55);
		Color color = new Color(r, g, b);
		this.btnValue.packedFGColour = color.getRGB();
	}

}
