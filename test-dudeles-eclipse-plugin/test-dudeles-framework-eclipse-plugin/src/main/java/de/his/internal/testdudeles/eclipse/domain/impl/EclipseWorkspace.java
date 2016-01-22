package de.his.internal.testdudeles.eclipse.domain.impl;

import org.eclipse.core.resources.IFile;

import de.his.internal.testdudeles.eclipse.domain.File;
import de.his.internal.testdudeles.eclipse.domain.Workspace;

public class EclipseWorkspace implements Workspace {

	public static Workspace get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File toFile(final IFile file) {
		return new EclipseFile(file);
	}

}
