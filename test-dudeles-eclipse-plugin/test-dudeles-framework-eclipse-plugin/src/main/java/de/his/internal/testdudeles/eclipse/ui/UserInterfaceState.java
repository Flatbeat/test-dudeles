package de.his.internal.testdudeles.eclipse.ui;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;

public interface UserInterfaceState {

	IWorkbenchPage page();

	Shell shell();

	IWorkbench workbench();
}
