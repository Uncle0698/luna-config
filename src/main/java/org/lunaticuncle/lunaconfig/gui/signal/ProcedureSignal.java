package org.lunaticuncle.lunaconfig.gui.signal;

import java.util.LinkedList;
import java.util.List;

public class ProcedureSignal {
	private final List<Procedure> callableList;

	public ProcedureSignal() {
		this.callableList = new LinkedList<>();
	}

	public void connect(Procedure callable) {
		this.callableList.add(callable);
	}

	public void disconnect(Procedure callable) {
		this.callableList.remove(callable);
	}

	public void emit() {
		for(Procedure callable : callableList) {
			callable.invoke();
		}
	}

}
