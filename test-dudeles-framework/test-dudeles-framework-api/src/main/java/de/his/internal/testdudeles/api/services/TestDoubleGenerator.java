package de.his.internal.testdudeles.api.services;

public interface TestDoubleGenerator {

    void generateTestDoubles(String packageName, Class<?> clazz);

    void generateTestDoublesBuilder(String packageName, Class<?> clazz);

}
