package de.his.internal.testdudeles.api.impl.javapoet.domain.impl.fields;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;

import de.his.internal.testdudeles.api.services.TestDudeleFieldFactory;

public enum FieldSpecs {

	;

	public static TestDudeleFieldFactory<FieldSpec> noFields() {
		return new EmptyFields();
	}

	public static AbstractJavaPoetTestDudeleField absent(final String name, final Class<?> type) {
		final CodeBlock initializer = CodeBlock.builder().add("Optional.absent()").build();
		return new OptionalField(name, type, initializer);
	}

	public static AbstractJavaPoetTestDudeleField present(final String name, final Class<?> type) {
		final CodeBlock initializer = CodeBlock.builder().add("Optional.of($N)", name).build();
		return new OptionalField(name, type, initializer);
	}

}
