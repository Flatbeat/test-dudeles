package de.his.internal.testdudeles.api.impl.javapoet.domain.impl.methods;

import static com.google.common.base.Preconditions.checkArgument;
import static com.squareup.javapoet.MethodSpec.methodBuilder;
import static de.his.internal.testdudeles.api.delegates.MethodUtils.isVoidMethod;

import java.lang.reflect.Method;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.MethodSpec;
public final class VoidMethod extends AbstractJavaPoetTestDudeleMethod {

	VoidMethod(final Method method) {
		super(method);
	}

	@Override
	public MethodSpec spec() {
		checkArgument(isVoidMethod(method()), "Method has return value. Apply other <MethodSpecification> to generate specification!");
		return methodBuilder(method().getName())
				.addAnnotation(Override.class)
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.returns(void.class)
				.addParameters(createParameterSpecs())
				.addCode("// do nothing")
				.build();
	}

}
