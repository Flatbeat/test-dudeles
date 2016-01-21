package de.his.internal.testdudeles.api.impl.javapoet.services.impl;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import de.his.internal.testdudeles.api.services.TestDudeleConstructorFactory;
import de.his.internal.testdudeles.api.services.TestDudeleFieldFactory;
import de.his.internal.testdudeles.api.services.TestDudeleMethodFactory;
import de.his.internal.testdudeles.api.services.impl.AbstractTestDudeleFactory;

abstract class AbstractJavaPoetTestDoubleFactory extends AbstractTestDudeleFactory<TypeSpec, FieldSpec, MethodSpec> {

	protected AbstractJavaPoetTestDoubleFactory(final TestDudeleFieldFactory<FieldSpec> fieldFactory,
			final TestDudeleConstructorFactory<MethodSpec> constructorFactory,
			final TestDudeleMethodFactory<MethodSpec> methodFactory) {
		super(fieldFactory, constructorFactory, methodFactory);
	}

	//	private final Optional<FieldSpecification<FieldSpec>> fieldBuilder;
	//
	//	private final ConstructorSpecification<MethodSpec> constructorBuilder;
	//
	//
	//	protected AbstractJavaPoetTestDoubleFactory(final FieldSpecification<FieldSpec> fieldSpecBuilderStrategy,
	//			final ConstructorSpecification<MethodSpec> constructorSpecBuilderStrategy) {
	//		fieldBuilder = Optional.of(fieldSpecBuilderStrategy);
	//		constructorBuilder = constructorSpecBuilderStrategy;
	//	}
	//
	//	protected AbstractJavaPoetTestDoubleFactory(final ConstructorSpecification<MethodSpec> constructorSpecBuilderStrategy) {
	//		fieldBuilder = Optional.absent();
	//		constructorBuilder = constructorSpecBuilderStrategy;
	//	}
	//
	//	@Override
	//	public final TestDudeleType<MethodSpec, TypeSpec> create(final ClassSpecification spec) {
	//		final Collection<FieldSpec> fields = fieldBuilder.isPresent() ? createFieldSpecifications(spec) : Collections.<FieldSpec> emptyList();
	//		final MethodSpec constructor = constructorBuilder.spec(spec);
	//		final Collection<MethodSpec> methods = createMethodSpecifications(spec);
	//		return newTestDoubleInstance((JavaPoetTestDudeleType) spec, fields, constructor, methods);
	//	}
	//
	//	private Collection<FieldSpec> createFieldSpecifications(final ClassSpecification spec) {
	//		final Builder<FieldSpec> fields = ImmutableList.builder();
	//		for (final Method method : spec.getAllMethodsWithReturnValues()) {
	//			fields.add(fieldBuilder.get().spec(method));
	//		}
	//		return fields.build();
	//	}
	//
	//	private Collection<MethodSpec> createMethodSpecifications(final ClassSpecification spec) {
	//		final Builder<MethodSpec> methods = ImmutableList.builder();
	//		for (final Method method : spec.getAllMethods()) {
	//			methods.addAll(createForAllMethods(method));
	//		}
	//		return methods.build();
	//	}
	//
	//	protected abstract Collection<MethodSpec> createForAllMethods(Method method);
	//
	//	protected abstract TestDudeleType<MethodSpec, TypeSpec> newTestDoubleInstance(JavaPoetTestDudeleType spec, Collection<FieldSpec> fields,
	//			MethodSpec constructor, Collection<MethodSpec> methods);

}
