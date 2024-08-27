package org.lunaticuncle.lunaconfig.gui.widgets;

import net.minecraft.client.Minecraft;

public class TexturedRectangle extends Widget {

	private TexturedRectangle(TexturedRectangle.Builder builder) {
		super(builder);
	}

	@Override
	public boolean draw(Minecraft mc) {
		

		return false;
	}

	public static class Builder extends Widget.Builder<Builder> {
		@Override
		protected Builder self() {
			return this;
		}

		@Override
		public Widget build() {
			return new TexturedRectangle(this);
		}
	}
}
