package ru.churkin.ui;

import ru.churkin.endpoint.Exception_Exception;
import ru.churkin.endpoint.Task;

import java.util.List;

public class TasksShowAllForUserCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
    }

    @Override
    public String name() {
        return "shat";
    }

    @Override
    public String description() {
        return "SHow All Tasks for user";
    }

    @Override
    public void execute() throws Exception_Exception {
        String userId = serviceLocator.getUserEndpoint().getCurrentUser().getId();
        List<Task> tasks = serviceLocator.getTaskEndpoint().findTaskByUserId(userId);
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
