package org.lunaticuncle.lunaconfig;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Option<T> {
	private final OptionAccessor<T> valueAccessor;

	public Option(Consumer<T> setter, Supplier<T> getter) {
		this.valueAccessor = new OptionAccessor<>(setter, getter);
	}

	public void setValue(T value) {
		this.valueAccessor.setValue(value);
	}

	public T getValue(T value) {
		return this.valueAccessor.getValue();
	}
}
