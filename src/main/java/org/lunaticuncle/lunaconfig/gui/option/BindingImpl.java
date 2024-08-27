package org.lunaticuncle.lunaconfig.gui.option;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class BindingImpl<T> implements Binding<T> {
	private final Consumer<T> setter;
	private final Supplier<T> getter;

	public BindingImpl(Consumer<T> setter, Supplier<T> getter) {
		this.setter = setter;
		this.getter = getter;
	}

	@Override
	public void setValue(T value) {
		this.setter.accept(value);
	}

	@Override
	public T getValue() {
		return this.getter.get();
	}
}
