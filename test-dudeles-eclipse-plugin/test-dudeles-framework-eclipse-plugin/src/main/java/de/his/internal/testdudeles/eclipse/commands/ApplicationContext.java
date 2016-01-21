package de.his.internal.testdudeles.eclipse.commands;

import org.eclipse.core.expressions.IEvaluationContext;

import com.google.common.base.Optional;

public interface ApplicationContext {

	public Optional<IEvaluationContext> get();

}
