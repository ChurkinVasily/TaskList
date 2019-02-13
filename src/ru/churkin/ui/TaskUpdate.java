package ru.churkin.ui;

import ru.churkin.entity.Task;

import java.io.IOException;

public class TaskUpdate extends CommandAbstract {

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
        String name = serviceLocator.getTerminalService().nextLine();
        System.out.println("enter new parameters: description, time start, time finish, project ID");
        newTask.setName(name);
        newTask.setDescription(serviceLocator.getTerminalService().nextLine());
        newTask.setTimeStart(serviceLocator.getTerminalService().nextLine());
        newTask.setTimeFinish(serviceLocator.getTerminalService().nextLine());
        newTask.setProjectId(serviceLocator.getTerminalService().nextLine());
        boolean isUpdate = serviceLocator.getTaskService().updateTask(name, newTask);
        if (isUpdate) {
            System.out.println("task успешно обновлен");
        } else {
            System.out.println("не удалось обновить Task. пустое или несуществующее имя");
        }

    }
}
