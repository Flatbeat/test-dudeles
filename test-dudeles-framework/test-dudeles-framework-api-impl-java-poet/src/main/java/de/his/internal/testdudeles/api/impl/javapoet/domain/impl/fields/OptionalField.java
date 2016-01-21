package de.his.internal.testdudeles.api.impl.javapoet.domain.impl.fields;

import com.google.common.base.Optional;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

final class OptionalField extends AbstractJavaPoetTestDudeleField {

	private final CodeBlock initializer;

	OptionalField(final String name, final Class<?> type, final CodeBlock initializer) {
		super(name, type);
		this.initializer = initializer;
	}

	@Override
	protected TypeName fieldType() {
		return ParameterizedTypeName.get(Optional.class, type());
	}

	@Override
	protected CodeBlock initializer() {
		return initializer;
	}

}
