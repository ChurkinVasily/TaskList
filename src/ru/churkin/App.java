package ru.churkin;

import ru.churkin.ui.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static Class[] classes = {
            TaskCreate.class, TaskDelete.class, TaskUpdate.class, TaskReadByName.class,
            ProjectCreate.class, ProjectDelete.class, ProjectUpdate.class, ProjectReadByName.class,
            TasksShowAll.class, ProjectShowAll.class,
            HelpCommand.class
    };

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.init(classes);
    }
}
