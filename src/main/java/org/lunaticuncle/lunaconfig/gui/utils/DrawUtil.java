package org.lunaticuncle.lunaconfig.gui.utils;

import net.minecraft.client.render.tessellator.Tessellator;
import org.lunaticuncle.lunaconfig.gui.widgets.Style;
import org.lunaticuncle.lunaconfig.gui.widgets.Widget;
import org.lwjgl.opengl.GL11;

public class DrawUtil {
	public static void drawFilledRectangle(Widget widget) {
		Tessellator tessellator = Tessellator.instance;
		Style style = widget.getStyle();
		Color color = style.getBackgroundColor();
		Vector2i position = widget.getPosition();
		Vector2i size = widget.getSize();

		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glColor4d((double) color.getRed() / 255,
                       (double) color.getGreen() / 255,
                       (double) color.getBlue() / 255,
                       (double) color.getAlpha() / 255);

		tessellator.startDrawing(GL11.GL_QUADS);
		tessellator.drawRectangle(position.x,
								  position.y,
								  size.x,
								  size.y);
		tessellator.draw();

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public static void drawHollowRectangle(Widget widget) {
		Tessellator tessellator = Tessellator.instance;
		Style style = widget.getStyle();
		Color color = style.getBackgroundColor();
		Vector2i position = widget.getPosition();
		Vector2i size = widget.getSize();

		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glLineWidth(style.getBorderSize());
		GL11.glColor4d((double) color.getRed() / 255,
					   (double) color.getGreen() / 255,
					   (double) color.getBlue() / 255,
					   (double) color.getAlpha() / 255);

		tessellator.startDrawing(GL11.GL_LINE_LOOP);
		tessellator.drawRectangle(1,1,1,1);
		tessellator.draw();

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

}
