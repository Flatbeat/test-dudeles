package de.his.internal.testdudeles.eclipse.commands;

public interface SourceFile {

	SourceFile None = NoneConstant.INSTANCE;

	boolean isSupported();

	enum NoneConstant implements SourceFile{

		INSTANCE;

		@Override
		public boolean isSupported() {
			return false;
		}

	}

}
