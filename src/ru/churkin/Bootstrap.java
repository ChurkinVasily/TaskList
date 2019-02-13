package ru.churkin;

import ru.churkin.api.Command;
import ru.churkin.api.ProjectService;
import ru.churkin.api.ServiceLocator;
import ru.churkin.api.TaskService;
import ru.churkin.repository.ProjectRepository;
import ru.churkin.repository.TaskRepository;
import ru.churkin.service.ProjectServiceImpl;
import ru.churkin.service.TaskServiceImpl;
import ru.churkin.service.TerminalService;

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
    final TaskServiceImpl taskServiceImpl = new TaskServiceImpl(taskRepository);
    final ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl(projectRepository);
    final TerminalService terminalService = new TerminalService(reader);

    Map<String, Command> commandList = new HashMap<>();

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
            if ("help".equals(userInput)) {
                for (Map.Entry<String, Command> entry : commandList.entrySet()) {
                    Command com = entry.getValue();
                    System.out.println(entry.getKey() + " : " + com.description());
                }
            } else {
                if (commandList.containsKey(userInput)) {
                    commandList.get(userInput).execute();
                } else {
                    System.out.println("несуществующая команда");
                }
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
    public TerminalService getTerminalService() {
        return terminalService;
    }
}
