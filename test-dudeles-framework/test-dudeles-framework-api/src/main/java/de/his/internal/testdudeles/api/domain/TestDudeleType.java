package de.his.internal.testdudeles.api.domain;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;

public interface TestDudeleType {

  Collection<Method> allMethods();

  Collection<Method> allMethodsWithReturnValues();

  Collection<Method> allMethodsWithVoidReturnValues();

  Type type();

}
