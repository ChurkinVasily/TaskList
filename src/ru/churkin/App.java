package ru.churkin;

import ru.churkin.ui.*;

import java.io.IOException;

public class App {

     private static Class[] classes = {
        TaskCreate.class, TaskDelete.class, TaskUpdate.class, TaskReadByName.class,
        ProjectCreate.class, ProjectDelete.class, ProjectUpdate.class, ProjectReadByName.class
    };

    public static void main(String[] args) throws IOException {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.init();
    }

}
