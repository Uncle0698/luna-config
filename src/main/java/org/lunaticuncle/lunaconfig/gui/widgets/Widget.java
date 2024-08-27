package org.lunaticuncle.lunaconfig.gui.widgets;

import net.minecraft.client.Minecraft;
import org.lunaticuncle.lunaconfig.gui.signal.ProcedureSignal;
import org.lunaticuncle.lunaconfig.gui.utils.Vector2i;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Widget {
	// Identity and relationship
	protected final String name;
	protected Widget parent;
	protected final List<Widget> children;

	// Geometry and position
	protected Vector2i size;
	protected Vector2i position;

	// Flags
	protected boolean enabled;
	protected boolean visible;
	protected boolean mouseHovered;
	protected boolean focused;

	// Extras
	protected Style style;
	protected String tooltip;

	// Signals



	protected Widget(Widget.Builder<?> widgetBuilder) {
		this.name = widgetBuilder.name;
		this.children = widgetBuilder.children;

		this.size = widgetBuilder.size;
		this.position = widgetBuilder.position;

		this.enabled = widgetBuilder.enabled;
		this.tooltip = widgetBuilder.tooltip;

		for(Widget child : children) {
			child.setParent(this);
		}
	}

	// Identity and relationship

	public String getName() {
		return name;
	}

	public Widget getParent() {
		return parent;
	}

	public void setParent(Widget parent) {
		this.parent = parent;
	}

	public List<Widget> getChildren() {
		return children;
	}

	public void removeChild(Widget child) {
		Objects.requireNonNull(child, "child must not be null");

		this.children.remove(child);
	}

	public void removeChildren(List<Widget> children) {
		Objects.requireNonNull(children, "children must not be null");

		this.children.removeAll(children);
	}

	public void addChild(Widget child) {
		Objects.requireNonNull(child, "child must not be null");

		this.children.add(child);
	}

	public void addChildren(List<Widget> children) {
		for(Widget child : children) {
			Objects.requireNonNull(child, "children contains null child, child must not be null");
		}

        this.children.addAll(children);
	}

	// Geometry and position

	public Vector2i getSize() {
		return size;
	}

	public void setSize(Vector2i size) {
		// Maybe just clamp to 0 instead of throwing errors?

		if(size.x < 0) {
			throw new IllegalArgumentException("Widget size must be > 0, got width: " + size.x);
		}

		if(size.y < 0) {
			throw new IllegalArgumentException("Widget size must be > 0, got height: " + size.y);
		}

		this.size = size;
	}

	public Vector2i getPosition() {
		return position;
	}

	public void setPosition(Vector2i position) {
		this.position = position;
	}


	// Flags

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isMouseHovered() {
		// Mouse hover logic

		return mouseHovered;
	}

	public boolean isFocused() {
		return focused;
	}

	public void setFocused(boolean focused) {
		this.focused = focused;
	}

	// Extras

	public Style getStyle() {
		return this.style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public String getTooltip() {
		return tooltip;
	}

	// Render

	// Should return true if there's no error
	public abstract boolean draw(Minecraft mc);

	// Builder

	public static abstract class Builder<T extends Builder<T>> {
		// Optional fields
		protected String name = "";
		protected List<Widget> children = new ArrayList<>();
		protected Vector2i size = new Vector2i(0, 0);
		protected Vector2i position = new Vector2i(0 ,0);
		protected boolean enabled = true;
		protected boolean visible = true;
		protected String tooltip = "";

		public Builder() {

		}

		protected abstract T self();

		public T withName(String name) {
			Objects.requireNonNull(name, "name must not be null");

			this.name = name;
			return self();
		}

		public T withChild(Widget child) {
			Objects.requireNonNull(child, "child must not be null");

			this.children.add(child);
			return self();
		}

		public T withChildren(List<Widget> children) {
			for(Widget child : children) {
				Objects.requireNonNull(child, "children contains null child, child must not be null");
			}

			this.children = children;
			return self();
		}

		public T withSize(Vector2i size) {
			// Maybe just clamp to 0 instead of throwing errors?

			if(size.x < 0) {
				throw new IllegalArgumentException("Widget size must be > 0, got width: " + size.x);
			}

			if(size.y < 0) {
				throw new IllegalArgumentException("Widget size must be > 0, got height: " + size.y);
			}

			this.size = size;
			return self();
		}

		public T withPosition(Vector2i position) {
			this.position = position;
			return self();
		}

		public T withEnabled(boolean enabled) {
			this.enabled = enabled;
			return self();
		}

		public T withVisible(boolean visible) {
			this.visible = visible;
			return self();
		}

		public T withTooltip(String tooltip) {
			Objects.requireNonNull(tooltip, "tooltip must not be null");

			this.tooltip = tooltip;
			return self();
		}

		public abstract Widget build();
	}

}
