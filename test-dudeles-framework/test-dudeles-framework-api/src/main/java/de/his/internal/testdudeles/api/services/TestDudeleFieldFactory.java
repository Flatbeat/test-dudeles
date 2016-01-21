package de.his.internal.testdudeles.api.services;

import de.his.internal.testdudeles.api.domain.TestDudeleFields;
import de.his.internal.testdudeles.api.domain.TestDudeleType;

public interface TestDudeleFieldFactory<T> {

	TestDudeleFields<T> createFrom(TestDudeleType type);

}
