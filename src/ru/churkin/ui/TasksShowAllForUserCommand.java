package ru.churkin.ui;

import ru.churkin.entity.Task;

import java.util.List;

public class TasksShowAllForUserCommand extends AbstractCommand {

    @Override
    public String name() {
        return "shat";
    }

    @Override
    public String description() {
        return "SHow All Tasks for user";
    }

    @Override
    public void execute() {
        String userId = serviceLocator.getUserService().currentUser.getId();
        List<Task> tasks = serviceLocator.getTaskService().findTaskByUserId(userId);
        if (tasks != null) {
            for (Task task : tasks) {
                System.out.println(task.toString());
            }
        } else {
            System.out.println("список задач пуст");
        }

// todo - DONE! показ всех тасков всех юзеров
//        Map<String, Task> tasks = serviceLocator.getTaskService().getAllTasks();
//        if (tasks != null) {
//            for (Map.Entry<String, Task> entry : tasks.entrySet()) {
//                System.out.println(entry.getValue());
//            }
//        } else {
//            System.out.println("список задач пуст");
//        }

    }
}
