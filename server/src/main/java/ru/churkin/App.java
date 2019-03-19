package ru.churkin;

import ru.churkin.tm.boot.Bootstrap;

import javax.enterprise.inject.se.SeContainerInitializer;

public class App {

    public static void main(String[] args) {

        SeContainerInitializer.newInstance()
                .addPackages(App.class.getPackage())
                .initialize()
                .select(Bootstrap.class)
                .get()
                .init();


    }
}
