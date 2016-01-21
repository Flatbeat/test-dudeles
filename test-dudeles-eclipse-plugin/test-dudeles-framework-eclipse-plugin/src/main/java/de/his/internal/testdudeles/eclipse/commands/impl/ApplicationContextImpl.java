package de.his.internal.testdudeles.eclipse.commands.impl;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;

import com.google.common.base.Optional;

import de.his.internal.testdudeles.eclipse.commands.ApplicationContext;

final class ApplicationContextImpl implements ApplicationContext {

	private final Optional<Object> applicationContext;

	public ApplicationContextImpl(final ExecutionEvent event) {
		applicationContext = Optional.fromNullable(event.getApplicationContext());
	}

	@Override
	public Optional<IEvaluationContext> get() {
		if(!applicationContext.isPresent() || !(applicationContext.get() instanceof IEvaluationContext)) {
			return Optional.absent();
		}
		return Optional.of((IEvaluationContext) applicationContext.get());
	}

}
