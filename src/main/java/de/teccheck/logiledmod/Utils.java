package de.teccheck.logiledmod;

import java.util.HashMap;
import java.util.Set;

public class Utils {

	public static Set<String> keys = getKeys().keySet();

	public static String getLogiName(String input) {
		String out = "";
		switch (input) {
		case "ESCAPE":
			out = "ESC";
			break;
		case "F1":
			out = "F1";
			break;
		case "F2":
			out = "F2";
			break;
		case "F3":
			out = "F3";
			break;
		case "F4":
			out = "F4";
			break;
		case "F5":
			out = "F5";
			break;
		case "F6":
			out = "F6";
			break;
		case "F7":
			out = "F7";
			break;
		case "F8":
			out = "F8";
			break;
		case "F9":
			out = "F9";
			break;
		case "F10":
			out = "F10";
			break;
		case "F11":
			out = "F11";
			break;
		case "F12":
			out = "F12";
			break;
		case "NONE":
			out = "";
			break;
		case "SCROLL":
			out = "SCROLL_LOCK";
			break;
		case "PAUSE":
			out = "PAUSE_BREAK";
			break;
		case "BACKSLASH":
			out = "TILDE";
			break;
		case "1":
			out = "ONE";
			break;
		case "2":
			out = "TWO";
			break;
		case "3":
			out = "THREE";
			break;
		case "4":
			out = "FOUR";
			break;
		case "5":
			out = "FIVE";
			break;
		case "6":
			out = "SIX";
			break;
		case "7":
			out = "SEVEN";
			break;
		case "8":
			out = "EIGHT";
			break;
		case "9":
			out = "NINE";
			break;
		case "0":
			out = "ZERO";
			break;
		case "LBRACKET":
			out = "MINUS";
			break;
		case "RBRACKET":
			out = "EQUALS";
			break;
		case "BACK":
			out = "BACKSPACE";
			break;
		case "INSERT":
			out = "INSERT";
			break;
		case "PRIOR":
			out = "PAGE_UP";
			break;
		case "NUMLOCK":
			out = "NUM_LOCK";
			break;
		case "DIVIDE":
			out = "NUM_SLASH";
			break;
		case "MULTIPLY":
			out = "NUM_ASTERISK";
			break;
		case "SUBTRACT":
			out = "NUM_MINUS";
			break;
		case "TAB":
			out = "TAB";
			break;
		case "Q":
			out = "Q";
			break;
		case "W":
			out = "W";
			break;
		case "E":
			out = "E";
			break;
		case "R":
			out = "R";
			break;
		case "T":
			out = "T";
			break;
		case "Z":
			out = "Y";
			break;
		case "U":
			out = "U";
			break;
		case "I":
			out = "I";
			break;
		case "O":
			out = "O";
			break;
		case "P":
			out = "P";
			break;
		case "SEMICOLON":
			out = "OPEN_BRACKET";
			break;
		case "EQUALS":
			out = "CLOSE_BRACKET";
			break;
		case "DELETE":
			out = "KEYBOARD_DELETE";
			break;
		case "END":
			out = "END";
			break;
		case "NEXT":
			out = "PAGE_DOWN";
			break;
		case "NUMPAD7":
			out = "NUM_SEVEN";
			break;
		case "NUMPAD8":
			out = "NUM_EIGHT";
			break;
		case "NUMPAD9":
			out = "NUM_NINE";
			break;
		case "ADD":
			out = "NUM_PLUS";
			break;
		case "CAPITAL":
			out = "CAPS_LOCK";
			break;
		case "A":
			out = "A";
			break;
		case "S":
			out = "S";
			break;
		case "D":
			out = "D";
			break;
		case "F":
			out = "F";
			break;
		case "G":
			out = "G";
			break;
		case "H":
			out = "H";
			break;
		case "J":
			out = "J";
			break;
		case "K":
			out = "K";
			break;
		case "L":
			out = "L";
			break;
		case "GRAVE":
			out = "SEMICOLON";
			break;
		case "APOSTROPHE":
			out = "APOSTROPHE";
			break;
		case "NUMPAD4":
			out = "NUM_FOUR";
			break;
		case "NUMPAD5":
			out = "NUM_FIVE";
			break;
		case "NUMPAD6":
			out = "NUM_SIX";
			break;
		case "LSHIFT":
			out = "LEFT_SHIFT";
			break;
		case "Y":
			out = "Z";
			break;
		case "X":
			out = "X";
			break;
		case "C":
			out = "C";
			break;
		case "V":
			out = "V";
			break;
		case "B":
			out = "B";
			break;
		case "N":
			out = "N";
			break;
		case "M":
			out = "M";
			break;
		case "COMMA":
			out = "COMMA";
			break;
		case "PERIOD":
			out = "PERIOD";
			break;
		case "MINUS":
			out = "FORWARD_SLASH";
			break;
		case "RSHIFT":
			out = "RIGHT_SHIFT";
			break;
		case "UP":
			out = "ARROW_UP";
			break;
		case "NUMPAD1":
			out = "NUM_ONE";
			break;
		case "NUMPAD2":
			out = "NUM_TWO";
			break;
		case "NUMPAD3":
			out = "NUM_THREE";
			break;
		case "RETURN":
			out = "NUM_ENTER";
			break;
		case "LCONTROL":
			out = "LEFT_CONTROL";
			break;
		case "LMETA":
			out = "LEFT_WINDOWS";
			break;
		case "LMENU":
			out = "LEFT_ALT";
			break;
		case "SPACE":
			out = "SPACE";
			break;
		case "RMETA":
			out = "RIGHT_WINDOWS";
			break;
		case "APPS":
			out = "APPLICATION_SELECT";
			break;
		case "RCONTROL":
			out = "RIGHT_CONTROL";
			break;
		case "LEFT":
			out = "ARROW_LEFT";
			break;
		case "DOWN ":
			out = "ARROW_DOWN";
			break;
		case "RIGHT":
			out = "ARROW_RIGHT";
			break;
		case "NUMPAD0":
			out = "NUM_ZERO";
			break;
		case "DECIMAL":
			out = "NUM_PERIOD";
			break;
		case "RMENU":
			out = "RIGHT_ALT";
			break;
		}
		return out;
	}

	public static String getLogiName(int input) {
		String out = "";
		switch (input) {
		case 1:
			out = "ESC";
			break;
		case 59:
			out = "F1";
			break;
		case 60:
			out = "F2";
			break;
		case 61:
			out = "F3";
			break;
		case 62:
			out = "F4";
			break;
		case 63:
			out = "F5";
			break;
		case 64:
			out = "F6";
			break;
		case 65:
			out = "F7";
			break;
		case 66:
			out = "F8";
			break;
		case 67:
			out = "F9";
			break;
		case 68:
			out = "F10";
			break;
		case 87:
			out = "F11";
			break;
		case 88:
			out = "F12";
			break;
		case 70:
			out = "SCROLL_LOCK";
			break;
		case 197:
			out = "PAUSE_BREAK";
			break;
		case 43:
			out = "TILDE";
			break;
		case 2:
			out = "ONE";
			break;
		case 3:
			out = "TWO";
			break;
		case 4:
			out = "THREE";
			break;
		case 5:
			out = "FOUR";
			break;
		case 6:
			out = "FIVE";
			break;
		case 7:
			out = "SIX";
			break;
		case 8:
			out = "SEVEN";
			break;
		case 9:
			out = "EIGHT";
			break;
		case 10:
			out = "NINE";
			break;
		case 11:
			out = "ZERO";
			break;
		case 26:
			out = "MINUS";
			break;
		case 27:
			out = "EQUALS";
			break;
		case 14:
			out = "BACKSPACE";
			break;
		case 210:
			out = "INSERT";
			break;
		case 201:
			out = "PAGE_UP";
			break;
		case 69:
			out = "NUM_LOCK";
			break;
		case 181:
			out = "NUM_SLASH";
			break;
		case 55:
			out = "NUM_ASTERISK";
			break;
		case 74:
			out = "NUM_MINUS";
			break;
		case 15:
			out = "TAB";
			break;
		case 16:
			out = "Q";
			break;
		case 17:
			out = "W";
			break;
		case 18:
			out = "E";
			break;
		case 19:
			out = "R";
			break;
		case 20:
			out = "T";
			break;
		case 44:
			out = "Y";
			break;
		case 22:
			out = "U";
			break;
		case 23:
			out = "I";
			break;
		case 24:
			out = "O";
			break;
		case 25:
			out = "P";
			break;
		case 39:
			out = "OPEN_BRACKET";
			break;
		case 13:
			out = "CLOSE_BRACKET";
			break;
		case 211:
			out = "KEYBOARD_DELETE";
			break;
		case 207:
			out = "END";
			break;
		case 209:
			out = "PAGE_DOWN";
			break;
		case 71:
			out = "NUM_SEVEN";
			break;
		case 72:
			out = "NUM_EIGHT";
			break;
		case 73:
			out = "NUM_NINE";
			break;
		case 78:
			out = "NUM_PLUS";
			break;
		case 58:
			out = "CAPS_LOCK";
			break;
		case 30:
			out = "A";
			break;
		case 31:
			out = "S";
			break;
		case 32:
			out = "D";
			break;
		case 33:
			out = "F";
			break;
		case 34:
			out = "G";
			break;
		case 35:
			out = "H";
			break;
		case 36:
			out = "J";
			break;
		case 37:
			out = "K";
			break;
		case 38:
			out = "L";
			break;
		case 41:
			out = "SEMICOLON";
			break;
		case 40:
			out = "APOSTROPHE";
			break;
		case 28:
			out = "ENTER";
			break;
		case 75:
			out = "NUM_FOUR";
			break;
		case 76:
			out = "NUM_FIVE";
			break;
		case 77:
			out = "NUM_SIX";
			break;
		case 42:
			out = "LEFT_SHIFT";
			break;
		case 21:
			out = "Z";
			break;
		case 45:
			out = "X";
			break;
		case 46:
			out = "C";
			break;
		case 47:
			out = "V";
			break;
		case 48:
			out = "B";
			break;
		case 49:
			out = "N";
			break;
		case 50:
			out = "M";
			break;
		case 51:
			out = "COMMA";
			break;
		case 52:
			out = "PERIOD";
			break;
		case 12:
			out = "FORWARD_SLASH";
			break;
		case 54:
			out = "RIGHT_SHIFT";
			break;
		case 200:
			out = "ARROW_UP";
			break;
		case 79:
			out = "NUM_ONE";
			break;
		case 80:
			out = "NUM_TWO";
			break;
		case 81:
			out = "NUM_THREE";
			break;
		case 29:
			out = "LEFT_CONTROL";
			break;
		case 219:
			out = "LEFT_WINDOWS";
			break;
		case 56:
			out = "LEFT_ALT";
			break;
		case 57:
			out = "SPACE";
			break;
		case 220:
			out = "RIGHT_WINDOWS";
			break;
		case 221:
			out = "APPLICATION_SELECT";
			break;
		case 157:
			out = "RIGHT_CONTROL";
			break;
		case 203:
			out = "ARROW_LEFT";
			break;
		case 208:
			out = "ARROW_DOWN";
			break;
		case 205:
			out = "ARROW_RIGHT";
			break;
		case 82:
			out = "NUM_ZERO";
			break;
		case 83:
			out = "NUM_PERIOD";
			break;
		case 53:
			out = "HASHTAG";
			break;
		case 0:
			out = "ANGLE_BRACKETS";
			break;
		}

		return out;
	}

	public static HashMap<String, LogiLedKey> getKeys() {
		HashMap<String, LogiLedKey> keys = new HashMap<>();

		keys.put("ESC", new LogiLedKey(1));
		keys.put("F1", new LogiLedKey(59));
		keys.put("F2", new LogiLedKey(60));
		keys.put("F3", new LogiLedKey(61));
		keys.put("F4", new LogiLedKey(62));
		keys.put("F5", new LogiLedKey(63));
		keys.put("F6", new LogiLedKey(64));
		keys.put("F7", new LogiLedKey(65));
		keys.put("F8", new LogiLedKey(66));
		keys.put("F9", new LogiLedKey(67));
		keys.put("F10", new LogiLedKey(68));
		keys.put("F11", new LogiLedKey(87));
		keys.put("F12", new LogiLedKey(88));
		keys.put("PRINT_SCREEN", new LogiLedKey(311));
		keys.put("SCROLL_LOCK", new LogiLedKey(70));
		keys.put("PAUSE_BREAK", new LogiLedKey(325));
		keys.put("TILDE", new LogiLedKey(41));
		keys.put("ONE", new LogiLedKey(2));
		keys.put("TWO", new LogiLedKey(3));
		keys.put("THREE", new LogiLedKey(4));
		keys.put("FOUR", new LogiLedKey(5));
		keys.put("FIVE", new LogiLedKey(6));
		keys.put("SIX", new LogiLedKey(7));
		keys.put("SEVEN", new LogiLedKey(8));
		keys.put("EIGHT", new LogiLedKey(9));
		keys.put("NINE", new LogiLedKey(10));
		keys.put("ZERO", new LogiLedKey(11));
		keys.put("MINUS", new LogiLedKey(12));
		keys.put("EQUALS", new LogiLedKey(13));
		keys.put("BACKSPACE", new LogiLedKey(14));
		keys.put("INSERT", new LogiLedKey(338));
		keys.put("HOME", new LogiLedKey(327));
		keys.put("PAGE_UP", new LogiLedKey(329));
		keys.put("NUM_LOCK", new LogiLedKey(69));
		keys.put("NUM_SLASH", new LogiLedKey(309));
		keys.put("NUM_ASTERISK", new LogiLedKey(55));
		keys.put("NUM_MINUS", new LogiLedKey(74));
		keys.put("TAB", new LogiLedKey(15));
		keys.put("Q", new LogiLedKey(16));
		keys.put("W", new LogiLedKey(17));
		keys.put("E", new LogiLedKey(18));
		keys.put("R", new LogiLedKey(19));
		keys.put("T", new LogiLedKey(20));
		keys.put("Y", new LogiLedKey(21));
		keys.put("U", new LogiLedKey(22));
		keys.put("I", new LogiLedKey(23));
		keys.put("O", new LogiLedKey(24));
		keys.put("P", new LogiLedKey(25));
		keys.put("OPEN_BRACKET", new LogiLedKey(26));
		keys.put("CLOSE_BRACKET", new LogiLedKey(27));
		keys.put("BACKSLASH", new LogiLedKey(43));
		keys.put("KEYBOARD_DELETE", new LogiLedKey(339));
		keys.put("END", new LogiLedKey(335));
		keys.put("PAGE_DOWN", new LogiLedKey(337));
		keys.put("NUM_SEVEN", new LogiLedKey(71));
		keys.put("NUM_EIGHT", new LogiLedKey(72));
		keys.put("NUM_NINE", new LogiLedKey(73));
		keys.put("NUM_PLUS", new LogiLedKey(78));
		keys.put("CAPS_LOCK", new LogiLedKey(58));
		keys.put("A", new LogiLedKey(30));
		keys.put("S", new LogiLedKey(31));
		keys.put("D", new LogiLedKey(32));
		keys.put("F", new LogiLedKey(33));
		keys.put("G", new LogiLedKey(34));
		keys.put("H", new LogiLedKey(35));
		keys.put("J", new LogiLedKey(36));
		keys.put("K", new LogiLedKey(37));
		keys.put("L", new LogiLedKey(38));
		keys.put("SEMICOLON", new LogiLedKey(39));
		keys.put("APOSTROPHE", new LogiLedKey(40));
		keys.put("ENTER", new LogiLedKey(28));
		keys.put("NUM_FOUR", new LogiLedKey(75));
		keys.put("NUM_FIVE", new LogiLedKey(76));
		keys.put("NUM_SIX", new LogiLedKey(77));
		keys.put("LEFT_SHIFT", new LogiLedKey(42));
		keys.put("Z", new LogiLedKey(44));
		keys.put("X", new LogiLedKey(45));
		keys.put("C", new LogiLedKey(46));
		keys.put("V", new LogiLedKey(47));
		keys.put("B", new LogiLedKey(48));
		keys.put("N", new LogiLedKey(49));
		keys.put("M", new LogiLedKey(50));
		keys.put("COMMA", new LogiLedKey(51));
		keys.put("PERIOD", new LogiLedKey(52));
		keys.put("FORWARD_SLASH", new LogiLedKey(53));
		keys.put("RIGHT_SHIFT", new LogiLedKey(54));
		keys.put("ARROW_UP", new LogiLedKey(328));
		keys.put("NUM_ONE", new LogiLedKey(79));
		keys.put("NUM_TWO", new LogiLedKey(80));
		keys.put("NUM_THREE", new LogiLedKey(81));
		keys.put("NUM_ENTER", new LogiLedKey(284));
		keys.put("LEFT_CONTROL", new LogiLedKey(29));
		keys.put("LEFT_WINDOWS", new LogiLedKey(347));
		keys.put("LEFT_ALT", new LogiLedKey(56));
		keys.put("SPACE", new LogiLedKey(57));
		keys.put("RIGHT_ALT", new LogiLedKey(312));
		keys.put("RIGHT_WINDOWS", new LogiLedKey(348));
		keys.put("APPLICATION_SELECT", new LogiLedKey(349));
		keys.put("RIGHT_CONTROL", new LogiLedKey(285));
		keys.put("ARROW_LEFT", new LogiLedKey(331));
		keys.put("ARROW_DOWN", new LogiLedKey(336));
		keys.put("ARROW_RIGHT", new LogiLedKey(333));
		keys.put("NUM_ZERO", new LogiLedKey(82));
		keys.put("NUM_PERIOD", new LogiLedKey(83));
		keys.put("G_1", new LogiLedKey(65521));
		keys.put("G_2", new LogiLedKey(65522));
		keys.put("G_3", new LogiLedKey(65523));
		keys.put("G_4", new LogiLedKey(65524));
		keys.put("G_5", new LogiLedKey(65525));
		keys.put("G_6", new LogiLedKey(65526));
		keys.put("G_7", new LogiLedKey(65527));
		keys.put("G_8", new LogiLedKey(65528));
		keys.put("G_9", new LogiLedKey(65529));
		keys.put("G_LOGO", new LogiLedKey(1048561));
		keys.put("G_BADGE", new LogiLedKey(1048562));
		keys.put("HASHTAG", new LogiLedKey(93));
		keys.put("PLUS", new LogiLedKey(27));
		keys.put("AE", new LogiLedKey(40));
		keys.put("UE", new LogiLedKey(26));
		keys.put("OE", new LogiLedKey(39));
		keys.put("CARET", new LogiLedKey(41));
		keys.put("ANGLE_BRACKETS", new LogiLedKey(86));
		keys.put("SECTION_SIGN", new LogiLedKey(41));
		keys.put("SHARP_S", new LogiLedKey(12));

		return keys;
	}

	public static String getKeyName(int i) {
		String s = "";
		switch (i) {
		case 0:
			s = "ZERO";
			break;
		case 1:
			s = "ONE";
			break;
		case 2:
			s = "TWO";
			break;
		case 3:
			s = "THREE";
			break;
		case 4:
			s = "FOUR";
			break;
		case 5:
			s = "FIVE";
			break;
		case 6:
			s = "SIX";
			break;
		case 7:
			s = "SEVEN";
			break;
		case 8:
			s = "EIGHT";
			break;
		case 9:
			s = "NINE";
			break;
		}
		return s;
	}
}
