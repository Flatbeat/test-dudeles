package de.his.internal.testdudeles.api.impl.javapoet.services.impl;

import java.io.File;

import com.squareup.javapoet.TypeSpec;

import de.his.internal.testdudeles.api.services.TestDoubleWriter;

public final class JavaPoetTestDoubleWriterFactory {

	public static final TestDoubleWriter<TypeSpec> console() {
		return new JavaPoetConsoleTestDoubleWriter();
	}

	public static final TestDoubleWriter<TypeSpec> directory(final File directory) {
		return new JavaPoetFileTestDoubleWriter(directory);
	}

}
