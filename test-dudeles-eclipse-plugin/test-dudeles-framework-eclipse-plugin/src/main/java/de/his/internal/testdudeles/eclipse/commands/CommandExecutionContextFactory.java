package de.his.internal.testdudeles.eclipse.commands;

import de.his.internal.testdudeles.eclipse.commands.impl.EventInvocationContext;

public interface CommandExecutionContextFactory {

	CommandExecutionContext create(final EventInvocationContext event);

}
