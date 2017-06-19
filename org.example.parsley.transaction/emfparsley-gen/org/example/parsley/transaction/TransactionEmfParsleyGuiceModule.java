package org.example.parsley.transaction;

import org.eclipse.emf.parsley.EmfParsleyGuiceModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * org.example.parsley.transaction EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class TransactionEmfParsleyGuiceModule extends EmfParsleyGuiceModule {
  public TransactionEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}
