package de.his.internal.testdudeles.api.impl.javapoet.domain.impl.constructor;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.MethodSpec;

import de.his.internal.testdudeles.api.services.TestDudeleConstructorFactory;

public enum ConstructorSpecs {

	;

	public static TestDudeleConstructorFactory<MethodSpec> packagePrivateNoArgumentConstructor() {
		return new NoArgumentConstructor();
	}

	public static TestDudeleConstructorFactory<MethodSpec> publicNoArgumentConstructor() {
		return new NoArgumentConstructor(Modifier.PUBLIC);
	}
}
