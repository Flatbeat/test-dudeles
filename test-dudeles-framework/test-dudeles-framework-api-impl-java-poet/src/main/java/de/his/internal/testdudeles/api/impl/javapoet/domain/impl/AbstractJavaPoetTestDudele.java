package de.his.internal.testdudeles.api.impl.javapoet.domain.impl;

import static com.squareup.javapoet.TypeSpec.classBuilder;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import de.his.internal.testdudeles.api.domain.TestDudele;
import de.his.internal.testdudeles.api.domain.TestDudeleConstructor;
import de.his.internal.testdudeles.api.domain.TestDudeleFields;
import de.his.internal.testdudeles.api.domain.TestDudeleMethods;
import de.his.internal.testdudeles.api.domain.TestDudeleType;

public abstract class AbstractJavaPoetTestDudele implements TestDudele<TypeSpec> {

	private final TestDudeleType type;

	private final TestDudeleFields<FieldSpec> fields;

	private final TestDudeleConstructor<MethodSpec> constructor;

	private final TestDudeleMethods<MethodSpec> methods;

	protected AbstractJavaPoetTestDudele(final TestDudeleType type, final TestDudeleFields<FieldSpec> fields,
			final TestDudeleConstructor<MethodSpec> constructor, final TestDudeleMethods<MethodSpec> methods) {
		this.type = type;
		this.fields = fields;
		this.constructor = constructor;
		this.methods = methods;
	}

	@Override
	public final TypeSpec spec() {
		final TypeSpec.Builder clazz = classBuilder(name())
				.addModifiers(Modifier.FINAL)
				.addSuperinterface(getTypeName())
				.addFields(fields)
				.addMethod(constructor.spec())
				.addMethods(methods);
		return clazz.build();
	}

	@Override
	public final String name() {
		return ((ClassName) getTypeName()).simpleName() + getTestDoubleSuffix();
	}

	protected abstract String getTestDoubleSuffix();

	protected TypeName getTypeName() {
		return TypeName.get(type.type());
	}

	public abstract MethodSpec factoryMethod(String packageName);

}
