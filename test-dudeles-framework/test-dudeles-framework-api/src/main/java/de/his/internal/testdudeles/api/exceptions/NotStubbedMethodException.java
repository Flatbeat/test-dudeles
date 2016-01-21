package de.his.internal.testdudeles.api.exceptions;

public final class NotStubbedMethodException extends RuntimeException {

	private static final long serialVersionUID = 2442652734472041903L;

	@Override
	public String getMessage() {
		return "Stub test double method not properly initialized!";
	}

}
