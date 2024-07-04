package org.lunaticuncle.lunaconfig;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionAccessor<T> {

	private final Consumer<T> setter;
	private final Supplier<T> getter;

	public OptionAccessor(Consumer<T> setter, Supplier<T> getter) {
		this.setter = setter;
		this.getter = getter;
	}

	public void setValue(T value) {
		setter.accept(value);
	}

	public T getValue() {
		return getter.get();
	}

}
