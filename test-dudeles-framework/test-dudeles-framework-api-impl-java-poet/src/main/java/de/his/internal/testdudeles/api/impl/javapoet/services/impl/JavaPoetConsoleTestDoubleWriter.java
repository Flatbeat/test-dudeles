package de.his.internal.testdudeles.api.impl.javapoet.services.impl;

import java.io.IOException;

import com.squareup.javapoet.JavaFile;

final class JavaPoetConsoleTestDoubleWriter extends JavaPoetTestDoubleWriter {

    @Override
    protected void writeTo(JavaFile javaFile) {
        try {
            javaFile.writeTo(System.out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
