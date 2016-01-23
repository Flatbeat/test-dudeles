package de.his.internal.testdudeles.api.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Collection;

import org.junit.Test;

public class AbstractTestDudeleTypeTest {

  @Test
  public void testIsJDKClass_positive_whenPrimitiveType() throws Exception {
    assertTrue(new MyTestTestDudele(int.class).isJDKClass());
  }

  @Test
  public void testIsJDKClass_positive_whenPrimitiveWrapperType() throws Exception {
    assertTrue(new MyTestTestDudele(Integer.class).isJDKClass());
  }

  @Test
  public void testIsJDKClass_negative() throws Exception {
    assertFalse(new MyTestTestDudele(MyTestTestDudele.class).isJDKClass());
  }

  @Test
  public void testClazz() throws Exception {
    final Class<?> clazz = new MyTestTestDudele(String.class).clazz();
    assertThat(clazz).isExactlyInstanceOf(Class.class);
  }

  @Test
  public void testAllMethods() throws Exception {
    final MyTestTestDudele type = new MyTestTestDudele(MyTestTestDudele.class);
    final Collection<Method> methods = type.allMethods();
    assertThat(methods).containsExactly(MyTestTestDudele.class.getDeclaredMethods());
  }

  @Test
  public void testAllMethodsWithReturnValues() throws Exception {
    final MyTestTestDudele type = new MyTestTestDudele(MyTestTestDudele.class);
    final Collection<Method> methods = type.allMethodsWithReturnValues();
    assertThat(methods).contains(MyTestTestDudele.class.getMethod("stringMethod"));
  }

  @Test
  public void testAllMethodsWithVoidReturnValues() throws Exception {
    final MyTestTestDudele type = new MyTestTestDudele(MyTestTestDudele.class);
    final Collection<Method> methods = type.allMethodsWithVoidReturnValues();
    assertThat(methods).containsExactly(MyTestTestDudele.class.getMethod("voidMethod"));
  }

  @Test
  public void testType() throws Exception {
    final MyTestTestDudele type = new MyTestTestDudele(MyTestTestDudele.class);
    assertThat(type.type()).hasSameClassAs(MyTestTestDudele.class);
  }

}
