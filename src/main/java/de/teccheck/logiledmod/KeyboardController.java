package de.teccheck.logiledmod;

import java.awt.Color;
import java.util.HashMap;

import com.logitech.gaming.LogiLED;

public class KeyboardController {

	public HashMap<String, LogiLedKey> keys = new HashMap<>();

	public KeyboardController(HashMap<String, LogiLedKey> keys) {
		this.keys = keys;
	}

	public void setKeys(HashMap<String, LogiLedKey> keys) {
		this.keys = keys;
	}

	public RGB getColor(String name) {
		return keys.get(name).getColor();
	}

	public RGB getRealColor(String name) {
		return keys.get(name).getRealColor();
	}

	public boolean isEnabled(String name) {
		return keys.get(name).isEnabled();
	}

	public void set(String name, int r, int g, int b, boolean enabled) {
		if (!name.equals("")) {
			try {
				keys.get(name).set(r, g, b, enabled);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setColor(String name, int r, int g, int b) {
		if (!name.equals("")) {
			try {
				keys.get(name).setColor(r, g, b);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void writeToKey(String name) {
		keys.get(name).writeToKey();
	}

	public void setEnabled(String name, boolean enabled) {
		if (!name.equals("")) {
			try {
				keys.get(name).setEnabled(enabled);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setChanged(String name, boolean changed) {
		if (!name.equals("")) {
			try {
				keys.get(name).setChanged(changed);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setAll(int r, int g, int b, boolean enabled) {
		for (LogiLedKey key : keys.values()) {
			key.set(r, g, b, enabled);
		}
	}

	public void setAllColors(int r, int g, int b) {
		for (LogiLedKey key : keys.values()) {
			key.setColor(r, g, b);
		}
	}

	public void setAllEnabled(boolean enabled) {
		for (LogiLedKey key : keys.values()) {
			key.setEnabled(enabled);
		}
	}

	public void writeAllToKeys() {
		for (LogiLedKey key : keys.values()) {
			key.writeToKey();
		}
	}

	public void forceWriteAllToKeys() {
		for (LogiLedKey key : keys.values()) {
			key.forceWriteToKey();
		}
	}

}
