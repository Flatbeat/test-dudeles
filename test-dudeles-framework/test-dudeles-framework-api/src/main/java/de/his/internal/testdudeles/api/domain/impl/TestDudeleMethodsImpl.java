package de.his.internal.testdudeles.api.domain.impl;

import java.util.Collection;
import java.util.Iterator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import de.his.internal.testdudeles.api.domain.TestDudeleMethod;
import de.his.internal.testdudeles.api.domain.TestDudeleMethods;

public class TestDudeleMethodsImpl<T> implements TestDudeleMethods<T> {

  private final Collection<TestDudeleMethod<T>> methods;

  public TestDudeleMethodsImpl(final Collection<TestDudeleMethod<T>> methods) {
    this.methods = methods;
  }

  @Override
  public Iterator<T> iterator() {
    final Builder<T> specs = ImmutableList.builder();
    for (final TestDudeleMethod<T> method : methods) {
      specs.add(method.spec());
    }
    return specs.build().iterator();
  }

}
