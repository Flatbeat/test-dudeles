package de.his.internal.testdudeles.eclipse.commands.impl;

import org.eclipse.core.commands.ExecutionEvent;

import com.google.common.base.Optional;

import de.his.internal.testdudeles.eclipse.commands.ApplicationContext;
import de.his.internal.testdudeles.eclipse.commands.EventInvocationSource;
import de.his.internal.testdudeles.eclipse.commands.SourceFile;
import de.his.internal.testdudeles.eclipse.ui.UserInterfaceState;
import de.his.internal.testdudeles.eclipse.ui.impl.UserInterfaceStateImpl;

public class EventInvocationContext {

	private final ExecutionEvent event;

	private final ApplicationContext applicationContext;

	private final EventInvocationSource invocatonSource;

	public EventInvocationContext(final ExecutionEvent invokedEvent) {
		event = invokedEvent;
		applicationContext = new ApplicationContextImpl(event);
		invocatonSource = new EventInvocationSourceFactory().create(event, applicationContext);
	}

	public SourceFile getSelectedSourceFile() {
		final Optional<SourceFile> file = invocatonSource.file();
		if(file.isPresent()) {
			return file.get();
		}
		return SourceFile.None;
	}

	public UserInterfaceState createUserInterfaceState() {
		return new UserInterfaceStateImpl(event);
	}

}
