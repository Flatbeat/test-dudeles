package de.his.internal.testdudeles.api.delegates;

import java.lang.reflect.Method;

public enum MethodUtils {

	;

	public static boolean isNoVoidMethod(final Method method) {
		return !isVoidMethod(method);
	}

	public static boolean isVoidMethod(final Method method) {
		return void.class.equals(method.getReturnType());
	}
}
