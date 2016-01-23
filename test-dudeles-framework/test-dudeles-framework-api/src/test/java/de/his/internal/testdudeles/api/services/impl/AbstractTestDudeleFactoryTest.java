package de.his.internal.testdudeles.api.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import de.his.internal.testdudeles.api.domain.TestDudele;
import de.his.internal.testdudeles.api.domain.TestDudeleConstructor;
import de.his.internal.testdudeles.api.domain.TestDudeleFields;
import de.his.internal.testdudeles.api.domain.TestDudeleMethods;
import de.his.internal.testdudeles.api.domain.TestDudeleType;
import de.his.internal.testdudeles.api.domain.impl.MyTestTestDudele;
import de.his.internal.testdudeles.api.services.TestDudeleConstructorFactory;
import de.his.internal.testdudeles.api.services.TestDudeleFieldFactory;
import de.his.internal.testdudeles.api.services.TestDudeleMethodFactory;

public class AbstractTestDudeleFactoryTest {

  private TestDudeleFieldFactory<String> fieldFactory;

  private TestDudeleConstructorFactory<String> constructorFactory;

  private TestDudeleMethodFactory<String> methodFactory;

  @Before
  @SuppressWarnings("unchecked")
  public void mockFactories() {
    fieldFactory = mock(TestDudeleFieldFactory.class);
    constructorFactory = mock(TestDudeleConstructorFactory.class);
    methodFactory = mock(TestDudeleMethodFactory.class);
  }

  @Test
  public void testCreateFrom() throws Exception {
    final MyTestTestDudele type = new MyTestTestDudele(MyTestTestDudele.class);
    final MyTestFactory factory = new MyTestFactory(fieldFactory, constructorFactory, methodFactory);
    final TestDudele<String> dudele = factory.createFrom(type);
    assertThat(dudele.name()).isEqualTo("TestDudele");
    assertThat(dudele.spec()).isEqualTo("TestDudeleSpec");
  }

  static final class MyTestFactory extends AbstractTestDudeleFactory<String, String, String> {

    protected MyTestFactory(final TestDudeleFieldFactory<String> fieldFactory,
        final TestDudeleConstructorFactory<String> constructorFactory,
        final TestDudeleMethodFactory<String> methodFactory) {
      super(fieldFactory, constructorFactory, methodFactory);
    }

    @Override
    protected TestDudele<String> newTestDudeleInstance(final TestDudeleType type,
        final TestDudeleFields<String> fields, final TestDudeleConstructor<String> constructor,
        final TestDudeleMethods<String> methods) {
      return new TestDudele<String>() {

        @Override
        public String spec() {
          return "TestDudeleSpec";
        }

        @Override
        public String name() {
          return "TestDudele";
        }
      };
    }

  }
}
