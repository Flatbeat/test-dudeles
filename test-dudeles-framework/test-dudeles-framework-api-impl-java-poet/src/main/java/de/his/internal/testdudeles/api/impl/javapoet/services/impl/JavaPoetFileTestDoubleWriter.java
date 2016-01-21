package de.his.internal.testdudeles.api.impl.javapoet.services.impl;

import java.io.File;
import java.io.IOException;

import com.squareup.javapoet.JavaFile;

final class JavaPoetFileTestDoubleWriter extends JavaPoetTestDoubleWriter {

    private final File directory;

    JavaPoetFileTestDoubleWriter(File directory) {
        this.directory = directory;
    }

    @Override
    protected void writeTo(JavaFile javaFile) {
        try {
            javaFile.writeTo(directory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
