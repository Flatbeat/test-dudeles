package de.his.internal.testdudeles.api.impl.javapoet.domain.impl.constructor;

import static com.squareup.javapoet.MethodSpec.constructorBuilder;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.MethodSpec;

import de.his.internal.testdudeles.api.domain.TestDudeleConstructor;
import de.his.internal.testdudeles.api.domain.TestDudeleType;
import de.his.internal.testdudeles.api.services.TestDudeleConstructorFactory;

final class NoArgumentConstructor implements TestDudeleConstructor<MethodSpec>, TestDudeleConstructorFactory<MethodSpec> {

	private final Modifier[] modifier;

	NoArgumentConstructor(final Modifier... modifier) {
		this.modifier = modifier;
	}

	@Override
	public MethodSpec spec() {
		return constructorBuilder().addModifiers(modifier).build();
	}

	@Override
	public TestDudeleConstructor<MethodSpec> createFrom(final TestDudeleType type) {
		return this;
	}

}
