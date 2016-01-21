package de.his.internal.testdudeles.api.impl.javapoet.domain.impl.fields;

import java.util.Collections;
import java.util.Iterator;

import com.squareup.javapoet.FieldSpec;

import de.his.internal.testdudeles.api.domain.TestDudeleFields;
import de.his.internal.testdudeles.api.domain.TestDudeleType;
import de.his.internal.testdudeles.api.services.TestDudeleFieldFactory;

final class EmptyFields implements TestDudeleFields<FieldSpec>, TestDudeleFieldFactory<FieldSpec> {

	@Override
	public Iterator<FieldSpec> iterator() {
		return Collections.<FieldSpec> emptyList().iterator();
	}

	@Override
	public TestDudeleFields<FieldSpec> createFrom(final TestDudeleType type) {
		return this;
	}

}
