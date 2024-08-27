package org.lunaticuncle.lunaconfig.gui.signal;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;

public class BiSignal<T, S> {
	private final List<BiConsumer<T, S>> callableList;

	public BiSignal() {
		this.callableList = new LinkedList<>();
	}

	public void connect(BiConsumer<T, S> callable) {
		this.callableList.add(callable);
	}

	public void disconnect(BiConsumer<T, S> callable) {
		this.callableList.remove(callable);
	}

	public void emit(T argT, S argS) {
		for(BiConsumer<T, S> callable : callableList) {
			callable.accept(argT, argS);
		}
	}
}
