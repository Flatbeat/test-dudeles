package de.his.internal.testdudeles.api.impl.javapoet.domain.impl.methods;

import static com.google.common.base.Preconditions.checkArgument;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;

import de.his.internal.testdudeles.api.domain.TestDudeleMethod;

abstract class AbstractJavaPoetTestDudeleMethod implements TestDudeleMethod<MethodSpec> {

	private final Method method;

	private final Optional<Class<? extends Exception>> exception;

	protected AbstractJavaPoetTestDudeleMethod(final Class<? extends Exception> exception, final Method method) {
		this.exception = Optional.<Class<? extends Exception>> of(exception);
		this.method = method;
	}

	protected AbstractJavaPoetTestDudeleMethod(final Method method) {
		exception = Optional.absent();
		this.method = method;
	}

	protected Iterable<ParameterSpec> createParameterSpecs() {
		final Builder<ParameterSpec> parameterSpecs = ImmutableList.builder();
		for (final Parameter parameter : method().getParameters()) {
			final TypeName type = TypeName.get(parameter.getType());
			parameterSpecs.add(ParameterSpec.builder(type, parameter.getName()).build());
		}
		return parameterSpecs.build();
	}

	protected Class<? extends Exception> exception() {
		checkArgument(exception.isPresent());
		return exception.get();
	}

	protected Method method() {
		return method;
	}

}
