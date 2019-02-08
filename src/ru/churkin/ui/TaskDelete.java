package ru.churkin.ui;

import ru.churkin.entity.Task;
import ru.churkin.repository.TaskRepository;
import ru.churkin.service.TaskServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TaskDelete implements Command {

    private BufferedReader reader;
    private TaskRepository taskRepository;
    private TaskServiceImpl taskServiceImpl;

    public TaskDelete(BufferedReader reader, TaskRepository taskRepository, TaskServiceImpl taskServiceImpl) {
        this.reader = reader;
        this.taskRepository = taskRepository;
        this.taskServiceImpl = taskServiceImpl;
    }

    private Map<String, Task> taskMap = new HashMap<>();

    @Override
    public String name() {
        return "td";
    }

    @Override
    public String description() {
        return "Task remove";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("enter task id for remove");
        String id = reader.readLine();
        taskServiceImpl.deleteTask(id);
        System.out.println("successful remove");
    }
}
