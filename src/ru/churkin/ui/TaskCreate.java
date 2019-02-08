package ru.churkin.ui;

import ru.churkin.entity.Task;
import ru.churkin.repository.TaskRepository;
import ru.churkin.service.TaskService;
import ru.churkin.service.TaskServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class TaskCreate implements Command{

    private BufferedReader reader;
    private TaskRepository taskRepository;
    private TaskServiceImpl taskServiceImpl;

    public TaskCreate(BufferedReader reader, TaskRepository taskRepository, TaskServiceImpl taskServiceImpl) {
        this.reader = reader;
        this.taskRepository = taskRepository;
        this.taskServiceImpl = taskServiceImpl;
    }

    @Override
    public String name() {
        return "tc";
    }

    @Override
    public String description() {
        return "Create new task";
    }

    @Override
    public void execute() throws IOException {
        Task newTask = new Task();
        System.out.println("enter new task parameters: name, description, timeStart, timeFinish");
        newTask.setName(reader.readLine());
        newTask.setDescription(reader.readLine());
        newTask.setTimeFinish(reader.readLine());
        newTask.setTimeFinish(reader.readLine());
        taskServiceImpl.createTask(newTask);
    }
}
