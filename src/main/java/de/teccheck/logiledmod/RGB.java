package de.teccheck.logiledmod;

public class RGB {
	public Integer r = 0;
	public Integer g = 0;
	public Integer b = 0;

	public RGB(int r, int g, int b) {
		this.r = r;
		this.b = b;
		this.g = g;
	}

	public String toString() {
		return "R: " + r + " G: " + g + " B: " + b;
	}

	public int[] toIntegerArray() {
		int[] i = { r, g, b };
		return i;
	}

	public void fromIntegerArray(int[] color) {
		if (color.length == 3) {
			this.r = color[0];
			this.g = color[1];
			this.b = color[2];
		}
	}

	public static int[] ints(int rgb) {
		return new int[] { rgb >> 16 & 255, rgb >> 8 & 255, rgb & 255 };
	}
}