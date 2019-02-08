package ru.churkin;

import ru.churkin.repository.TaskRepository;
import ru.churkin.service.TaskService;
import ru.churkin.service.TaskServiceImpl;
import ru.churkin.ui.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Starter {

    public void init() throws IOException {
        TaskRepository taskRepository = new TaskRepository();
        TaskServiceImpl taskServiceImpl = new TaskServiceImpl(taskRepository);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final TaskCreate taskCreate = new TaskCreate(reader, taskRepository, taskServiceImpl);
        final TaskDelete taskDelete = new TaskDelete(reader, taskRepository, taskServiceImpl);
        final TaskReadByID taskReadByID = new TaskReadByID(reader, taskRepository, taskServiceImpl);
        final TaskUpdate taskUpdate = new TaskUpdate(reader, taskRepository, taskServiceImpl);

        Map<String, Command> commandList = new HashMap<>();
        commandList.put(taskCreate.name(), taskCreate);
        commandList.put(taskReadByID.name(), taskReadByID);
        commandList.put(taskUpdate.name(), taskUpdate);
        commandList.put(taskDelete.name(), taskDelete);
        // todo - добавить в список команды Project'a

//        String userInput = reader.readLine();

        while (!"exit".equals(reader.readLine())) {
            String userInput = reader.readLine();

            if ("help".equals(userInput)) {
                    for (Map.Entry<String, Command> entry : commandList.entrySet()) {
                        Command com = entry.getValue();
                        System.out.println(entry.getKey() + " : " + com.description());
                    }
                }
            else {
                String nextCommand = userInput;
                if (commandList.containsKey(nextCommand)) {
                    commandList.get(nextCommand).execute();
                } else {
                    System.out.println("несуществующая команда");
                }
        }







//        if ("help".equals(reader.readLine())) {
//            for (Map.Entry<String, Object> entry : commandMap.entrySet())
//            {
//                System.out.println(entry.getKey() + " : " + entry.getValue());
//            }
       }
    }
}
