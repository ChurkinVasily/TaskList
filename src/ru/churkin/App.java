package ru.churkin;

import ru.churkin.ui.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static Class[] classes = {
            TaskCreateCommand.class, TaskDeleteCommand.class, TaskUpdateCommand.class, TaskReadByNameCommand.class, TasksShowAllForUserCommand.class,
            ProjectCreateCommand.class, ProjectDeleteCommand.class, ProjectUpdateCommand.class, ProjectReadByNameCommand.class, ProjectShowAllCommand.class,
            HelpCommand.class,
            UserCreateCommand.class, UserLoginCommand.class, UserLogoutCommand.class
    };

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.init(classes);
    }
}
