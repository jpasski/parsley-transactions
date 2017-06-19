package org.example.parsley.transactional;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;

import com.google.inject.Inject;

public class InjectableTransactionalEditingDomainImpl extends
		TransactionalEditingDomainImpl {

	@Inject
	public InjectableTransactionalEditingDomainImpl(AdapterFactory adapterFactory) {
		super(adapterFactory, new TransactionalCommandStackImpl());

		// @see org.eclipse.emf.parsley.edit.domain.InjectableAdapterFactoryEditingDomain.InjectableAdapterFactoryEditingDomain(AdapterFactory)
		// also, super class synchronizes on changes to self, so do that here
		synchronized (this) {
			getResourceSet().getURIConverter().getURIMap()
				.putAll(EcorePlugin.computePlatformURIMap(false));
		}
	}
	

}
