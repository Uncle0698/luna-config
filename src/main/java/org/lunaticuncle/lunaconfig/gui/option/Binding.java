package org.lunaticuncle.lunaconfig.gui.option;

public interface Binding<T> {
	void setValue(T value);
	T getValue();
}
