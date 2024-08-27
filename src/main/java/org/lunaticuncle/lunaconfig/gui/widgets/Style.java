package org.lunaticuncle.lunaconfig.gui.widgets;

import net.minecraft.client.Minecraft;
import org.lunaticuncle.lunaconfig.gui.utils.Color;
import org.lwjgl.opengl.GL11;

import java.util.Objects;

public class Style {

	// Colors
	private Color backgroundColor;
	private Color borderColor;
	private Color textColor;

	// Size
	private int borderSize;

	// Extras
	private String texturePath;

	private Style(Style.Builder builder) {
		this.backgroundColor = builder.backgroundColor;
		this.borderColor = builder.borderColor;
		this.textColor = builder.textColor;
		this.texturePath = builder.texturePath;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getTextColor() {
		return textColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	public int getBorderSize() {
		return this.borderSize;
	}

	public void bindTexture(Minecraft mc) {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, getTexture(mc));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	public int getTexture(Minecraft mc) {
		return mc.renderEngine.getTexture(this.texturePath);
	}

	public void setTexturePath(String texturePath) {
		this.texturePath = texturePath;
	}

	public String getTexturePath() {
		return this.texturePath;
	}



	public static class Builder {
		private Color backgroundColor = Color.BLACK;
		private Color borderColor = Color.WHITE;
		private Color textColor = Color.WHITE;
		private String texturePath = "/assets/minecraft/textures/gui/gui.png";

		public Builder() {

		}

		public void withBackgroundColor(Color backgroundColor) {
			Objects.requireNonNull(backgroundColor, "Background color must not be null");

			this.backgroundColor = backgroundColor;
		}

		public void withBorderColor(Color borderColor) {
			Objects.requireNonNull(backgroundColor, "Border color must not be null");

			this.borderColor = borderColor;
		}

		public void withTextColor(Color textColor) {
			Objects.requireNonNull(textColor, "Text color must not be null");

			this.textColor = textColor;
		}

		public void withTexturePath(String texturePath) {
			Objects.requireNonNull(texturePath, "Texture path must not be null");

			this.texturePath = texturePath;
		}

		public Style Build() {
			return new Style(this);
		}
	}
}
