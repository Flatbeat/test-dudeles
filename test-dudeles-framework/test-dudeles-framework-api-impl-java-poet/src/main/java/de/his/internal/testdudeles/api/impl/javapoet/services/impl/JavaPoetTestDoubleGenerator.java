package de.his.internal.testdudeles.api.impl.javapoet.services.impl;

import static com.squareup.javapoet.TypeSpec.classBuilder;

import java.util.Collection;

import javax.lang.model.element.Modifier;

import com.google.common.collect.ImmutableList;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import de.his.internal.testdudeles.api.domain.TestDudele;
import de.his.internal.testdudeles.api.domain.TestDudeleType;
import de.his.internal.testdudeles.api.impl.javapoet.domain.impl.AbstractJavaPoetTestDudele;
import de.his.internal.testdudeles.api.impl.javapoet.domain.impl.JavaPoetTestDudeleType;
import de.his.internal.testdudeles.api.services.TestDoubleGenerator;
import de.his.internal.testdudeles.api.services.TestDoubleWriter;
import de.his.internal.testdudeles.api.services.TestDudeleFactory;

public final class JavaPoetTestDoubleGenerator implements TestDoubleGenerator {

	private final Collection<TestDudeleFactory<TypeSpec>> testDudelesFactories;

	private final TestDoubleWriter<TypeSpec> writer;

	public JavaPoetTestDoubleGenerator(final TestDoubleWriter<TypeSpec> writer) {
		testDudelesFactories = ImmutableList.<TestDudeleFactory<TypeSpec>> of(new JavaPoetDummyTestDoubleFactory());
		this.writer = writer;
	}

	@Override
	public void generateTestDoubles(final String packageName, final Class<?> clazz) {
		final TestDudeleType type = new JavaPoetTestDudeleType(clazz);
		for (final TestDudeleFactory<TypeSpec> factory : testDudelesFactories) {
			final TestDudele<TypeSpec> dudele = factory.createFrom(type);
			writer.write(packageName, dudele.spec());
		}
	}

	@Override
	public void generateTestDoublesBuilder(final String packageName, final Class<?> clazz) {
		final JavaPoetTestDudeleType type = new JavaPoetTestDudeleType(clazz);
		final TypeSpec.Builder builderSpec = classBuilder(((ClassName) type.getTypeName()).simpleName() + "TestDoubles")
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL);
		for (final TestDudeleFactory<TypeSpec> factory : testDudelesFactories) {
			final AbstractJavaPoetTestDudele dudele = (AbstractJavaPoetTestDudele) factory.createFrom(type);
			final MethodSpec factoryMethod = dudele.factoryMethod(packageName);
			builderSpec.addMethod(factoryMethod);
		}
		writer.write(packageName, builderSpec.build());
	}

}
