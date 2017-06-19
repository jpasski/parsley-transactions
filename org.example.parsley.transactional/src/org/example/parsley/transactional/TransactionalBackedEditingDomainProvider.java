package org.example.parsley.transactional;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class TransactionalBackedEditingDomainProvider implements
		Provider<EditingDomain> {

	@Inject
	private TransactionalEditingDomain.Factory tedFactory;

	@Override
	public EditingDomain get() {
		// delegate to the same factory used by the equinox extension to
		// create the editing domain
		return tedFactory.createEditingDomain();
	}

}
