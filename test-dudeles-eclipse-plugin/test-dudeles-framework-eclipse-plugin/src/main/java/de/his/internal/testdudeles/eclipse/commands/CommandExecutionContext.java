package de.his.internal.testdudeles.eclipse.commands;

import de.his.internal.testdudeles.eclipse.domain.SourceFile;
import de.his.internal.testdudeles.eclipse.ui.UserInterface;

public interface CommandExecutionContext {

	SourceFile getSelectedSourceFile();

	UserInterface getUserInterface();

}