package de.teccheck.logiledmod;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.ibm.icu.impl.ICUService.Key;
import com.logitech.gaming.LogiLED;

import de.teccheck.logiledmod.config.Configs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.stats.IStatStringFormat;
import net.minecraftforge.client.event.GuiOpenEvent;

public class MainController {

	static ArrayList<String> test1 = new ArrayList<>();

	public static boolean isStarted = false;

	public static KeyboardController mainKeyboardController = null;
	public static KeyboardController chatKeyboardController = null;

	public static boolean isChat = false;

	private static GuiScreen currentScreen = null;

	public static int oldSlot = 1;
	private static int activeHealth;
	private static int activeGoldHealth;

	public static long hitTime = 0;
	public static boolean isHit = false;

	public static String[] mainControlKeys = null;
	public static String[] secondaryControlKeys = null;

	public static String[] secondaryChatKeys = { "ESC", "LEFT_ALT", "TAB", "CAPS_LOCK", "LEFT_SHIFT", "LEFT_CONTROL",
			"LEFT_WINDOWS", "", "RIGHT_WINDOWS", "APPLICATION_SELECT", "RIGHT_CONTROL", "RIGHT_SHIFT", "ENTER",
			"BACKSPACE", "EQUALS", "MINUS", "ZERO", "NINE", "EIGHT", "SEVEN", "SIX", "FIVE", "FOUR", "THREE", "TWO",
			"ONE", "TILDE", "SPACE", "RIGHT_ALT" };
	public static String[] primaryChatKeys = { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "OPEN_BRACKET",
			"CLOSE_BRACKET", "HASHTAG", "APOSTROPHE", "SEMICOLON", "L", "J", "K", "G", "H", "F", "D", "S", "A",
			"ANGLE_BRACKETS", "Z", "X", "C", "V", "B", "N", "M", "COMMA", "FORWARD_SLASH", "PERIOD" };

	public static void updateConfig() {
		// applies the config
		if (isStarted) {
			setMouse(Settings.MouseColor, Settings.useMouse);
			mainKeyboardController.setAll(Settings.BackgroundRGB.r, Settings.BackgroundRGB.g, Settings.BackgroundRGB.b,
					true);
			getKeybindings();
			setupKeysMain();
			setupSlots(Settings.ActiveSlotRGB, Settings.DisabledSlotRGB);
			setHealth(20, Settings.FullHeartRGB, Settings.HalfHeartRGB, Settings.OffHeartRGB);
			setGoldHealth(4, Settings.FullGoldHeartRGB, Settings.HalfHeartRGB, Settings.OffHeartRGB);
			mainKeyboardController.forceWriteAllToKeys();
		}
	}

	public static void update() {
		// executed every tick (from the Event Class)
		if (isHit) {
			if (hitTime < System.currentTimeMillis() - Settings.flashTimeMillis) {
				isHit = false;
				if (isChat)
					chatKeyboardController.forceWriteAllToKeys();
				else
					mainKeyboardController.forceWriteAllToKeys();
			}
		} else {
			if (isChat) {
				pressedKeys();

				// last thing to do
				chatKeyboardController.writeAllToKeys();
			} else {
				setSlot(Minecraft.getMinecraft().thePlayer.inventory.currentItem, Settings.ActiveSlotRGB,
						Settings.DisabledSlotRGB);
				setHealth((int) Minecraft.getMinecraft().thePlayer.getHealth(), Settings.FullHeartRGB,
						Settings.HalfHeartRGB, Settings.OffHeartRGB);
				setGoldHealth((int) Minecraft.getMinecraft().thePlayer.getAbsorptionAmount(), Settings.FullGoldHeartRGB,
						Settings.HalfGoldHeartRGB, Settings.OffHeartRGB);
				pressedKeys();

				// last thing to do
				mainKeyboardController.writeAllToKeys();
			}
		}
	}

	public static void start() {
		// executed on start (if the game reaches the Main
		// Menu the first time <-- does the GuiOpen method)
		LogiLED.LogiLedInit();
		LogiLED.LogiLedSetTargetDevice(LogiLED.LOGI_DEVICETYPE_PERKEY_RGB);

		startMainLayout();
		startChatLayout();
		setMouse(Settings.MouseColor, Settings.useMouse);

		isChat = false;

		// last thing to do
		mainKeyboardController.forceWriteAllToKeys();
		isStarted = true;
	}

	public static void guiOpen(GuiOpenEvent event) {
		if (event.gui != null) {
			if (event.gui instanceof GuiMainMenu && currentScreen == null) {
				// when the Main Menu is first opened
				start();
			} else if (event.gui instanceof GuiChat) {
				// Chat window was opened
				isChat = true;
				chatKeyboardController.forceWriteAllToKeys();
			} else if (event.gui instanceof GuiOptions && currentScreen instanceof GuiControls) {
				// save an apply configs
				Configs.SaveConfigSettings();
			}
		} else {
			if (currentScreen instanceof GuiChat) {
				// Chat window was closed
				isChat = false;
				mainKeyboardController.forceWriteAllToKeys();
			}
		}
		currentScreen = event.gui;
	}

	public static void hit() {
		// if the player was hit
		hitTime = System.currentTimeMillis();
		isHit = true;
		LogiLED.LogiLedSetLighting(Settings.FlashRGB.r, Settings.FlashRGB.g, Settings.FlashRGB.b);
	}

	public static void startMainLayout() {
		// init for the main light layout
		isChat = false;
		mainKeyboardController = new KeyboardController(Utils.getKeys());
		mainKeyboardController.setAll(Settings.BackgroundRGB.r, Settings.BackgroundRGB.g, Settings.BackgroundRGB.b,
				true);
		getKeybindings();
		setupKeysMain();
		setupSlots(Settings.ActiveSlotRGB, Settings.DisabledSlotRGB);
		setHealth(20, Settings.FullHeartRGB, Settings.HalfHeartRGB, Settings.OffHeartRGB);
		setGoldHealth(4, Settings.FullGoldHeartRGB, Settings.HalfHeartRGB, Settings.OffHeartRGB);
	}

	public static void startChatLayout() {
		// init for the chat layout
		isChat = true;
		chatKeyboardController = new KeyboardController(Utils.getKeys());
		chatKeyboardController.setAll(Settings.BackgroundRGB.r, Settings.BackgroundRGB.g, Settings.BackgroundRGB.b,
				true);
		for (String s : secondaryChatKeys) {
			chatKeyboardController.set(s, Settings.ChatRGBSec.r, Settings.ChatRGBSec.g, Settings.ChatRGBSec.b, true);
			chatKeyboardController.setChanged(s, true);
		}
		for (String s : primaryChatKeys) {
			chatKeyboardController.set(s, Settings.ChatRGBPrim.r, Settings.ChatRGBPrim.g, Settings.ChatRGBPrim.b, true);
			chatKeyboardController.setChanged(s, true);
		}

	}

	public static void pressedKeys() {
		// lights the pressed keys with a different color

		int i = 0;

		while (i <= 223) {
			if (Keyboard.isKeyDown(i)) {
				mainKeyboardController.setEnabled(Utils.getLogiName(i), false);
				chatKeyboardController.setEnabled(Utils.getLogiName(i), false);
			} else {
				mainKeyboardController.setEnabled(Utils.getLogiName(i), true);
				chatKeyboardController.setEnabled(Utils.getLogiName(i), true);
			}
			i++;
		}
	}

	public static void getKeybindings() {
		// gets all the keys that are in keybindings

		GameSettings gs = Minecraft.getMinecraft().gameSettings;
		KeyBinding[] keyBindings = gs.keyBindings;
		mainControlKeys = new String[6];
		secondaryControlKeys = new String[keyBindings.length - mainControlKeys.length];

		int i = 0;

		for (KeyBinding b : keyBindings) {
			if (b.getKeyDescription().equals("key.jump")) {
				mainControlKeys[0] = Utils.getLogiName(b.getKeyCode());
			} else if (b.getKeyDescription().equals("key.forward")) {
				mainControlKeys[1] = Utils.getLogiName(b.getKeyCode());
			} else if (b.getKeyDescription().equals("key.left")) {
				mainControlKeys[2] = Utils.getLogiName(b.getKeyCode());
			} else if (b.getKeyDescription().equals("key.back")) {
				mainControlKeys[3] = Utils.getLogiName(b.getKeyCode());
			} else if (b.getKeyDescription().equals("key.right")) {
				mainControlKeys[4] = Utils.getLogiName(b.getKeyCode());
			} else if (b.getKeyDescription().equals("key.sneak")) {
				mainControlKeys[5] = Utils.getLogiName(b.getKeyCode());
			} else {
				secondaryControlKeys[i] = Utils.getLogiName(b.getKeyCode());
				i++;
			}
		}

	}

	public static void setMouse(RGB color, boolean enabled) {
		// sets the mouse color if enabled
		if (enabled) {
			LogiLED.LogiLedSetTargetDevice(LogiLED.LOGI_DEVICETYPE_RGB);
			LogiLED.LogiLedSetLightingForTargetZone(LogiLED.DeviceType_Mouse, 0, color.r, color.g, color.b);
		}
		LogiLED.LogiLedSetTargetDevice(LogiLED.LOGI_DEVICETYPE_PERKEY_RGB);
	}

	public static void setupKeysMain() {
		// lights up all keys in keybindings
		for (String s : secondaryControlKeys) {
			mainKeyboardController.setColor(s, Settings.UseRGB.r, Settings.UseRGB.g, Settings.UseRGB.b);
		}
		// Lights up the main control keys (like wasd, space and shift)
		for (String s : mainControlKeys) {
			mainKeyboardController.setColor(s, Settings.WasdRGB.r, Settings.WasdRGB.g, Settings.WasdRGB.b);
		}
	}

	public static void setupSlots(RGB Argb, RGB Drgb) {
		// lights the keys 1 to 9 like when the player uses slot 1
		mainKeyboardController.setColor(Utils.getKeyName(1), Argb.r, Argb.g, Argb.b);
		mainKeyboardController.setColor(Utils.getKeyName(2), Drgb.r, Drgb.g, Drgb.b);
		mainKeyboardController.setColor(Utils.getKeyName(3), Drgb.r, Drgb.g, Drgb.b);
		mainKeyboardController.setColor(Utils.getKeyName(4), Drgb.r, Drgb.g, Drgb.b);
		mainKeyboardController.setColor(Utils.getKeyName(5), Drgb.r, Drgb.g, Drgb.b);
		mainKeyboardController.setColor(Utils.getKeyName(6), Drgb.r, Drgb.g, Drgb.b);
		mainKeyboardController.setColor(Utils.getKeyName(7), Drgb.r, Drgb.g, Drgb.b);
		mainKeyboardController.setColor(Utils.getKeyName(8), Drgb.r, Drgb.g, Drgb.b);
		mainKeyboardController.setColor(Utils.getKeyName(9), Drgb.r, Drgb.g, Drgb.b);
	}

	public static void setHealth(int health, RGB FRGB, RGB HRGB, RGB OffRGB) {
		// sets the keys F1 to F10
		// if a heart is full the key gets the color of FRGB
		// if a heart is half the key gets the color of HRGB
		// if a heart is empty the key gets the color of OffRGB
		if (activeHealth != health) {

			final int r = FRGB.r;
			final int g = FRGB.g;
			final int b = FRGB.b;

			final int hR = HRGB.r;
			final int hG = HRGB.g;
			final int hB = HRGB.b;

			mainKeyboardController.setColor("F1", OffRGB.r, OffRGB.g, OffRGB.b);
			mainKeyboardController.setColor("F2", OffRGB.r, OffRGB.g, OffRGB.b);
			mainKeyboardController.setColor("F3", OffRGB.r, OffRGB.g, OffRGB.b);
			mainKeyboardController.setColor("F4", OffRGB.r, OffRGB.g, OffRGB.b);
			mainKeyboardController.setColor("F5", OffRGB.r, OffRGB.g, OffRGB.b);
			mainKeyboardController.setColor("F6", OffRGB.r, OffRGB.g, OffRGB.b);
			mainKeyboardController.setColor("F7", OffRGB.r, OffRGB.g, OffRGB.b);
			mainKeyboardController.setColor("F8", OffRGB.r, OffRGB.g, OffRGB.b);
			mainKeyboardController.setColor("F9", OffRGB.r, OffRGB.g, OffRGB.b);
			mainKeyboardController.setColor("F10", OffRGB.r, OffRGB.g, OffRGB.b);

			if (health == 0) {
				// nothing full
			} else {
				if (health >= 2) {
					mainKeyboardController.setColor("F1", r, g, b);

					if (health >= 4) {
						mainKeyboardController.setColor("F2", r, g, b);

						if (health >= 6) {
							mainKeyboardController.setColor("F3", r, g, b);

							if (health >= 8) {
								mainKeyboardController.setColor("F4", r, g, b);

								if (health >= 10) {
									mainKeyboardController.setColor("F5", r, g, b);

									if (health >= 12) {
										mainKeyboardController.setColor("F6", r, g, b);

										if (health >= 14) {
											mainKeyboardController.setColor("F7", r, g, b);

											if (health >= 16) {
												mainKeyboardController.setColor("F8", r, g, b);

												if (health >= 18) {
													mainKeyboardController.setColor("F9", r, g, b);

													if (health >= 20) {
														mainKeyboardController.setColor("F10", r, g, b);

													} else if (health == 19) {

														mainKeyboardController.setColor("F10", hR, hG, hB);
													}
												} else if (health == 17) {

													mainKeyboardController.setColor("F9", hR, hG, hB);
												}
											} else if (health == 15) {

												mainKeyboardController.setColor("F8", hR, hG, hB);
											}
										} else if (health == 13) {

											mainKeyboardController.setColor("F7", hR, hG, hB);
										}
									} else if (health == 11) {

										mainKeyboardController.setColor("F6", hR, hG, hB);
									}
								} else if (health == 9) {

									mainKeyboardController.setColor("F5", hR, hG, hB);
								}
							} else if (health == 7) {

								mainKeyboardController.setColor("F4", hR, hG, hB);
							}
						} else if (health == 5) {

							mainKeyboardController.setColor("F3", hR, hG, hB);
						}
					} else if (health == 3) {

						mainKeyboardController.setColor("F2", hR, hG, hB);
					}
				} else if (health == 1) {

					mainKeyboardController.setColor("F1", hR, hG, hB);
				}
			}
			activeHealth = health;
		}
	}

	public static void setGoldHealth(int health, RGB fullRGB, RGB halfRGB, RGB offRGB) {
		// like setHealth but with F11 an F12 for the golden hearts
		if (activeGoldHealth != health) {
			activeGoldHealth = health;
			if (health > 4)
				health = 4;

			switch (health) {
			case 0:
				mainKeyboardController.setColor("F11", offRGB.r, offRGB.g, offRGB.b);
				mainKeyboardController.setColor("F12", offRGB.r, offRGB.g, offRGB.b);
				break;
			case 1:
				mainKeyboardController.setColor("F11", halfRGB.r, halfRGB.g, halfRGB.b);
				mainKeyboardController.setColor("F12", offRGB.r, offRGB.g, offRGB.b);
				break;
			case 2:
				mainKeyboardController.setColor("F11", fullRGB.r, fullRGB.g, fullRGB.b);
				mainKeyboardController.setColor("F12", offRGB.r, offRGB.g, offRGB.b);
				break;
			case 3:
				mainKeyboardController.setColor("F11", fullRGB.r, fullRGB.g, fullRGB.b);
				mainKeyboardController.setColor("F12", halfRGB.r, halfRGB.g, halfRGB.b);
				break;
			case 4:
				mainKeyboardController.setColor("F11", fullRGB.r, fullRGB.g, fullRGB.b);
				mainKeyboardController.setColor("F12", fullRGB.r, fullRGB.g, fullRGB.b);
				break;
			}
		}
	}

	public static void setSlot(int slot, RGB Argb, RGB Drgb) {
		// sets the active slot to Argb and all others to Drgb
		slot++;
		if (slot != oldSlot) {
			mainKeyboardController.setColor(Utils.getKeyName(slot), Argb.r, Argb.g, Argb.b);
			mainKeyboardController.setColor(Utils.getKeyName(oldSlot), Drgb.r, Drgb.g, Drgb.b);
			oldSlot = slot;
		}
	}
}