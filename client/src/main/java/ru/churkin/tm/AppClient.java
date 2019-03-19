package ru.churkin.tm;

import ru.churkin.tm.endpoint.Exception_Exception;
import ru.churkin.tm.ui.*;

import java.io.IOException;
import java.sql.SQLException;

public class AppClient {
    public static Class[] classes = {
            TaskCreateCommand.class, TaskDeleteCommand.class, TaskUpdateCommand.class, TaskReadByNameCommand.class, TasksShowAllForUserCommand.class,
            ProjectCreateCommand.class, ProjectDeleteCommand.class, ProjectUpdateCommand.class, ProjectReadByNameCommand.class, ProjectShowAllCommand.class,
            HelpCommand.class,
            UserCreateCommand.class, UserLoginCommand.class, UserLogoutCommand.class,
            TestCommand.class
    };

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, SQLException, Exception_Exception {

        BootstrapClient bootstrap = new BootstrapClient();
        bootstrap.init(classes);

    }
}
