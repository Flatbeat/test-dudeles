package de.his.internal.testdudeles.api.impl.javapoet.domain.impl.methods;

import java.lang.reflect.Method;

import com.squareup.javapoet.MethodSpec;

import de.his.internal.testdudeles.api.services.TestDudeleMethodFactory;

public enum MethodSpecs {

	;

	public static ReturnPresentFieldMethod returnPresentFieldMethodOrThrow(final Class<? extends Exception> exception, final Method method) {
		return new ReturnPresentFieldMethod(exception, method);
	}

	public static TestDudeleMethodFactory<MethodSpec> thr0w(final Class<? extends Exception> exception) {
		return new ThrowExceptionMethod.Factory(exception);
	}

	public static VoidMethod v0id(final Method method) {
		return new VoidMethod(method);
	}
}
