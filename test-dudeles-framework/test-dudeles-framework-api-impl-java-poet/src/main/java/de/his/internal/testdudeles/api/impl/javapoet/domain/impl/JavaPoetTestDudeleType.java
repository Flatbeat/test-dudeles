package de.his.internal.testdudeles.api.impl.javapoet.domain.impl;

import com.squareup.javapoet.TypeName;

import de.his.internal.testdudeles.api.domain.impl.AbstractTestDudeleType;
import de.his.internal.testdudeles.api.impl.javapoet.domain.TypeNameProvider;

public final class JavaPoetTestDudeleType extends AbstractTestDudeleType implements TypeNameProvider {

	public JavaPoetTestDudeleType(final Class<?> clazz) {
		super(clazz);
	}

	@Override
	public TypeName getTypeName() {
		return TypeName.get(type());
	}

}
