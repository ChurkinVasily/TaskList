package ru.churkin.ui;

import ru.churkin.api.Command;
import ru.churkin.entity.Task;
import ru.churkin.service.TaskServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class TaskUpdate implements Command {

    private BufferedReader reader;
    private TaskServiceImpl taskServiceImpl;

    public TaskUpdate(BufferedReader reader, TaskServiceImpl taskServiceImpl) {
        this.reader = reader;
        this.taskServiceImpl = taskServiceImpl;
    }

    @Override
    public String name() {
        return "tu";
    }

    @Override
    public String description() {
        return "Task Updating";
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
        boolean isUpdate = taskServiceImpl.updateTask(name, newTask);
        if (isUpdate) {
            System.out.println("task успешно обновлен"); }
        else {
            System.out.println("не удалось обновить Task. пустое или несуществующее имя");
        }

    }
}
