package org.example.parsley.transactional;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.parsley.edit.EditingDomainFinder;
import org.eclipse.emf.transaction.util.TransactionUtil;

public class TransactionalEditingDomainFinder extends EditingDomainFinder {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.parsley.edit.EditingDomainFinder#getEditingDomainFor(java.lang.Object)
	 */
	@Override
	public EditingDomain getEditingDomainFor(Object object) {
		EditingDomain editingDomain = TransactionUtil.getEditingDomain(object);

		return (editingDomain != null) ? editingDomain : super.getEditingDomainFor(object);
	}

}
