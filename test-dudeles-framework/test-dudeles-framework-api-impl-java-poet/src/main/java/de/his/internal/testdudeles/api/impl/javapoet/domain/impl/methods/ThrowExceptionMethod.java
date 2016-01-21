package de.his.internal.testdudeles.api.impl.javapoet.domain.impl.methods;

import static com.squareup.javapoet.MethodSpec.methodBuilder;

import java.lang.reflect.Method;

import javax.lang.model.element.Modifier;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.squareup.javapoet.MethodSpec;

import de.his.internal.testdudeles.api.domain.TestDudeleMethod;
import de.his.internal.testdudeles.api.domain.TestDudeleMethods;
import de.his.internal.testdudeles.api.domain.TestDudeleType;
import de.his.internal.testdudeles.api.domain.impl.TestDudeleMethodsImpl;
import de.his.internal.testdudeles.api.services.TestDudeleMethodFactory;

final class ThrowExceptionMethod extends AbstractJavaPoetTestDudeleMethod implements TestDudeleMethod<MethodSpec> {

	ThrowExceptionMethod(final Class<? extends Exception> exception, final Method method) {
		super(exception, method);
	}

	@Override
	public MethodSpec spec() {
		return methodBuilder(method().getName())
				.addAnnotation(Override.class)
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.returns(method().getReturnType())
				.addParameters(createParameterSpecs())
				.addStatement("throw new $T()", exception())
				.build();
	}

	static final class Factory implements TestDudeleMethodFactory<MethodSpec> {

		private final Class<? extends Exception> exception;

		public Factory(final Class<? extends Exception> exception) {
			this.exception = exception;
		}

		@Override
		public TestDudeleMethods<MethodSpec> createFrom(final TestDudeleType type) {
			final Builder<TestDudeleMethod<MethodSpec>> methods = ImmutableList.builder();
			for (final Method method : type.allMethods()) {
				methods.add(new ThrowExceptionMethod(exception, method));
			}
			return new TestDudeleMethodsImpl<MethodSpec>(methods.build());
		}
	}

}
