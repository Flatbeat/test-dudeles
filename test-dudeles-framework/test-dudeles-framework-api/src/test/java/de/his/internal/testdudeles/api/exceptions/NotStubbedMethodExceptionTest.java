package de.his.internal.testdudeles.api.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class NotStubbedMethodExceptionTest {

	@Test
	public void testGetMessage() throws Exception {
		final NotStubbedMethodException exception = new NotStubbedMethodException();
		assertThat(exception).hasMessage("Stub test double method not properly initialized!");
	}

}
