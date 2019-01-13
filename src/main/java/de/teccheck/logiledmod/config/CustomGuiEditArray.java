package de.teccheck.logiledmod.config;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjgl.input.Mouse;

import com.logitech.gaming.LogiLED;

import de.teccheck.logiledmod.RGB;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiEditArray;
import net.minecraftforge.fml.client.config.IConfigElement;

public class CustomGuiEditArray extends GuiEditArray {
	private ResourceLocation resourceLocation = new ResourceLocation("logiledmod", "textures/gui/ColorPicker.png");
	private BufferedImage colorPickImg;
	private Double colorPickRect;

	private GuiTextField red;
	private GuiTextField green;
	private GuiTextField blue;

	private int colorPickerX = 0;
	private int colorPickerY = 0;

	public CustomGuiEditArray(GuiScreen parentScreen, IConfigElement configElement, int slotIndex,
			Object[] currentValues, boolean enabled) {
		super(parentScreen, configElement, slotIndex, currentValues, enabled);
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		this.titleLine3 = "Preview is on the Keyboard";
		super.initGui();

		try {
			File classPathInput = new File(
					CustomGuiEditArray.class.getResource("/assets/logiledmod/textures/gui/ColorPicker.png").getFile());
			colorPickImg = ImageIO.read(classPathInput);
			if (colorPickImg != null)
				System.out.println("ImageFound");
			this.colorPickRect = new Rectangle2D.Double(0.0, 0.0, this.colorPickImg.getWidth(),
					this.colorPickImg.getHeight());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			red = (GuiTextField) FastReflection.superGetFieldValue(this.entryList.getListEntry(0), "textFieldValue");
			green = (GuiTextField) FastReflection.superGetFieldValue(this.entryList.getListEntry(1), "textFieldValue");
			blue = (GuiTextField) FastReflection.superGetFieldValue(this.entryList.getListEntry(2), "textFieldValue");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		red.setText(String.valueOf(currentValues[0]));
		green.setText(String.valueOf(currentValues[1]));
		blue.setText(String.valueOf(currentValues[2]));
		// System.out.println("x = " + height + " y = " + width);
	}

	/**
	 * Draws the screen and all the components in it. Args : mouseX, mouseY,
	 * renderPartialTicks
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		drawImage();
		getRGB(mouseX, mouseY);

	}

	@Override
	public void drawCenteredString(FontRenderer fontRendererIn, String text, int x, int y, int color) {
		if (text.equals(this.titleLine2)) {
			Integer r = (int) ((int) currentValues[0] * 2.55);
			Integer g = (int) ((int) currentValues[1] * 2.55);
			Integer b = (int) ((int) currentValues[2] * 2.55);
			Color rgb = new Color(r, g, b);
			color = rgb.getRGB();
		}
		super.drawCenteredString(fontRendererIn, text, x, y, color);
		// int i = fontRendererIn.drawStringWithShadow(text, (float) (x -
		// fontRendererIn.getStringWidth(text) / 2),(float) y, color);

	}

	@Override
	protected void actionPerformed(GuiButton button) {
		if (Integer.parseInt(red.getText()) > 100) {
			red.setText("100");
		} else if (Integer.parseInt(red.getText()) < 0) {
			red.setText("0");
		}
		if (Integer.parseInt(green.getText()) > 100) {
			green.setText("100");
		} else if (Integer.parseInt(green.getText()) < 0) {
			green.setText("0");
		}
		if (Integer.parseInt(blue.getText()) > 100) {
			blue.setText("100");
		} else if (Integer.parseInt(blue.getText()) < 0) {
			blue.setText("0");
		}
		super.actionPerformed(button);
	}

	void drawImage() {
		float scaleMultiplier = ((float) this.height) / 420f;
		int height = (int) (50 * scaleMultiplier);
		int ImageXres = (int) (128 * scaleMultiplier);
		int ImageYres = (int) (128 * scaleMultiplier);

		colorPickerX = this.width / 2 - ImageXres / 2;
		colorPickerY = this.height / 2 - ImageYres / 2 + height;

		if (resourceLocation != null) {
			Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation);
			this.drawModalRectWithCustomSizedTexture(colorPickerX, colorPickerY, 0, 0, ImageXres, ImageYres, ImageXres,
					ImageYres);
		}
	}

	protected void getRGB(final int mouseX, final int mouseY) {
		final int x = mouseX - colorPickerX - (int) this.colorPickRect.x;
		final int y = mouseY - colorPickerY - (int) this.colorPickRect.y;
		if (x >= 0 && y >= 0 && this.colorPickRect.contains(x, y) && Mouse.isButtonDown(0)) {

			int[] rgb = RGB.ints(this.colorPickImg.getRGB(x, y));
			double r = rgb[0] / 2.55;
			double g = rgb[1] / 2.55;
			double b = rgb[2] / 2.55;
			red.setText(String.valueOf((int) r));
			green.setText(String.valueOf((int) g));
			blue.setText(String.valueOf((int) b));

			LogiLED.LogiLedSetLighting((int) r, (int) g, (int) b);

		}
	}
}
