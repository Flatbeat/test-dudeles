package de.his.internal.testdudeles.eclipse.commands.impl;

import static de.his.internal.testdudeles.eclipse.TestDudelesEclipsePlugin.plugin;

import de.his.internal.testdudeles.eclipse.commands.CommandExecutionContext;
import de.his.internal.testdudeles.eclipse.commands.SourceFile;
import de.his.internal.testdudeles.eclipse.ui.UserInterface;
import de.his.internal.testdudeles.eclipse.ui.UserInterfaceState;

public class CommandExecutionContextImpl implements CommandExecutionContext {

	private final EventInvocationContext invocationContext;

	public CommandExecutionContextImpl(final EventInvocationContext invocationContext) {
		this.invocationContext = invocationContext;
	}

	@Override
	public SourceFile getSelectedSourceFile() {
		return invocationContext.getSelectedSourceFile();
	}

	@Override
	public UserInterface getUserInterface() {
		final UserInterfaceState state = invocationContext.createUserInterfaceState();
		return plugin().createUserInterface(state);
	}

}
