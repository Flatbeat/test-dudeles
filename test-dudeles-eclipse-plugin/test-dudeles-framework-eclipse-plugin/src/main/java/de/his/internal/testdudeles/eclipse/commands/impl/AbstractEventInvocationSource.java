package de.his.internal.testdudeles.eclipse.commands.impl;

import static de.his.internal.testdudeles.eclipse.TestDudelesEclipsePlugin.plugin;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;

import de.his.internal.testdudeles.eclipse.commands.EventInvocationSource;
import de.his.internal.testdudeles.eclipse.domain.File;
abstract class AbstractEventInvocationSource implements EventInvocationSource {

	protected File toFile(final IAdaptable adaptable) {
		final IFile file = adaptable.getAdapter(IFile.class);
		return plugin().getWorkspace().toFile(file);
	}

}
