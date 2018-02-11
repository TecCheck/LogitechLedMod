package de.techeck.logiledmod;

public class RGB {
	public int R = 0;
	public int G = 0;
	public int B = 0;
	public static RGB rgb = null;

	public RGB(int r, int g, int b) {
		R = r;
		B = b;
		G = g;
	}

	public String toString() {
		return "R: " + R + " B: " + B + " G: " + G;
	}
}