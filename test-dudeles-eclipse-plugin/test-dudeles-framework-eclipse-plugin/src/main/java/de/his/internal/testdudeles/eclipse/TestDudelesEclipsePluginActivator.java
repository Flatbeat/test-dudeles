package de.his.internal.testdudeles.eclipse;

import static de.his.internal.testdudeles.eclipse.TestDudelesEclipsePlugin.plugin;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public final class TestDudelesEclipsePluginActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "test-dudeles-eclipse";

	private static TestDudelesEclipsePluginActivator instance;


	public static TestDudelesEclipsePluginActivator getInstance() {
		return instance;
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		instance = this;
		plugin().setBundleContext(context);
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		instance = null;
		super.stop(context);
	}

}
