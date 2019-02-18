package ru.churkin;

import ru.churkin.api.*;
import ru.churkin.repository.ProjectRepositoryInMem;
import ru.churkin.repository.TaskRepositoryInMem;
import ru.churkin.repository.UserRepositoryInMem;
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
//    final ITaskRepository taskRepository = new TaskRepositoryDB();
    final IProjectRepository projectRepository = new ProjectRepositoryInMem();
//    final IProjectRepository projectRepository = new ProjectRepositoryDB();
    final IUserRepository userRepository = new UserRepositoryInMem();

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
                    try {
                        commandList.get(userInput).execute();
                    }
                    catch (NullPointerException e) {
                        System.out.println("требуется авторизация");
                    }
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
