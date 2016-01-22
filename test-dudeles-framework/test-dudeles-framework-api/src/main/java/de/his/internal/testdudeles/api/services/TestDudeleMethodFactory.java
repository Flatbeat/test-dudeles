package de.his.internal.testdudeles.api.services;

import de.his.internal.testdudeles.api.domain.TestDudeleMethods;
import de.his.internal.testdudeles.api.domain.TestDudeleType;

public interface TestDudeleMethodFactory<T> {

  TestDudeleMethods<T> createFrom(TestDudeleType type);

}
