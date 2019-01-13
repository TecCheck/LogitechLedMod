package de.teccheck.logiledmod;

import java.awt.Color;

import com.logitech.gaming.LogiLED;

public class LogiLedKey {

	Integer r = 0;
	Integer g = 0;
	Integer b = 0;
	Integer buttonID = 0;
	boolean enabled = true;
	boolean changed = true;

	public LogiLedKey(int buttonID) {
		this.buttonID = buttonID;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	public void setColor(int r, int g, int b) {
		changed = true;
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public void set(int r, int g, int b, boolean enabled) {
		changed = true;
		this.r = r;
		this.g = g;
		this.b = b;
		this.enabled = enabled;
	}

	public void setEnabled(boolean enabled) {
		changed = true;
		this.enabled = enabled;
	}

	public RGB getColor() {
		return new RGB(r, g, b);
	}

	public RGB getRealColor() {
		if (enabled)
			return new RGB(r, g, b);
		return Settings.PressedKeysRGB;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public boolean isChanged() {
		return changed;
	}

	public void writeToKey() {
		if (changed) {
			RGB c = getRealColor();
			LogiLED.LogiLedSetLightingForKeyWithKeyName(buttonID, c.r, c.g, c.b);
			changed = false;
		}
	}

	public void forceWriteToKey() {
		RGB c = getRealColor();
		LogiLED.LogiLedSetLightingForKeyWithKeyName(buttonID, c.r, c.g, c.b);
		changed = false;
	}
}
