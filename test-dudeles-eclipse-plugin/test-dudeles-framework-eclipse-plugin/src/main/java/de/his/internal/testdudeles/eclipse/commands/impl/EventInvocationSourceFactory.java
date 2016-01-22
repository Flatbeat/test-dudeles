package de.his.internal.testdudeles.eclipse.commands.impl;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.base.Optional;

import de.his.internal.testdudeles.eclipse.commands.ApplicationContext;
import de.his.internal.testdudeles.eclipse.commands.EventInvocationSource;
import de.his.internal.testdudeles.eclipse.domain.SourceFile;

final class EventInvocationSourceFactory {

	public EventInvocationSource create(final ExecutionEvent event, final ApplicationContext applicationContext) {
		if(isInvokedOnSelectedFile(event, applicationContext)) {
			final Object selection = getUniqueSelectedElement(applicationContext.get().get()).get();
			return new FileContextMenu(selection);
		} else if (isInvokedInEditorWindow(event)) {
			return new EditorWindow(event);
		}
		return UnsupportedEventInvocationSource.INSTANCE;
	}

	public boolean isInvokedInEditorWindow(final ExecutionEvent event) {
		final Optional<Object> editor = Optional.fromNullable(HandlerUtil.getVariable(event, ISources.ACTIVE_EDITOR_NAME));
		return editor.isPresent() && editor.get() instanceof IEditorPart;
	}

	public boolean isInvokedOnSelectedFile(final ExecutionEvent event, final ApplicationContext applicationContext) {
		final Optional<IEvaluationContext> context = applicationContext.get();
		if(context.isPresent()) {
			final Optional<Object> firstElement = getUniqueSelectedElement(context.get());
			return firstElement.isPresent() && firstElement instanceof IAdaptable;
		}
		return false;
	}

	private Optional<Object> getUniqueSelectedElement(final IEvaluationContext context) {
		final Collection<?> selectedElements = (Collection<?>) context.getDefaultVariable();
		if(selectedElements == null || selectedElements.size() != 1) {
			return Optional.absent();
		}
		return Optional.of(selectedElements.iterator().next());
	}

	enum UnsupportedEventInvocationSource implements EventInvocationSource {

		INSTANCE;

		@Override
		public Optional<SourceFile> file() {
			return Optional.absent();
		}

	}

}
