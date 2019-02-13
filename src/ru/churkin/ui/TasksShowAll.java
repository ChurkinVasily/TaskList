package ru.churkin.ui;

import ru.churkin.entity.Task;

import java.util.Map;

public class TasksShowAll extends CommandAbstract {

    @Override
    public String name() {
        return "shat";
    }

    @Override
    public String description() {
        return "SHow All Tasks";
    }

    @Override
    public void execute() {
        Map<String, Task> tasks = serviceLocator.getTaskService().getAllTasks();
        if (tasks != null) {
            for (Map.Entry<String, Task> entry : tasks.entrySet()) {
                System.out.println(entry.getValue());
            }
        } else {
            System.out.println("список задач пуст");
        }
    }
}
