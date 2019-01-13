package de.teccheck.logiledmod;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.logitech.gaming.LogiLED;

import de.teccheck.logiledmod.config.FastReflection;

public class Tester {

	public static boolean mouse = false;

	static ArrayList<String> keysLogi = new ArrayList<>();
	static ArrayList<Integer> keysLogiInt = new ArrayList<>();
	static ArrayList<String> keysLWJGL = new ArrayList<>();
	static ArrayList<Integer> keysLWJGLInt = new ArrayList<>();

	public static void start() {
		String[] logiN = { "ESC", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12",
				"PRINT_SCREEN", "SCROLL_LOCK", "PAUSE_BREAK", "TILDE", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX",
				"SEVEN", "EIGHT", "NINE", "ZERO", "MINUS", "EQUALS", "BACKSPACE", "INSERT", "HOME", "PAGE_UP",
				"NUM_LOCK", "NUM_SLASH", "NUM_ASTERISK", "NUM_MINUS", "TAB", "Q", "W", "E", "R", "T", "Y", "U", "I",
				"O", "P", "OPEN_BRACKET", "CLOSE_BRACKET", "BACKSLASH", "KEYBOARD_DELETE", "END", "PAGE_DOWN",
				"NUM_SEVEN", "NUM_EIGHT", "NUM_NINE", "NUM_PLUS", "CAPS_LOCK", "A", "S", "D", "F", "G", "H", "J", "K",
				"L", "SEMICOLON", "APOSTROPHE", "ENTER", "NUM_FOUR", "NUM_FIVE", "NUM_SIX", "LEFT_SHIFT", "Z", "X", "C",
				"V", "B", "N", "M", "COMMA", "PERIOD", "FORWARD_SLASH", "RIGHT_SHIFT", "ARROW_UP", "NUM_ONE", "NUM_TWO",
				"NUM_THREE", "NUM_ENTER", "LEFT_CONTROL", "LEFT_WINDOWS", "LEFT_ALT", "SPACE", "RIGHT_ALT",
				"RIGHT_WINDOWS", "APPLICATION_SELECT", "RIGHT_CONTROL", "ARROW_LEFT", "ARROW_DOWN", "ARROW_RIGHT",
				"NUM_ZERO", "NUM_PERIOD" };
		String[] lwjglN = { "ESCAPE", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12", "NONE",
				"SCROLL", "KEY_PAUSE", "BACKSLASH", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "LBRACKET",
				"RBRACKET", "BACK", "KEY_INSERT", "KEY_END", "KEY_PRIOR", "NUMLOCK", "KEY_DIVIDE", "MULTIPLY",
				"SUBTRACT", "TAB", "Q", "W", "E", "R", "T", "Z", "U", "I", "O", "P", "SEMICOLON", "EQUALS", "LBRACKET",
				"KEY_DELETE", "KEY_END", "KEY_NEXT", "NUMPAD7", "NUMPAD8", "NUMPAD9", "ADD", "CAPITAL", "A", "S", "D",
				"F", "G", "H", "J", "K", "L", "GRAVE", "APOSTROPHE", "RETURN", "NUMPAD4", "NUMPAD5", "NUMPAD6",
				"LSHIFT", "Y", "X", "C", "V", "B", "N", "M", "COMMA", "PERIOD", "MINUS", "RSHIFT", "KEY_UP", "NUMPAD1",
				"NUMPAD2", "NUMPAD3", "RETURN", "LCONTROL", "KEY_LMETA", "LMENU", "SPACE", "LCONTROL", "KEY_RMETA",
				"KEY_APPS", "KEY_RCONTROL", "KEY_LEFT", "KEY_DOWN ", "KEY_RIGHT", "NUMPAD0", "DECIMAL" };
		int[] logiNum = { 1, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 87, 88, 311, 70, 325, 41, 2, 3, 4, 5, 6, 7, 8, 9,
				10, 11, 12, 13, 14, 338, 327, 329, 69, 309, 55, 74, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
				43, 339, 335, 337, 71, 72, 73, 78, 58, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 28, 75, 76, 77, 42,
				44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 328, 79, 80, 81, 284, 29, 347, 56, 57, 312, 348, 349, 285,
				331, 336, 333, 82, 83 };
		int[] lwjglNum = { 1, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 87, 88, 0, 70, 197, 43, 2, 3, 4, 5, 6, 7, 8, 9,
				10, 11, 26, 27, 14, 210, 207, 201, 69, 181, 55, 74, 15, 16, 17, 18, 19, 20, 44, 22, 23, 24, 25, 39, 13,
				26, 211, 207, 209, 71, 72, 73, 78, 58, 30, 31, 32, 33, 34, 35, 36, 37, 38, 41, 40, 28, 75, 76, 77, 42,
				21, 45, 46, 47, 48, 49, 50, 51, 52, 12, 54, 200, 79, 80, 81, 28, 29, 219, 56, 57, 29, 220, 221, 157,
				203, 208, 205, 82, 83 };

		int i = 0;
		while (i < logiN.length) {
			System.out.println("case \"" + lwjglN[i] + "\":");
			System.out.println("out = \"" + logiN[i] + "\";");
			System.out.println("break;");
			i++;
		}
		i = 0;
		System.out.println("");
		while (i < logiN.length) {
			System.out.println("case " + lwjglNum[i] + ":");
			System.out.println("out = \"" + logiN[i] + "\";");
			System.out.println("break;");
			i++;
		}

	}

	public static void start1() {
		System.out.println("starting");
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				test();
			}

		});
		th.start();
	}

	public static void test() {
		String[] keys = { "ESC", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12",
				"PRINT_SCREEN", "SCROLL_LOCK", "PAUSE_BREAK", "TILDE", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX",
				"SEVEN", "EIGHT", "NINE", "ZERO", "MINUS", "EQUALS", "BACKSPACE", "INSERT", "HOME", "PAGE_UP",
				"NUM_LOCK", "NUM_SLASH", "NUM_ASTERISK", "NUM_MINUS", "TAB", "Q", "W", "E", "R", "T", "Y", "U", "I",
				"O", "P", "OPEN_BRACKET", "CLOSE_BRACKET", "BACKSLASH", "KEYBOARD_DELETE", "END", "PAGE_DOWN",
				"NUM_SEVEN", "NUM_EIGHT", "NUM_NINE", "NUM_PLUS", "CAPS_LOCK", "A", "S", "D", "F", "G", "H", "J", "K",
				"L", "SEMICOLON", "APOSTROPHE", "ENTER", "NUM_FOUR", "NUM_FIVE", "NUM_SIX", "LEFT_SHIFT", "Z", "X", "C",
				"V", "B", "N", "M", "COMMA", "PERIOD", "FORWARD_SLASH", "RIGHT_SHIFT", "ARROW_UP", "NUM_ONE", "NUM_TWO",
				"NUM_THREE", "NUM_ENTER", "LEFT_CONTROL", "LEFT_WINDOWS", "LEFT_ALT", "SPACE", "RIGHT_ALT",
				"RIGHT_WINDOWS", "APPLICATION_SELECT", "RIGHT_CONTROL", "ARROW_LEFT", "ARROW_DOWN", "ARROW_RIGHT",
				"NUM_ZERO", "NUM_PERIOD", "G_1", "G_2", "G_3", "G_4", "G_5", "G_6", "G_7", "G_8", "G_9", "G_LOGO",
				"G_BADGE" };

		String[] lwjgl = { "ESCAPE", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12", "NONE",
				"SCROLL", "NONE", "BACKSLASH", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "LBRACKET", "RBRACKET",
				"BACK", "NONE", "NONE", "NONE", "NUMLOCK", "NONE", "MULTIPLY", "SUBTRACT", "TAB", "Q", "W", "E", "R",
				"T", "Z", "U", "I", "O", "P", "SEMICOLON", "EQUALS", "LBRACKET", "NONE", "NONE", "NONE", "NUMPAD7",
				"NUMPAD8", "NUMPAD9", "ADD", "CAPITAL", "A", "S", "D", "F", "G", "H", "J", "K", "L", "GRAVE",
				"APOSTROPHE", "RETURN", "NUMPAD4", "NUMPAD5", "NUMPAD6", "LSHIFT", "Y", "X", "C", "V", "B", "N", "M",
				"COMMA", "PERIOD", "MINUS", "RSHIFT", "KEY_UP", "NUMPAD1", "NUMPAD2", "NUMPAD3", "RETURN", "LCONTROL",
				"NONE", "LMENU", "SPACE", "LCONTROL", "NONE", "NONE", "NONE", "KEY_LEFT", "KEY_DOWN ", "KEY_RIGHT",
				"NUMPAD0", "DECIMAL", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE",
				"NONE" };

		for (String s : lwjgl) {
			System.out.println(Keyboard.getKeyIndex(s));
		}

		LogiLED led = new LogiLED();

		LogiLED.LogiLedInit();
		LogiLED.LogiLedSetLighting(0, 0, 0);

		for (int index = 0; index < keys.length; index++) {

			int i = 0;
			int i2 = 0;
			try {
				i = (int) FastReflection.getFieldValue(led, keys[index]);
				if (index > 0)
					i2 = (int) FastReflection.getFieldValue(led, keys[index - 1]);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}

			LogiLED.LogiLedSetLightingForKeyWithKeyName(i, 100, 0, 0);
			LogiLED.LogiLedSetLightingForKeyWithKeyName(i2, 0, 100, 0);
			System.out.println(keys[index]);
			System.out.println(i);
			keysLogi.add(keys[index]);
			keysLogiInt.add(i);

			while (getButtons().size() != 1) {
				sleep(1);
				if (Mouse.isButtonDown(0)) {
					mouse = true;
					break;
				}
			}

			if (!mouse) {

				int key = getButtons().get(0);
				System.out.println(Keyboard.getKeyName(key));
				System.out.println(key);
				keysLWJGL.add(Keyboard.getKeyName(key));
				keysLWJGLInt.add(key);

				while (getButtons().size() != 0) {
					sleep(1);
				}

			} else {

				System.out.println(Keyboard.getKeyName(Keyboard.CHAR_NONE));
				System.out.println(Keyboard.CHAR_NONE);
				keysLWJGL.add(Keyboard.getKeyName(Keyboard.CHAR_NONE));
				keysLWJGLInt.add(Keyboard.CHAR_NONE);

				while (Mouse.isButtonDown(0)) {
					sleep(1);
				}
				mouse = false;

			}

		}

		System.out.println("IntLWJGL: " + keysLWJGLInt);
		System.out.println("LWGGL: " + keysLWJGL);
		System.out.println("LInt: " + keysLogiInt);
		System.out.println("L: " + keysLogi);

		LogiLED.LogiLedShutdown();
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Integer> getButtons() {
		ArrayList<Integer> keys = new ArrayList<>();

		for (int i = 0; i < Keyboard.getKeyCount(); i++) {
			if (Keyboard.isKeyDown(i)) {
				keys.add(i);
			}
		}

		return keys;
	}

}
