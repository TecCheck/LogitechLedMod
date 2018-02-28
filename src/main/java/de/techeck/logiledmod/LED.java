package de.techeck.logiledmod;

import com.logitech.gaming.LogiLED;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiOpenEvent;

public class LED {

	public static int activeSlot = 0;
	public static int activeHealth = 0;
	public static int activeGoldHealth = 0;

	static boolean init = true;
	static boolean chatOpen = false;
	static GuiScreen lastGui = null;

	public static void initLED(GuiOpenEvent event) {
		if (event.gui instanceof GuiMainMenu) {

			System.out.println("LED Mod Init " + (LogiLED.LogiLedInit() ? "Succesfull!" : "Failed!"));
			LogiLED.LogiLedSetTargetDevice(LogiLED.LOGI_DEVICETYPE_PERKEY_RGB);
			LogiLED.LogiLedSetLighting(Colors.BackgroundRGB.R, Colors.BackgroundRGB.G, Colors.BackgroundRGB.B);

			makeUsedKeys(Colors.UseRGB);
			makeNumbers(Colors.DisabledSlotRGB);
			makeGoldHealth(Colors.OffHeartRGB);
			makeWASD(Colors.WasdRGB);
			makeFKeys(Colors.FullHeartRGB);
			LogiLED.LogiLedSaveCurrentLighting();

			init = false;
		}
	}

	public static void onChatOpen() {
		if (!chatOpen) {
			LogiLED.LogiLedSaveCurrentLighting();
			System.out.println("Chat opened!!");
			chatOpen = true;
			makeChat(Colors.ChatRGB, Colors.BackgroundRGB);

		}

	}

	public static void onChatClose() {
		if (chatOpen) {
			System.out.println("Chat closed!!");
			System.out.println("Light " + (LogiLED.LogiLedRestoreLighting() ? "restored!" : "not restored!"));

			/*
			 * LogiLED.LogiLedSetLighting(0, 0, 0); makeNumbers(Colors.DisabledSlotRGB);
			 * makeGoldHealth(Colors.OffHeartRGB); makeWASD(Colors.WasdRGB);
			 * makeFKeys(Colors.FullHeartRGB);
			 */
			chatOpen = false;
			updateKeys();
		}
	}

	public static void updateKeys() {
		System.out.println("Keyupdate");
		LED.setItemSlot(Minecraft.getMinecraft().thePlayer.inventory.currentItem, Colors.ActiveSlotRGB,
				Colors.DisabledSlotRGB);
		LED.setHealth((int) Minecraft.getMinecraft().thePlayer.getHealth(), Colors.FullHeartRGB, Colors.HalfHeartRGB,
				Colors.OffHeartRGB);
		LED.setGoldHealth((int) Minecraft.getMinecraft().thePlayer.getAbsorptionAmount(), Colors.FullGoldHeartRGB,
				Colors.HalfGoldHeartRGB, Colors.OffHeartRGB);
	}

	public static void playerHit(RGB color, int duration, int interval) {
		LogiLED.LogiLedFlashLighting(color.R, color.G, color.B, duration, interval);
	}

	public static void makeWASD(RGB rgb) {
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.W, rgb.R, rgb.G, rgb.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.A, rgb.R, rgb.G, rgb.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.S, rgb.R, rgb.G, rgb.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.D, rgb.R, rgb.G, rgb.B);
	}

	public static void makeNumbers(RGB rgb) {
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.ONE, rgb.R, rgb.G, rgb.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.TWO, rgb.R, rgb.G, rgb.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.THREE, rgb.R, rgb.G, rgb.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.FOUR, rgb.R, rgb.G, rgb.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.FIVE, rgb.R, rgb.G, rgb.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.SIX, rgb.R, rgb.G, rgb.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.SEVEN, rgb.R, rgb.G, rgb.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.EIGHT, rgb.R, rgb.G, rgb.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.NINE, rgb.R, rgb.G, rgb.B);
		activeSlot = 0;
	}

	public static void makeFKeys(RGB FKeyRGB) {
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F1, FKeyRGB.R, FKeyRGB.G, FKeyRGB.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F2, FKeyRGB.R, FKeyRGB.G, FKeyRGB.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F3, FKeyRGB.R, FKeyRGB.G, FKeyRGB.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F4, FKeyRGB.R, FKeyRGB.G, FKeyRGB.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F5, FKeyRGB.R, FKeyRGB.G, FKeyRGB.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F6, FKeyRGB.R, FKeyRGB.G, FKeyRGB.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F7, FKeyRGB.R, FKeyRGB.G, FKeyRGB.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F8, FKeyRGB.R, FKeyRGB.G, FKeyRGB.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F9, FKeyRGB.R, FKeyRGB.G, FKeyRGB.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F10, FKeyRGB.R, FKeyRGB.G, FKeyRGB.B);
		activeHealth = 0;
	}

	public static void makeGoldHealth(RGB color) {
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F11, color.R, color.G, color.B);
		LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F12, color.R, color.G, color.B);
		activeGoldHealth = 0;
	}

	public static void makeChat(RGB color, RGB back) {

		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		char[] abcArray = abc.toCharArray();

		LogiLED.LogiLedSetLighting(back.R, back.G, back.B);

		for (char ch : abcArray) {
			LogiLED.LogiLedSetLightingForKeyWithKeyName(getKeyNumber(String.valueOf(ch)), color.R, color.G, color.B);
		}

	}

	public static void makeUsedKeys(RGB color) {
		for (String key : LogiLEDMod.keys) {
			LogiLED.LogiLedSetLightingForKeyWithKeyName(getKeyNumber(key), color.R, color.G, color.B);
		}
	}

	public static void setItemSlot(int slot, RGB Argb, RGB Drgb) {
		slot++;

		if (slot != activeSlot && slot > 0) {
			if (activeSlot == 0) {
				activeSlot = slot;
			}

			LogiLED.LogiLedSetLightingForKeyWithKeyName(getKeyNumber(String.valueOf(activeSlot)), Drgb.R, Drgb.G,
					Drgb.B);
			LogiLED.LogiLedSetLightingForKeyWithKeyName(getKeyNumber(String.valueOf(slot)), Argb.R, Argb.G, Argb.B);
			activeSlot = slot;
		}
	}

	public static void setHealth(int health, RGB FRGB, RGB HRGB, RGB OffRGB) {

		if (activeHealth != health) {

			final int r = FRGB.R;
			final int g = FRGB.G;
			final int b = FRGB.B;

			final int hR = HRGB.R;
			final int hG = HRGB.G;
			final int hB = HRGB.B;

			System.out.println(health);

			LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F1, OffRGB.R, OffRGB.G, OffRGB.B);
			LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F2, OffRGB.R, OffRGB.G, OffRGB.B);
			LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F3, OffRGB.R, OffRGB.G, OffRGB.B);
			LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F4, OffRGB.R, OffRGB.G, OffRGB.B);
			LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F5, OffRGB.R, OffRGB.G, OffRGB.B);
			LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F6, OffRGB.R, OffRGB.G, OffRGB.B);
			LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F7, OffRGB.R, OffRGB.G, OffRGB.B);
			LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F8, OffRGB.R, OffRGB.G, OffRGB.B);
			LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F9, OffRGB.R, OffRGB.G, OffRGB.B);
			LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F10, OffRGB.R, OffRGB.G, OffRGB.B);

			if (health == 0) {
				// nothing full
			} else {
				if (health >= 2) {
					LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F1, r, g, b);
					System.out.println("F1 full");
					if (health >= 4) {
						LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F2, r, g, b);
						System.out.println("F2 full");
						if (health >= 6) {
							LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F3, r, g, b);
							System.out.println("F3 full");
							if (health >= 8) {
								LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F4, r, g, b);
								System.out.println("F4 full");
								if (health >= 10) {
									LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F5, r, g, b);
									System.out.println("F5 full");
									if (health >= 12) {
										LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F6, r, g, b);
										System.out.println("F6 full");
										if (health >= 14) {
											LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F7, r, g, b);
											System.out.println("F7 full");
											if (health >= 16) {
												LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F8, r, g, b);
												System.out.println("F8 full");
												if (health >= 18) {
													LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F9, r, g, b);
													System.out.println("F9 full");
													if (health >= 20) {
														LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F10, r, g,
																b);
														System.out.println("F10 full");
													} else if (health == 19) {
														System.out.println("F10 half");
														LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F10, hR, hG,
																hB);
													}
												} else if (health == 17) {
													System.out.println("F9 half");
													LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F9, hR, hG, hB);
												}
											} else if (health == 15) {
												System.out.println("F8 half");
												LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F8, hR, hG, hB);
											}
										} else if (health == 13) {
											System.out.println("F7 half");
											LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F7, hR, hG, hB);
										}
									} else if (health == 11) {
										System.out.println("F6 half");
										LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F6, hR, hG, hB);
									}
								} else if (health == 9) {
									System.out.println("F5 half");
									LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F5, hR, hG, hB);
								}
							} else if (health == 7) {
								System.out.println("F4 half");
								LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F4, hR, hG, hB);
							}
						} else if (health == 5) {
							System.out.println("F3 half");
							LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F3, hR, hG, hB);
						}
					} else if (health == 3) {
						System.out.println("F2 half");
						LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F2, hR, hG, hB);
					}
				} else if (health == 1) {
					System.out.println("F1 half");
					LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F1, hR, hG, hB);
				}
			}
			activeHealth = health;
		}

	}

	public static void setGoldHealth(int health, RGB fullRGB, RGB halfRGB, RGB offRGB) {

		if (activeGoldHealth != health) {

			activeGoldHealth = health;

			if (health > 4)
				health = 4;

			switch (health) {
			case 0:
				System.out.println("F11 off");
				LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F11, offRGB.R, offRGB.R, offRGB.R);
				System.out.println("F12 off");
				LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F12, offRGB.R, offRGB.R, offRGB.R);
				break;
			case 1:
				System.out.println("F11 half");
				LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F11, halfRGB.R, halfRGB.R, halfRGB.R);
				System.out.println("F12 off");
				LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F12, offRGB.R, offRGB.R, offRGB.R);
				break;
			case 2:
				System.out.println("F11 full");
				LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F11, fullRGB.R, fullRGB.R, fullRGB.R);
				System.out.println("F12 off");
				LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F12, offRGB.R, offRGB.R, offRGB.R);
				break;
			case 3:
				System.out.println("F11 full");
				LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F11, fullRGB.R, fullRGB.R, fullRGB.R);
				System.out.println("F12 half");
				LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F12, halfRGB.R, halfRGB.R, halfRGB.R);
				break;
			case 4:
				System.out.println("F11 full");
				LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F11, fullRGB.R, fullRGB.R, fullRGB.R);
				System.out.println("F12 full");
				LogiLED.LogiLedSetLightingForKeyWithKeyName(LogiLED.F12, fullRGB.R, fullRGB.R, fullRGB.R);
				break;
			}
		}
	}

	public static int getKeyNumber(String KeyName) {

		int num = 0;

		switch (KeyName) {
		case "A":
			num = LogiLED.A;
			break;
		case "B":
			num = LogiLED.B;
			break;
		case "C":
			num = LogiLED.C;
			break;
		case "D":
			num = LogiLED.D;
			break;
		case "E":
			num = LogiLED.E;
			break;
		case "F":
			num = LogiLED.F;
			break;
		case "G":
			num = LogiLED.G;
			break;
		case "H":
			num = LogiLED.H;
			break;
		case "I":
			num = LogiLED.I;
			break;
		case "J":
			num = LogiLED.J;
			break;
		case "K":
			num = LogiLED.K;
			break;
		case "L":
			num = LogiLED.L;
			break;
		case "M":
			num = LogiLED.M;
			break;
		case "N":
			num = LogiLED.N;
			break;
		case "O":
			num = LogiLED.O;
			break;
		case "P":
			num = LogiLED.P;
			break;
		case "Q":
			num = LogiLED.Q;
			break;
		case "R":
			num = LogiLED.R;
			break;
		case "S":
			num = LogiLED.S;
			break;
		case "T":
			num = LogiLED.T;
			break;
		case "U":
			num = LogiLED.U;
			break;
		case "V":
			num = LogiLED.V;
			break;
		case "W":
			num = LogiLED.W;
			break;
		case "X":
			num = LogiLED.X;
			break;
		case "Y":
			num = LogiLED.Y;
			break;
		case "Z":
			num = LogiLED.Z;
			break;
		case "ESC":
			num = LogiLED.ESC;
			break;
		case "F1":
			num = LogiLED.F1;
			break;
		case "F2":
			num = LogiLED.F2;
			break;
		case "F3":
			num = LogiLED.F3;
			break;
		case "F4":
			num = LogiLED.F4;
			break;
		case "F5":
			num = LogiLED.F5;
			break;
		case "F6":
			num = LogiLED.F6;
			break;
		case "F7":
			num = LogiLED.F7;
			break;
		case "F8":
			num = LogiLED.F8;
			break;
		case "F9":
			num = LogiLED.F9;
			break;
		case "F10":
			num = LogiLED.F10;
			break;
		case "F11":
			num = LogiLED.F11;
			break;
		case "F12":
			num = LogiLED.F12;
			break;
		case "1":
			num = LogiLED.ONE;
			break;
		case "2":
			num = LogiLED.TWO;
			break;
		case "3":
			num = LogiLED.THREE;
			break;
		case "4":
			num = LogiLED.FOUR;
			break;
		case "5":
			num = LogiLED.FIVE;
			break;
		case "6":
			num = LogiLED.SIX;
			break;
		case "7":
			num = LogiLED.SEVEN;
			break;
		case "8":
			num = LogiLED.EIGHT;
			break;
		case "9":
			num = LogiLED.NINE;
			break;
		case "0":
			num = LogiLED.ZERO;
			break;
		case "SPACE":
			num = LogiLED.SPACE;
			break;
		case "LSHIFT":
			num = LogiLED.LEFT_SHIFT;
			break;
		case "RSHIFT":
			num = LogiLED.RIGHT_SHIFT;
			break;
		case "LCONTROL":
			num = LogiLED.LEFT_CONTROL;
			break;
		case "RCONTROL":
			num = LogiLED.RIGHT_CONTROL;
			break;
		case "TAB":
			num = LogiLED.TAB;
			break;
		case "SLASH":
			num = LogiLED.FORWARD_SLASH;
			break;
		}
		return num;

	}

}
