package de.his.internal.testdudeles.eclipse.ui.impl;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import de.his.internal.testdudeles.eclipse.ui.Dialog;
import de.his.internal.testdudeles.eclipse.ui.DialogFactory;

public class MessageDialogFactory implements DialogFactory {

	private static final String TITLE = "Test-Dudeles";

	private final Shell activeShell;

	public MessageDialogFactory(final Shell shell) {
		activeShell = shell;
	}

	@Override
	public Dialog infoDialog(final String message) {
		return new Dialog() {
			@Override
			public void open()
			{
				MessageDialog.openInformation(activeShell, TITLE, message);
			}
		};
	}

}
