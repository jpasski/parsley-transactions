package org.example.parsley.transaction;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;
import org.example.parsley.transaction.TransactionEmfParsleyGuiceModule;

@SuppressWarnings("all")
public class TransactionInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    if (injector == null) {
      injector = Guice.createInjector(
        new TransactionEmfParsleyGuiceModule(PluginUtil.getPlugin(
          PluginUtil.getBundle(TransactionInjectorProvider.class))));
    }
    return injector;
  }
}
