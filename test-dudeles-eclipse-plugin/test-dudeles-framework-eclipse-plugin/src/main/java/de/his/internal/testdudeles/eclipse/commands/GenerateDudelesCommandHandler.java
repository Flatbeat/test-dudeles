package de.his.internal.testdudeles.eclipse.commands;

import static de.his.internal.testdudeles.eclipse.TestDudelesEclipsePlugin.plugin;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import de.his.internal.testdudeles.eclipse.commands.impl.CommandExecutionContextImpl;
import de.his.internal.testdudeles.eclipse.commands.impl.EventInvocationContext;

public class GenerateDudelesCommandHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final EventInvocationContext invocationContext = new EventInvocationContext(event);
		final CommandExecutionContext executionContext = new CommandExecutionContextImpl(invocationContext);
		plugin().createGenerateDudelesCommand(executionContext).execute();
		return null;
	}

}
