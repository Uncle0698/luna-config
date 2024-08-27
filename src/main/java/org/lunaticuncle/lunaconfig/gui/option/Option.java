package org.lunaticuncle.lunaconfig.gui.option;

import org.lunaticuncle.lunaconfig.gui.text.Text;
import org.lunaticuncle.lunaconfig.gui.widgets.Widget;

public class Option<T>{

	private final Binding<T> binding;
	private final Widget widget;
	private final Text name;
	private final Text toolTip;

	private Option(Builder<T> builder) {
		this.binding = builder.binding;
		this.widget = builder.widget;
		this.name = builder.name;
		this.toolTip = builder.toolTip;
	}

	public Binding<T> getBinding() {
		return this.binding;
	}

	public Widget getWidget() {
		return widget;
	}

	public Text getName() {
		return name;
	}

	public Text getToolTip() {
		return toolTip;
	}

	public static class Builder<T> {
		private final Binding<T> binding;
		private final Widget widget;
		private Text name;
		private Text toolTip;

		public Builder(Binding<T> binding,
					   Widget widget) {
			this.binding = binding;
			this.widget = widget;
		}

		public Builder<T> setName(Text name) {
			this.name = name;
			return this;
		}

		public Builder<T> setToolTip(Text toolTip) {
			this.toolTip = toolTip;
			return this;
		}

		public Option<T> build() {
			return new Option<>(this);
		}
	}
}
