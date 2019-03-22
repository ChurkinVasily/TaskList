package ru.churkin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.churkin.tm.boot.Bootstrap;
import ru.churkin.tm.config.AppConfig;


public class App {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Bootstrap bootstrap = (Bootstrap) ctx.getBean(Bootstrap.class);
        bootstrap.init();


//        SeContainerInitializer.newInstance()
//                .addPackages(App.class.getPackage())
//                .initialize()
//                .select(Bootstrap.class)
//                .get()
//                .init();

    }
}
