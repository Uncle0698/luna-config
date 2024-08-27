package org.lunaticuncle.lunaconfig.gui.utils;

public class Color {
	public static final Color WHITE = rgb(255, 255, 255);
	public static final Color ORANGE = rgb(255, 170, 0);
	public static final Color MAGENTA = rgb(252, 38, 163);
	public static final Color LIGHT_BLUE = rgb(94, 210, 255);
	public static final Color YELLOW = rgb(255, 241, 82);
	public static final Color LIME = rgb(101, 234, 19);
	public static final Color PINK = rgb(255, 127, 236);
	public static final Color GRAY = rgb(110, 110, 110);
	public static final Color LIGHT_GRAY = rgb(179, 179, 179);
	public static final Color CYAN = rgb(9, 160, 174);
	public static final Color PURPLE = rgb(120, 36, 255);
	public static final Color BLUE = rgb(13, 77, 255);
	public static final Color BROWN = rgb(143, 82, 36);
	public static final Color GREEN = rgb(38, 130, 23);
	public static final Color RED = rgb(232, 32, 32);
	public static final Color BLACK = rgb(48, 48, 48);

	private final int value;

	private Color(int value) {
		this.value = value;
	}

	// Hex string
	public static Color valueOf(String colorString) {
		if(colorString == null) {
			throw new IllegalArgumentException("Color value is null");
		}

		if(colorString.startsWith("#")) {
			colorString = colorString.substring(1);
		}

		int value = Integer.parseUnsignedInt(colorString, 16);
		return new Color(value);
	}

	public static Color rgb(int red, int green, int blue) {
		return argb(255, red, green, blue);
	}

	public static Color argb(int alpha, int red, int green, int blue) {
		checkARGBRange(alpha, red, green, blue);
		int value = alpha << 24 + red << 16 + green << 8 + blue;
		return new Color(value);
	}

	private static void checkARGBRange(int alpha, int red, int green, int blue) {
		boolean isOutOfRange = false;
		StringBuilder errorString = new StringBuilder();

		if(alpha < 0 || alpha > 255) {
			isOutOfRange = true;
			errorString.append("Alpha: ").append(alpha);
		}
		if(red < 0 || red > 255) {
			isOutOfRange = true;
			errorString.append("Red: ").append(red);
		}
		if(green < 0 || green > 255) {
			isOutOfRange = true;
			errorString.append("Green: ").append(green);
		}
		if(blue < 0 || blue > 255) {
			isOutOfRange = true;
			errorString.append("Blue: ").append(blue);
		}

		if(isOutOfRange) {
			throw new IllegalArgumentException("Color.argb has illegal parameters: " + errorString);
		}
	}

	public int getValue() {
		return this.value;
	}

	public int getAlpha() {
		return (this.value >> 24) & 0xFF;
	}

	public int getRed() {
		return (this.value >> 16) & 0xFF;
	}

	public int getGreen() {
		return (this.value >> 8) & 0xFF;
	}

	public int getBlue() {
		return this.value & 0xFF;
	}

	@Override
	public String toString() {
		return "#" + Integer.toHexString(this.value).toUpperCase();
	}

}
