package ru.churkin;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class App {

    public static void main(String[] args) {

        Weld weld = new Weld()
                .disableDiscovery()
                .addPackages(App.class.getPackage())
                .interceptors(TransactionalInterceptor.class)
                .property("org.jboss.weld.construction.relaxed", true);

        WeldContainer container = weld.initialize();

        Bootstrap bootstrap = container.select(Bootstrap.class).get();

        bootstrap.init();
    }
}
