package de.his.internal.testdudeles.eclipse.ui.impl;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;

import de.his.internal.testdudeles.eclipse.ui.DialogFactory;
import de.his.internal.testdudeles.eclipse.ui.UserInterface;
import de.his.internal.testdudeles.eclipse.ui.UserInterfaceState;
import de.his.internal.testdudeles.eclipse.ui.WizardFactory;

public class UserInterfaceImpl implements UserInterface {

	private final IWorkbench workbench;

	private final IWorkbenchPage activePage;

	private final DialogFactory dialogs;

	private final WizardFactory wizards;

	public UserInterfaceImpl(final UserInterfaceState state, final DialogFactory dialogs, final WizardFactory wizards) {
		workbench = state.workbench();
		activePage = state.page();
		this.dialogs = dialogs;
		this.wizards = wizards;
	}

	@Override
	public void showInfo(final String message) {
		dialogs.infoDialog(message).open();
	}

}
