package org.example.parsley.transactional;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain.Factory;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class DefaultTransactionalEditingDomainFactory extends
		TransactionalEditingDomainImpl.FactoryImpl implements
		Provider<TransactionalEditingDomain.Factory> {

	@Inject
	private AdapterFactory adapterFactory;

	/* (non-Javadoc)
	 * @see org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl.FactoryImpl#createEditingDomain()
	 */
	@Override
	public synchronized TransactionalEditingDomain createEditingDomain() {

		TransactionalEditingDomain result = new InjectableTransactionalEditingDomainImpl(adapterFactory);

		// as seen in super method
		mapResourceSet(result);

		return result;
	}

	@Override
	public Factory get() {
		return this;
	}

}
