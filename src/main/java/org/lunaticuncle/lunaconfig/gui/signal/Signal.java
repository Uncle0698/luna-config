package org.lunaticuncle.lunaconfig.gui.signal;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

// Not thread safe
public class Signal<T> {
	private final List<Consumer<T>> callableList;

	public Signal() {
		this.callableList = new LinkedList<>();
	}

	public void connect(Consumer<T> callable) {
		this.callableList.add(callable);
	}

	public void disconnect(Consumer<T> callable) {
		this.callableList.remove(callable);
	}

	public void emit(T arg) {
		for(Consumer<T> callable : callableList) {
			callable.accept(arg);
		}
	}
}
