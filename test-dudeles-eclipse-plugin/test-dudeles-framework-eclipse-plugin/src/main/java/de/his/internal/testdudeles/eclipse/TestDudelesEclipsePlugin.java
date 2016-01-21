package de.his.internal.testdudeles.eclipse;

import org.osgi.framework.BundleContext;

import de.his.internal.testdudeles.eclipse.commands.CommandExecutionContext;
import de.his.internal.testdudeles.eclipse.commands.GenerateDudelesCommand;
import de.his.internal.testdudeles.eclipse.commands.impl.GenerateDudelesCommandImpl;
import de.his.internal.testdudeles.eclipse.env.Workspace;
import de.his.internal.testdudeles.eclipse.env.impl.EclipseWorkspace;
import de.his.internal.testdudeles.eclipse.ui.DialogFactory;
import de.his.internal.testdudeles.eclipse.ui.UserInterface;
import de.his.internal.testdudeles.eclipse.ui.UserInterfaceState;
import de.his.internal.testdudeles.eclipse.ui.WizardFactory;
import de.his.internal.testdudeles.eclipse.ui.impl.MessageDialogFactory;
import de.his.internal.testdudeles.eclipse.ui.impl.UserInterfaceImpl;
import de.his.internal.testdudeles.eclipse.ui.impl.WizardFactoryImpl;

public final class TestDudelesEclipsePlugin {

	private static TestDudelesEclipsePlugin instance = new TestDudelesEclipsePlugin();

	public static TestDudelesEclipsePlugin plugin() {
		return instance;
	}

	private BundleContext context;

	public final void setBundleContext(final BundleContext context) {
		this.context = context;
	}

	public GenerateDudelesCommand createGenerateDudelesCommand(final CommandExecutionContext executionContext) {
		return new GenerateDudelesCommandImpl(executionContext);
	}

	public Workspace getWorkspace() {
		return EclipseWorkspace.get();
	}

	public UserInterface createUserInterface(final UserInterfaceState state) {
		final DialogFactory dialogs = new MessageDialogFactory(state.shell());
		final WizardFactory wizards = new WizardFactoryImpl(state.workbench(), state.shell());
		return new UserInterfaceImpl(state, dialogs, wizards);
	}

}
