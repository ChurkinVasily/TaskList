package ru.churkin;

import ru.churkin.api.*;
import ru.churkin.entity.User;
import ru.churkin.repository.ConnectionDB;
import ru.churkin.repository.ProjectRepositoryJDBC;
import ru.churkin.repository.TaskRepositoryJDBC;
import ru.churkin.repository.UserRepositoryJDBC;
import ru.churkin.service.ProjectServiceImpl;
import ru.churkin.service.TaskServiceImpl;
import ru.churkin.service.TerminalService;
import ru.churkin.service.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Bootstrap implements ServiceLocator {

    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final ServiceLocator serviceLocator = this;
    public static final String URL = "jdbc:mysql://localhost:3306/tasklistdb";
    public static final String DB_USER_NAME = "root";
    public static final String DB_PASSWORD = "root";
//    final ITaskRepository taskRepository = new TaskRepositoryInMem();
//    final IProjectRepository projectRepository = new ProjectRepositoryInMem();
//    final IUserRepository userRepository = new UserRepositoryInMem();

    final ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
    final ITaskRepository taskRepository = new TaskRepositoryJDBC(connection);
    final IProjectRepository projectRepository = new ProjectRepositoryJDBC(connection);
    final IUserRepository userRepository = new UserRepositoryJDBC(connection);

    final TaskServiceImpl taskServiceImpl = new TaskServiceImpl(taskRepository);
    final ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl(projectRepository);
    final UserServiceImpl userServiceImpl = new UserServiceImpl(userRepository);
    final TerminalService terminalService = new TerminalService(reader);


    final Map<String, Command> commandList = new HashMap<>();

    private Class[] cls;

    public Bootstrap() throws SQLException {
    }

    public void init(Class[] cls) throws IOException, IllegalAccessException, InstantiationException, SQLException {

        this.cls = cls;

        for (Class cl : cls) {
            Command com = (Command) cl.newInstance();
            com.setLocator(serviceLocator);
            commandList.put(com.name(), com);
        }

        String userInput = reader.readLine();
        while (!"exit".equals(userInput)) {
            if (commandList.containsKey(userInput)) {
                Command cmnd = commandList.get(userInput);
                this.execute(cmnd);
            } else {
                System.out.println("несуществующая команда");
            }
            userInput = reader.readLine();
        }

        conn.closeConnection();

    }

    @Override
    public TaskService getTaskService() {
        return taskServiceImpl;
    }

    @Override
    public ProjectService getProjectService() {
        return projectServiceImpl;
    }

    @Override
    public UserServiceImpl getUserService() {
        return userServiceImpl;
    }

    @Override
    public TerminalService getTerminalService() {
        return terminalService;
    }

    @Override
    public Map<String, Command> getCommandMap() {
        return commandList;
    }

    @Override
    public ConnectionDB connDB() {
        return conn;
    }

    public void execute(Command command) throws IOException, SQLException {
        User user = serviceLocator.getUserService().currentUser;
        if (!command.isAuth() || (command.isAuth() && serviceLocator.getUserService().validateUser(user))) {
            command.execute();
        } else System.out.println("требуется авторизация");
    }
}
