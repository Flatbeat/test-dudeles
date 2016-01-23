package de.his.internal.testdudeles.api.domain.impl;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Test;

import de.his.internal.testdudeles.api.domain.TestDudeleMethod;

public class TestDudeleMethodsImplTest {

	@Test
	public void testIterator_isEmpty() {
		final TestDudeleMethodsImpl<String> methods = new TestDudeleMethodsImpl<>(Collections.emptyList());
		assertThat(methods).isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testIterator_isNotEmpty() {
		final TestDudeleMethod<String> method = mock(TestDudeleMethod.class);
		when(method.spec()).thenReturn("MySpec");
		final TestDudeleMethodsImpl<String> methods = new TestDudeleMethodsImpl<>(newArrayList(method));
		assertThat(methods).containsExactly(method.spec());
	}

}
