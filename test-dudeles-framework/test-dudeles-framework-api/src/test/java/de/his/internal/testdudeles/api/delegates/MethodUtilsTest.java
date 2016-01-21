package de.his.internal.testdudeles.api.delegates;

import static de.his.internal.testdudeles.api.delegates.MethodUtils.isNoVoidMethod;
import static de.his.internal.testdudeles.api.delegates.MethodUtils.isVoidMethod;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.Test;

public class MethodUtilsTest {

	@Test
	public void testIsNoVoidMethod() {
		final Method method = NoVoidMethod.class.getMethods()[0];
		assertTrue(isNoVoidMethod(method));
	}

	private interface NoVoidMethod { Integer noVoidMethod(); }

	@Test
	public void testIsVoidMethod() {
		final Method method = VoidMethod.class.getMethods()[0];
		assertTrue(isVoidMethod(method));
	}

	private interface VoidMethod { void voidMethod(); }

}
