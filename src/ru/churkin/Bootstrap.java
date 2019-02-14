package ru.churkin;

import ru.churkin.api.Command;
import ru.churkin.api.ProjectService;
import ru.churkin.api.ServiceLocator;
import ru.churkin.api.TaskService;
import ru.churkin.entity.User;
import ru.churkin.repository.ProjectRepository;
import ru.churkin.repository.TaskRepository;
import ru.churkin.repository.UserRepository;
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
    final TaskRepository taskRepository = new TaskRepository();
    final ProjectRepository projectRepository = new ProjectRepository();
    final UserRepository userRepository = new UserRepository();
    final TaskServiceImpl taskServiceImpl = new TaskServiceImpl(taskRepository);
    final ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl(projectRepository);
    final UserServiceImpl userServiceImpl = new UserServiceImpl(userRepository);
    final TerminalService terminalService = new TerminalService(reader);

    final Map<String, Command> commandList = new HashMap<>();
    User user = new User();

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
                    commandList.get(userInput).execute();
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
