package ru.churkin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.churkin.tm.boot.Bootstrap;
import ru.churkin.tm.config.AppConfig;


public class App {

    public static void main(String[] args) {

        final ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        final Bootstrap bootstrap = ctx.getBean(Bootstrap.class);
        bootstrap.init();

    }
}
