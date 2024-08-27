package org.lunaticuncle.lunaconfig.gui.widgets;

import net.minecraft.client.Minecraft;
import net.minecraft.client.render.tessellator.Tessellator;
import org.lunaticuncle.lunaconfig.gui.utils.Color;
import org.lunaticuncle.lunaconfig.gui.utils.Vector2i;
import org.lwjgl.opengl.GL11;

public class NormalRectangle extends Widget {

	private NormalRectangle(NormalRectangle.Builder builder) {
		super(builder);
	}

	@Override
	public boolean draw(Minecraft mc) {
		// Find some way to make this use one draw call later

		// Draw outer rectangle (border)


		// Draw inner rectangle


		return true;
	}

	private void drawFilledRectangle() {
		Tessellator tessellator = Tessellator.instance;

		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glColor4d((double) this.style.getBackgroundColor().getRed() / 255,
					   (double) this.style.getBackgroundColor().getGreen() / 255,
					   (double) this.style.getBackgroundColor().getBlue() / 255,
					   (double) this.style.getBackgroundColor().getAlpha() / 255);

		tessellator.startDrawing(GL11.GL_QUADS);
		tessellator.drawRectangle(this.position.x,
								  this.position.y,
								  this.size.x,
								  this.size.y);
		tessellator.draw();

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	private void drawHollowRectangle() {
		Tessellator tessellator = Tessellator.instance;

		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glLineWidth(style.getBorderSize());
		GL11.glColor4d((double) this.style.getBackgroundColor().getRed() / 255,
					   (double) this.style.getBackgroundColor().getGreen() / 255,
					   (double) this.style.getBackgroundColor().getBlue() / 255,
					   (double) this.style.getBackgroundColor().getAlpha() / 255);

		tessellator.startDrawing(GL11.GL_LINE_LOOP);
		tessellator.drawRectangle(this.position.x,
								  this.position.y,
								  this.size.x,
								  this.size.y);
		tessellator.draw();

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public static class Builder extends Widget.Builder<Builder> {
		@Override
		protected Builder self() {
			return this;
		}

		@Override
		public Widget build() {
			return new NormalRectangle(this);
		}
	}
}
