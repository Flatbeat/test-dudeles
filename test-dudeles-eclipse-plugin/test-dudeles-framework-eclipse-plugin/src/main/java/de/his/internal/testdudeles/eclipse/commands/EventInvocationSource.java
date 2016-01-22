package de.his.internal.testdudeles.eclipse.commands;

import com.google.common.base.Optional;

import de.his.internal.testdudeles.eclipse.domain.SourceFile;

public interface EventInvocationSource {

	Optional<SourceFile> file();

}
