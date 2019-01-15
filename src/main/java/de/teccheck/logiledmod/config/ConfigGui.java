package de.teccheck.logiledmod.config;

import de.teccheck.logiledmod.LogiLEDMod;
import de.teccheck.logiledmod.MainController;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries.IConfigEntry;

public class ConfigGui extends GuiConfig {

	static ConfigElement configElement = new ConfigElement(Configs.config.getCategory(Configuration.CATEGORY_GENERAL));

	public ConfigGui(GuiScreen parent) {
		super(parent, configElement.getChildElements(), LogiLEDMod.MODID, false, false, LogiLEDMod.NAME);
		// titleLine2 = Configs.config.getConfigFile().getAbsolutePath();
	}

	@Override
	public void initGui() {
		super.initGui();
		// Replacing the default ArrayEntrys with my own to use a color picker
		replaceEntryList();
		// saving and applying configs
		Configs.SaveConfigSettings();
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		super.actionPerformed(button);
		// You can process any additional buttons you may have added here
		Configs.SaveConfigSettings();

	}

	void replaceEntryList() {
		int i = 0;
		System.out.println("entryList size: " + this.entryList.listEntries.size());
		System.out.println("entryList: " + this.entryList.listEntries);
		while (i < this.entryList.listEntries.size()) {
			IConfigEntry element = this.entryList.listEntries.get(i);
			System.out.println("element: " + element);
			System.out.println("elementName: " + element.getName());
			if (element instanceof net.minecraftforge.fml.client.config.GuiConfigEntries.ArrayEntry) {
				if (element.getConfigElement().getType().toString().equals("INTEGER")) {
					if (!(element instanceof CustomGuiConfigArrayEntry)) {
						CustomGuiConfigArrayEntry conf = CustomGuiConfigArrayEntry.fromSuperClass(element);
						this.entryList.listEntries.set(i, conf);
						System.out.println("initEntrys nr." + i + " = " + this.entryList.listEntries.get(i)
								+ " ElementClass:" + this.entryList.listEntries.get(i).getConfigElement().getClass());
					}
				}
			}
			i++;
		}
	}
}
