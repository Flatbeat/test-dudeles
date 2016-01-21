package de.his.internal.testdudeles.api.impl.javapoet.domain.impl.methods;

import static com.google.common.base.Preconditions.checkArgument;
import static com.squareup.javapoet.MethodSpec.methodBuilder;
import static de.his.internal.testdudeles.api.delegates.MethodUtils.isNoVoidMethod;

import java.lang.reflect.Method;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.MethodSpec;

public final class ReturnPresentFieldMethod extends AbstractJavaPoetTestDudeleMethod {

	ReturnPresentFieldMethod(final Class<? extends Exception> exception, final Method method) {
		super(exception, method);
	}

	@Override
	public MethodSpec spec() {
		checkArgument(isNoVoidMethod(method()), "Method has no return value. Apply other <DoNothingMethod> to generate specification!");
		return methodBuilder(method().getName())
				.addAnnotation(Override.class)
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.returns(method().getReturnType())
				.addParameters(createParameterSpecs())
				.addCode(createCode())
				.build();
	}

	private CodeBlock createCode() {
		return CodeBlock.builder()
				.beginControlFlow("if ($N.isPresent())", method().getName())
				.addStatement("return $N.get()", method().getName())
				.endControlFlow()
				.addStatement("throw new $T()", exception())
				.build();
	}

}
