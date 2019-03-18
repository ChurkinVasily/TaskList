package ru.churkin;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.enterprise.inject.se.SeContainerInitializer;

public class App {

    public static void main(String[] args) {

        SeContainerInitializer.newInstance()
                .addPackages(App.class.getClasses())
                .initialize()
                .select(Bootstrap.class)
                .get()
                .init();


    }
}
