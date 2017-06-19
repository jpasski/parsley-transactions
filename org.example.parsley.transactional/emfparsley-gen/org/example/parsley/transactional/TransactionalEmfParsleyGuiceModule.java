package org.example.parsley.transactional;

import com.google.inject.Provider;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.parsley.EmfParsleyGuiceModule;
import org.eclipse.emf.parsley.edit.EditingDomainFinder;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.example.parsley.transactional.DefaultTransactionalEditingDomainFactory;
import org.example.parsley.transactional.TransactionalBackedEditingDomainProvider;
import org.example.parsley.transactional.TransactionalEditingDomainFinder;
import org.example.parsley.transactional.TransactionalEditingDomainProvider;

/**
 * org.example.parsley.transaction EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class TransactionalEmfParsleyGuiceModule extends EmfParsleyGuiceModule {
  public TransactionalEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  public Class<? extends Provider<TransactionalEditingDomain.Factory>> provideFactory() {
    return DefaultTransactionalEditingDomainFactory.class;
  }
  
  public String valueTransactionalEditingDomainId() {
    return "org.example.parsley.transactional.id";
  }
  
  public Class<? extends Provider<TransactionalEditingDomain>> provideTransactionalEditingDomain() {
    return TransactionalEditingDomainProvider.class;
  }
  
  @Override
  public Class<? extends Provider<EditingDomain>> provideEditingDomain() {
    return TransactionalBackedEditingDomainProvider.class;
  }
  
  @Override
  public Class<? extends EditingDomainFinder> bindEditingDomainFinder() {
    return TransactionalEditingDomainFinder.class;
  }
}
