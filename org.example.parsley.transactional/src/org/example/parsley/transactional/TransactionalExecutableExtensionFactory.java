package org.example.parsley.transactional;

import org.eclipse.emf.parsley.runtime.ui.AbstractGuiceAwareExecutableExtensionFactory;

import com.google.inject.Injector;

public class TransactionalExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Injector getInjector() throws Exception {
		return TransactionalInjectorProvider.getInjector();
	}

}
