package de.his.internal.testdudeles.api.services.impl;

import de.his.internal.testdudeles.api.domain.TestDudele;
import de.his.internal.testdudeles.api.domain.TestDudeleConstructor;
import de.his.internal.testdudeles.api.domain.TestDudeleFields;
import de.his.internal.testdudeles.api.domain.TestDudeleMethods;
import de.his.internal.testdudeles.api.domain.TestDudeleType;
import de.his.internal.testdudeles.api.services.TestDudeleConstructorFactory;
import de.his.internal.testdudeles.api.services.TestDudeleFactory;
import de.his.internal.testdudeles.api.services.TestDudeleFieldFactory;
import de.his.internal.testdudeles.api.services.TestDudeleMethodFactory;

public abstract class AbstractTestDudeleFactory<T, F, M> implements TestDudeleFactory<T> {

	private final TestDudeleFieldFactory<F> fieldFactory;

	private final TestDudeleConstructorFactory<M> constructorFactory;

	private final TestDudeleMethodFactory<M> methodFactory;

	protected AbstractTestDudeleFactory(final TestDudeleFieldFactory<F> fieldFactory,
			final TestDudeleConstructorFactory<M> constructorFactory,
			final TestDudeleMethodFactory<M> methodFactory) {
		this.fieldFactory = fieldFactory;
		this.constructorFactory = constructorFactory;
		this.methodFactory = methodFactory;
	}

	@Override
	public final TestDudele<T> createFrom(final TestDudeleType type) {
		final TestDudeleFields<F> fields = fieldFactory.createFrom(type);
		final TestDudeleConstructor<M> constructor = constructorFactory.createFrom(type);
		final TestDudeleMethods<M> methods = methodFactory.createFrom(type);
		return newTestDudeleInstance(type, fields, constructor, methods);
	}

	protected abstract TestDudele<T> newTestDudeleInstance(TestDudeleType type,
			TestDudeleFields<F> fields,
			TestDudeleConstructor<M> constructor,
			TestDudeleMethods<M> methods);

}
