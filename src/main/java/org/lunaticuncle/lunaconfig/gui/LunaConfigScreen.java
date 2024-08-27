package org.lunaticuncle.lunaconfig.gui;

import net.minecraft.client.gui.GuiScreen;
import org.lunaticuncle.lunaconfig.gui.text.Text;
import org.lunaticuncle.lunaconfig.gui.widgets.Widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LunaConfigScreen extends GuiScreen {

	private final GuiScreen parentScreen;
	private final List<Widget> children;

	public LunaConfigScreen(LunaConfigScreen.Builder builder) {
		this.parentScreen = builder.parentScreen;
		this.children = builder.children;
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTick) {
		if(children.isEmpty()) {
			return;
		}

		for(Widget child : children) {
			child.draw(this.mc);
		}
	}

	@Override
	public void refreshFontRenderer() {
		super.refreshFontRenderer();

	}

	public static class Builder {
		private GuiScreen parentScreen;
		private List<Widget> children = new ArrayList<>();

		public Builder() {

		}

		public Builder withParentScreen(GuiScreen parentScreen) {
			this.parentScreen = parentScreen;
			return this;
		}

		public Builder withChild(Widget child) {
			Objects.requireNonNull(child, "child must not be null");

			this.children.add(child);
			return this;
		}

		public Builder withChildren(List<Widget> children) {
			for(Widget child : children) {
				Objects.requireNonNull(child, "children contains null child, child must not be null");
			}

			this.children = children;
			return this;
		}

		public LunaConfigScreen build() {
			return new LunaConfigScreen(this);
		}

	}
}
