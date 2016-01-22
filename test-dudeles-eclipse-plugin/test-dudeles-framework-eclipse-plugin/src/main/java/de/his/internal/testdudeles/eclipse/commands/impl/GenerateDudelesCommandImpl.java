package de.his.internal.testdudeles.eclipse.commands.impl;

import de.his.internal.testdudeles.eclipse.commands.CommandExecutionContext;
import de.his.internal.testdudeles.eclipse.commands.GenerateDudelesCommand;
import de.his.internal.testdudeles.eclipse.domain.SourceFile;
import de.his.internal.testdudeles.eclipse.ui.UserInterface;

public final class GenerateDudelesCommandImpl implements GenerateDudelesCommand {

	private final CommandExecutionContext executionContext;

	public GenerateDudelesCommandImpl(final CommandExecutionContext executionContext) {
		this.executionContext = executionContext;
	}

	@Override
	public void execute() {
		final UserInterface ui = executionContext.getUserInterface();
		final SourceFile file = executionContext.getSelectedSourceFile();
		if(file.isSupported()) {
			ui.showInfo("Generate Test-Dudeles!");
		} else {
			ui.showInfo("No File selected!");
		}

	}

}
