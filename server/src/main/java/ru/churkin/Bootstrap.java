package ru.churkin;

import ru.churkin.api.*;
import ru.churkin.endpoint.ProjectEndpoint;
import ru.churkin.endpoint.TaskEndpoint;
import ru.churkin.endpoint.UserEndpoint;
import ru.churkin.repository.*;
import ru.churkin.service.ProjectServiceImpl;
import ru.churkin.service.TaskServiceImpl;
import ru.churkin.service.UserServiceImpl;

import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Bootstrap implements ServiceLocator {

    final ServiceLocator serviceLocator = this;
    public static final String URL = "jdbc:mysql://localhost:3306/tasklistdb";
    public static final String DB_USER_NAME = "root";
    public static final String DB_PASSWORD = "root";
    final ITaskRepository taskRepository = new TaskRepositoryInMem();
    final IProjectRepository projectRepository = new ProjectRepositoryInMem();
    final IUserRepository userRepository = new UserRepositoryInMem();

//    final ConnectionDB conn = new ConnectionDB();
//    Connection connection = conn.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
//    final ITaskRepository taskRepository = new TaskRepositoryJDBC(connection);
//    final IProjectRepository projectRepository = new ProjectRepositoryJDBC(connection);
//    final IUserRepository userRepository = new UserRepositoryJDBC(connection);

    final TaskServiceImpl taskServiceImpl = new TaskServiceImpl(taskRepository);
    final ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl(projectRepository);
    final UserServiceImpl userServiceImpl = new UserServiceImpl(userRepository);

    final UserEndpoint userEndpoint = new UserEndpoint(serviceLocator);
    final TaskEndpoint taskEndpoint = new TaskEndpoint(serviceLocator);
    final ProjectEndpoint projectEndpoint = new ProjectEndpoint(serviceLocator);

//    final Map<String, Command> commandList = new HashMap<>();

//    private Class[] cls;

    public Bootstrap() throws SQLException {
    }

    public void init() {

        Endpoint.publish("http://localhost:8080/TaskList/user?wsdl", userEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/task?wsdl", taskEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/project?wsdl", projectEndpoint);
//        this.cls = cls;
//
//        for (Class cl : cls) {
//            Command com = (Command) cl.newInstance();
//            com.setLocator(serviceLocator);
//            commandList.put(com.name(), com);
//        }
//
//        String userInput = reader.readLine();
//        while (!"exit".equals(userInput)) {
//            if (commandList.containsKey(userInput)) {
//                Command cmnd = commandList.get(userInput);
//                this.execute(cmnd);
//            } else {
//                System.out.println("несуществующая команда");
//            }
//            userInput = reader.readLine();
//        }
//        conn.closeConnection();

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

//    @Override
//    public TerminalService getTerminalService() {
//        return terminalService;
//    }

//    @Override
//    public Map<String, Command> getCommandMap() {
//        return commandList;
//    }

//    @Override
//    public ConnectionDB connDB() {
//        return conn;
//    }

//    public void execute(Command command) throws IOException, SQLException {
//        User user = serviceLocator.getUserService().currentUser;
//        if (!command.isAuth() || (command.isAuth() && serviceLocator.getUserService().validateUser(user))) {
//            command.execute();
//        } else System.out.println("требуется авторизация");
//    }
}
