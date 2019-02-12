package ru.churkin;

import ru.churkin.api.Command;
import ru.churkin.api.Locator;
import ru.churkin.api.ProjectService;
import ru.churkin.api.TaskService;
import ru.churkin.repository.ProjectRepository;
import ru.churkin.repository.TaskRepository;
import ru.churkin.service.ProjectServiceImpl;
import ru.churkin.service.ServiceLocator;
import ru.churkin.service.TaskServiceImpl;
import ru.churkin.ui.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    private Class[] cls;
    final TaskRepository taskRepository = new TaskRepository();
    final ProjectRepository projectRepository = new ProjectRepository();
    final TaskServiceImpl taskServiceImpl = new TaskServiceImpl(taskRepository);
    final ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl(projectRepository);
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void init(Class[] cls) throws IOException, IllegalAccessException, InstantiationException {

//    final TaskCreate taskCreate = new TaskCreate(reader, taskServiceImpl);
//    final TaskDelete taskDelete = new TaskDelete(reader, taskServiceImpl);
//    final TaskReadByName taskReadByID = new TaskReadByName(reader, taskServiceImpl);
//    final TaskUpdate taskUpdate = new TaskUpdate(reader, taskServiceImpl);
//    final ProjectCreate projectCreate = new ProjectCreate(reader, projectServiceImpl);
//    final ProjectDelete projectDelete = new ProjectDelete(reader, projectServiceImpl);
//    final ProjectReadByName projectReadByName = new ProjectReadByName(reader, projectServiceImpl);
//    final ProjectUpdate projectUpdate = new ProjectUpdate(reader, projectServiceImpl);

    this.cls = cls;

        Map<String, Command> commandList = new HashMap<>();

        for (Class cl : cls) {
            Command com = (Command) cl.newInstance();
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

//    @Override
//    public TaskServiceImpl getTaskService() {
//        return taskServiceImpl;
//    }
//
//    @Override
//    public ProjectServiceImpl getProjectService() {
//        return projectServiceImpl;
//    }

}
