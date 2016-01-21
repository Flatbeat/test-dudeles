package de.his.internal.testdudeles.api.impl.javapoet.services.impl;

import static de.his.internal.testdudeles.api.impl.javapoet.domain.impl.constructor.ConstructorSpecs.packagePrivateNoArgumentConstructor;
import static de.his.internal.testdudeles.api.impl.javapoet.domain.impl.fields.FieldSpecs.noFields;
import static de.his.internal.testdudeles.api.impl.javapoet.domain.impl.methods.MethodSpecs.thr0w;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import de.his.internal.testdudeles.api.domain.TestDudele;
import de.his.internal.testdudeles.api.domain.TestDudeleConstructor;
import de.his.internal.testdudeles.api.domain.TestDudeleFields;
import de.his.internal.testdudeles.api.domain.TestDudeleMethods;
import de.his.internal.testdudeles.api.domain.TestDudeleType;
import de.his.internal.testdudeles.api.exceptions.DummyTestDoubleInteractionException;
import de.his.internal.testdudeles.api.impl.javapoet.domain.impl.JavaPoetDummyTestDouble;

public final class JavaPoetDummyTestDoubleFactory extends AbstractJavaPoetTestDoubleFactory {

	public JavaPoetDummyTestDoubleFactory() {
		super(noFields(), packagePrivateNoArgumentConstructor(), thr0w(DummyTestDoubleInteractionException.class));
	}

	@Override
	protected TestDudele<TypeSpec> newTestDudeleInstance(final TestDudeleType type, final TestDudeleFields<FieldSpec> fields,
			final TestDudeleConstructor<MethodSpec> constructor, final TestDudeleMethods<MethodSpec> methods) {
		return new JavaPoetDummyTestDouble(type, fields, constructor, methods);
	}

}
