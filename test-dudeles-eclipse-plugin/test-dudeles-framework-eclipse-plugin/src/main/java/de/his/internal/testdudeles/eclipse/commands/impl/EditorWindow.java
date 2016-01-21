package de.his.internal.testdudeles.eclipse.commands.impl;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.base.Optional;

import de.his.internal.testdudeles.eclipse.commands.File;
import de.his.internal.testdudeles.eclipse.commands.SourceFile;

final class EditorWindow extends AbstractEventInvocationSource {

	private final Optional<IEditorPart> editor;

	EditorWindow(final ExecutionEvent event) {
		editor = getActiveEditorPart(event);
	}

	private Optional<IEditorPart> getActiveEditorPart(final ExecutionEvent event){
		final Optional<Object> editor = Optional.fromNullable(HandlerUtil.getVariable(event, ISources.ACTIVE_EDITOR_NAME));
		if(editor.isPresent() && editor.get() instanceof IEditorPart) {
			return Optional.of((IEditorPart) editor.get());
		}
		return Optional.absent();
	}

	@Override
	public Optional<SourceFile> file() {
		if(editor.isPresent()) {
			final IAdaptable adaptable = editor.get().getEditorInput();
			final File file = toFile(adaptable);
			return Optional.of(new SourceFileFromEditor(file, editor.get()));
		}
		return Optional.absent();
	}


}
