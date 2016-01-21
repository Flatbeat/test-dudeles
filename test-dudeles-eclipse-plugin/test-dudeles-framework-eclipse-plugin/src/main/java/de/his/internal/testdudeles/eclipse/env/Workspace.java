package de.his.internal.testdudeles.eclipse.env;

import org.eclipse.core.resources.IFile;

import de.his.internal.testdudeles.eclipse.commands.File;

public interface Workspace {

	File toFile(IFile file);

}
