package de.his.internal.testdudeles.api.delegates;

import static de.his.internal.testdudeles.api.delegates.MethodUtils.isNoVoidMethod;
import static de.his.internal.testdudeles.api.delegates.MethodUtils.isVoidMethod;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MethodUtilsTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private interface NoVoidMethod {
		Integer noVoidMethod();
	}

	private interface VoidMethod {
		void voidMethod();
	}

	@Test
	public void testIsNoVoidMethod_positive() {
		final Method method = NoVoidMethod.class.getMethods()[0];
		assertTrue(isNoVoidMethod(method));
	}

	@Test
	public void testIsNoVoidMethod_negative() {
		final Method method = VoidMethod.class.getMethods()[0];
		assertFalse(isNoVoidMethod(method));
	}

	@Test
	public void testIsVoidMethod_positive() {
		final Method method = VoidMethod.class.getMethods()[0];
		assertTrue(isVoidMethod(method));
	}

	@Test
	public void testIsVoidMethod_negative() {
		final Method method = NoVoidMethod.class.getMethods()[0];
		assertFalse(isVoidMethod(method));
	}

	@Test
	public void testValues() {
		assertThat(MethodUtils.values()).isEmpty();
	}

	@Test
	public void testValueOf() {
		exception.expect(IllegalArgumentException.class);
		MethodUtils.valueOf("anything");
	}

}
