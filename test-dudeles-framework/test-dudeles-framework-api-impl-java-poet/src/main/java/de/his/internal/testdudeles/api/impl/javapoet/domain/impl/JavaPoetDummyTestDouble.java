package de.his.internal.testdudeles.api.impl.javapoet.domain.impl;

import static com.squareup.javapoet.MethodSpec.methodBuilder;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;

import de.his.internal.testdudeles.api.domain.TestDudeleConstructor;
import de.his.internal.testdudeles.api.domain.TestDudeleFields;
import de.his.internal.testdudeles.api.domain.TestDudeleMethods;
import de.his.internal.testdudeles.api.domain.TestDudeleType;

public final class JavaPoetDummyTestDouble extends AbstractJavaPoetTestDudele {

	public JavaPoetDummyTestDouble(final TestDudeleType type, final TestDudeleFields<FieldSpec> fields,
			final TestDudeleConstructor<MethodSpec> constructor, final TestDudeleMethods<MethodSpec> methods) {
		super(type, fields, constructor, methods);
	}

	@Override
	protected String getTestDoubleSuffix() {
		return "Dummy";
	}

	@Override
	public MethodSpec factoryMethod(final String packageName) {
		final ClassName testDouble = ClassName.get(packageName, name());
		return methodBuilder("dummy")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
				.returns(getTypeName())
				.addStatement("return new $T()", testDouble)
				.build();
	}

}
