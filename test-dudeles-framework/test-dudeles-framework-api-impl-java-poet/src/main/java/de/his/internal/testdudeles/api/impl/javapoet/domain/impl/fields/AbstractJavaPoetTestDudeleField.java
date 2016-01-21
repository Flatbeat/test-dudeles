package de.his.internal.testdudeles.api.impl.javapoet.domain.impl.fields;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeName;

import de.his.internal.testdudeles.api.domain.TestDudeleField;

abstract class AbstractJavaPoetTestDudeleField implements TestDudeleField<FieldSpec> {

	private final String name;

	private final Class<?> type;

	protected AbstractJavaPoetTestDudeleField(final String name, final Class<?> type) {
		this.name = name;
		this.type = type;
	}

	protected Class<?> type() {
		return type;
	}

	@Override
	public FieldSpec spec() {
		return FieldSpec.builder(fieldType(), name, Modifier.FINAL)
				.initializer(initializer())
				.build();
	}

	protected abstract TypeName fieldType();

	protected abstract CodeBlock initializer();

}