package de.his.internal.testdudeles.api.services;

public interface TestDoubleWriter<T> {

    void write(String packageName, T typeSpec);

}
