package org.example.parsley.transactional;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class TransactionalEditingDomainProvider implements
		Provider<TransactionalEditingDomain> {

	@Inject
	private TransactionalEditingDomain.Factory tedFactory;

	@Override
	public TransactionalEditingDomain get() {
		return tedFactory.createEditingDomain();
	}

}
