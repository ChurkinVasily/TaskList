package ru.churkin;

import ru.churkin.api.Command;
import ru.churkin.repository.ProjectRepository;
import ru.churkin.repository.TaskRepository;
import ru.churkin.service.ProjectServiceImpl;
import ru.churkin.service.TaskServiceImpl;
import ru.churkin.ui.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    public void init() throws IOException {

        final TaskRepository taskRepository = new TaskRepository();
        final ProjectRepository projectRepository = new ProjectRepository();
        final TaskServiceImpl taskServiceImpl = new TaskServiceImpl(taskRepository);
        final ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl(projectRepository);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final TaskCreate taskCreate = new TaskCreate(reader, taskServiceImpl);
        final TaskDelete taskDelete = new TaskDelete(reader, taskServiceImpl);
        final TaskReadByName taskReadByID = new TaskReadByName(reader, taskServiceImpl);
        final TaskUpdate taskUpdate = new TaskUpdate(reader, taskServiceImpl);
        final ProjectCreate projectCreate = new ProjectCreate(reader, projectServiceImpl);
        final ProjectDelete projectDelete = new ProjectDelete(reader, projectServiceImpl);
        final ProjectReadByName projectReadByName = new ProjectReadByName(reader, projectServiceImpl);
        final ProjectUpdate projectUpdate = new ProjectUpdate(reader, projectServiceImpl);

        Map<String, Command> commandList = new HashMap<>();
        commandList.put(taskCreate.name(), taskCreate);
        commandList.put(taskReadByID.name(), taskReadByID);
        commandList.put(taskUpdate.name(), taskUpdate);
        commandList.put(taskDelete.name(), taskDelete);
        commandList.put(projectCreate.name(), projectCreate);
        commandList.put(projectDelete.name(), projectDelete);
        commandList.put(projectReadByName.name(), projectReadByName);
        commandList.put(projectUpdate.name(), projectUpdate);

        String userInput = reader.readLine();

        while (!"exit".equals(userInput)) {
            if ("help".equals(userInput)) {
                for (Map.Entry<String, Command> entry : commandList.entrySet()) {
                    Command com = entry.getValue();
                    System.out.println(entry.getKey() + " : " + com.description());
                }
            }  else {
                if (commandList.containsKey(userInput)) {
                    commandList.get(userInput).execute();
                } else {
                    System.out.println("несуществующая команда");
                }
            }
            userInput = reader.readLine();
        }
    }
}
