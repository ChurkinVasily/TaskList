package ru.churkin;

import ru.churkin.ui.*;

import java.io.IOException;
import java.sql.SQLException;

public class AppClient {
    public static Class[] classes = {
            TaskCreateCommand.class, TaskDeleteCommand.class, TaskUpdateCommand.class, TaskReadByNameCommand.class, TasksShowAllForUserCommand.class,
            ProjectCreateCommand.class, ProjectDeleteCommand.class, ProjectUpdateCommand.class, ProjectReadByNameCommand.class, ProjectShowAllCommand.class,
            HelpCommand.class,
            UserCreateCommand.class, UserLoginCommand.class, UserLogoutCommand.class
    };

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, SQLException {

        BootstrapClient bootstrap = new BootstrapClient();
        bootstrap.init(classes);

    }
}
