package de.his.internal.testdudeles.eclipse.commands.impl;

import org.eclipse.core.runtime.IAdaptable;

import com.google.common.base.Optional;

import de.his.internal.testdudeles.eclipse.commands.SourceFile;

final class FileContextMenu extends AbstractEventInvocationSource {

	private final IAdaptable file;

	FileContextMenu(final Object selection) {
		file = (IAdaptable) selection;
	}

	@Override
	public Optional<SourceFile> file() {
		return Optional.of(new SourceFileFromContextSelection(toFile(file)));
	}

}
