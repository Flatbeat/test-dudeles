package de.his.internal.testdudeles.api.domain.impl;

import static com.google.common.collect.Lists.newArrayList;
import static de.his.internal.testdudeles.api.delegates.MethodUtils.isNoVoidMethod;
import static de.his.internal.testdudeles.api.delegates.MethodUtils.isVoidMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import de.his.internal.testdudeles.api.domain.TestDudeleType;

public abstract class AbstractTestDudeleType implements TestDudeleType {

  private final Class<?> clazz;

  protected AbstractTestDudeleType(final Class<?> clazz) {
    this.clazz = clazz;
  }

  protected final boolean isJDKClass() {
    return clazz.isPrimitive() || clazz.getPackage().getName().startsWith("java");
  }

  protected final Class<?> clazz() {
    return clazz;
  }

  @Override
  public Collection<Method> allMethods() {
    return newArrayList(clazz().getMethods());
  }

  @Override
  public Collection<Method> allMethodsWithReturnValues() {
    final Builder<Method> methods = ImmutableList.builder();
    for (final Method method : allMethods()) {
      if (isNoVoidMethod(method)) {
        methods.add(method);
      }
    }
    return methods.build();
  }

  @Override
  public Collection<Method> allMethodsWithVoidReturnValues() {
    final Builder<Method> methods = ImmutableList.builder();
    for (final Method method : allMethods()) {
      if (isVoidMethod(method)) {
        methods.add(method);
      }
    }
    return methods.build();
  }

  @Override
  public Type type() {
    return clazz;
  }

}
