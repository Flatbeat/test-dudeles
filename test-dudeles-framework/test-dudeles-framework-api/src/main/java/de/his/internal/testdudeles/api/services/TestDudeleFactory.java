package de.his.internal.testdudeles.api.services;

import de.his.internal.testdudeles.api.domain.TestDudele;
import de.his.internal.testdudeles.api.domain.TestDudeleType;

public interface TestDudeleFactory<T> {

	TestDudele<T> createFrom(TestDudeleType type);

}
