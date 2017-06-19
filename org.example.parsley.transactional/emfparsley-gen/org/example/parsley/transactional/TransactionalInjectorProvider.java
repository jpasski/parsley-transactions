package org.example.parsley.transactional;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;
import org.example.parsley.transactional.TransactionalEmfParsleyGuiceModule;

@SuppressWarnings("all")
public class TransactionalInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    if (injector == null) {
      injector = Guice.createInjector(
        new TransactionalEmfParsleyGuiceModule(PluginUtil.getPlugin(
          PluginUtil.getBundle(TransactionalInjectorProvider.class))));
    }
    return injector;
  }
}
