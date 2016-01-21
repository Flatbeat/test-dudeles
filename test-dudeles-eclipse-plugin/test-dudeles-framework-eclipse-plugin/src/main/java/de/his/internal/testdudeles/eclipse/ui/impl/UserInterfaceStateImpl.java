package de.his.internal.testdudeles.eclipse.ui.impl;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.base.Optional;

import de.his.internal.testdudeles.eclipse.ui.UserInterfaceState;

public class UserInterfaceStateImpl implements UserInterfaceState {

	private final  ExecutionEvent event;

	public UserInterfaceStateImpl(final ExecutionEvent event) {
		this.event = event;
	}

	@Override
	public IWorkbenchPage page() {
		final Optional<IWorkbenchWindow> window = Optional.fromNullable(HandlerUtil.getActiveWorkbenchWindow(event));
		if(window.isPresent()) {
			return window.get().getActivePage();
		}
		throw new RuntimeException();
	}

	@Override
	public Shell shell() {
		return HandlerUtil.getActiveShell(event);
	}

	@Override
	public IWorkbench workbench() {
		final Optional<IWorkbenchWindow> window = Optional.fromNullable(HandlerUtil.getActiveWorkbenchWindow(event));
		if(window.isPresent()) {
			return window.get().getWorkbench();
		}
		throw new RuntimeException();
	}
}
