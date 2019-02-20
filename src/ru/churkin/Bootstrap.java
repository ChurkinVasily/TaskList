package ru.churkin;

import ru.churkin.api.*;
import ru.churkin.entity.User;
import ru.churkin.repository.*;
import ru.churkin.service.ProjectServiceImpl;
import ru.churkin.service.TaskServiceImpl;
import ru.churkin.service.TerminalService;
import ru.churkin.service.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Bootstrap implements ServiceLocator {

    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final ServiceLocator serviceLocator = this;

    final ITaskRepository taskRepository = new TaskRepositoryInMem();
    final IProjectRepository projectRepository = new ProjectRepositoryInMem();
    final IUserRepository userRepository = new UserRepositoryInMem();
//    final ITaskRepository taskRepository = new TaskRepositoryDB();
//    final IProjectRepository projectRepository = new ProjectRepositoryDB();
//    final IUserRepository userRepository = new UserRepositoryDB();

    final TaskServiceImpl taskServiceImpl = new TaskServiceImpl(taskRepository);
    final ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl(projectRepository);
    final UserServiceImpl userServiceImpl = new UserServiceImpl(userRepository);
    final TerminalService terminalService = new TerminalService(reader);

    public static final String URL = "jdbc:mysql://localhost:3306/tasklistdb";
    public static final String DB_USER_NAME = "root";
    public static final String DB_PASSWORD = "root";

    final Map<String, Command> commandList = new HashMap<>();

    private Class[] cls;

    public void init(Class[] cls) throws IOException, IllegalAccessException, InstantiationException {

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
                    User user = userServiceImpl.currentUser;
                    cmnd.execute(user);
                } else {
                    System.out.println("несуществующая команда");
                }
            userInput = reader.readLine();
        }
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
}
