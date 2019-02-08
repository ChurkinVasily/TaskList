package ru.churkin.ui;

import ru.churkin.entity.Task;
import ru.churkin.repository.TaskRepository;
import ru.churkin.service.TaskServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskUpdate implements Command{

    private BufferedReader reader;
    private TaskRepository taskRepository;
    private TaskServiceImpl taskServiceImpl;

    public TaskUpdate(BufferedReader reader, TaskRepository taskRepository, TaskServiceImpl taskServiceImpl) {
        this.reader = reader;
        this.taskRepository = taskRepository;
        this.taskServiceImpl = taskServiceImpl;
    }

    @Override
    public String name() {
        return "tu";
    }

    @Override
    public String description() {
        return "Update task";
    }

    @Override
    public void execute() throws IOException {
        Task newTask = new Task();
        System.out.println("enter task-name for update Task");
        String name = reader.readLine();
        System.out.println("enter new parameters: name, description, time start, time finish, project ID");
        newTask.setName(reader.readLine());
        newTask.setDescription(reader.readLine());
        newTask.setTimeStart(reader.readLine());
        newTask.setTimeFinish(reader.readLine());
        newTask.setProjectId(reader.readLine());
        taskServiceImpl.updateTask(name, newTask);
    }
}
