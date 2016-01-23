package de.his.internal.testdudeles.api.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DummyTestDoubleInteractionExceptionTest {

	@Test
	public void testGetMessage() throws Exception {
		final DummyTestDoubleInteractionException exception = new DummyTestDoubleInteractionException();
		assertThat(exception).hasMessage("Dummy test doubles are not intended for use!");
	}

}
