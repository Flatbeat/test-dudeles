package de.his.internal.testdudeles.api.services;

import de.his.internal.testdudeles.api.domain.TestDudeleConstructor;
import de.his.internal.testdudeles.api.domain.TestDudeleType;

public interface TestDudeleConstructorFactory<T> {

	TestDudeleConstructor<T> createFrom(TestDudeleType type);

}
