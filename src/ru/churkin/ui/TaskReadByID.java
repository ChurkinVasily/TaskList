package ru.churkin.ui;

import ru.churkin.entity.Task;
import ru.churkin.repository.TaskRepository;
import ru.churkin.service.TaskServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TaskReadByID implements Command{

    private BufferedReader reader;
    private TaskRepository taskRepository;
    private TaskServiceImpl taskServiceImpl;

    public TaskReadByID(BufferedReader reader, TaskRepository taskRepository, TaskServiceImpl taskServiceImpl) {
        this.reader = reader;
        this.taskRepository = taskRepository;
        this.taskServiceImpl = taskServiceImpl;
    }

    //    private Map<String, Task> tempMap = new HashMap<>();

    @Override
    public String name() {
        return "tr";
    }

    @Override
    public String description() {
        return "Read task by ID";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("для просмотра нужной задачи (task) введите ее имя");
        String name = reader.readLine();
        taskServiceImpl.findTaskByName(name);
    }
}
