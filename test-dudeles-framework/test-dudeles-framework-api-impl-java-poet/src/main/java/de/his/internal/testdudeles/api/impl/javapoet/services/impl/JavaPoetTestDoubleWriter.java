package de.his.internal.testdudeles.api.impl.javapoet.services.impl;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import de.his.internal.testdudeles.api.services.TestDoubleWriter;

abstract class JavaPoetTestDoubleWriter implements TestDoubleWriter<TypeSpec> {

	@Override
	public final void write(final String packageName, final TypeSpec typeSpec) {
		final JavaFile javaFile = JavaFile.builder(packageName, typeSpec).build();
		writeTo(javaFile);
	}

	protected abstract void writeTo(JavaFile javaFile);

}
