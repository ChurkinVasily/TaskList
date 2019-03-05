package ru.churkin.ui;

import ru.churkin.endpoint.Exception_Exception;
import ru.churkin.endpoint.TaskDTO;

import java.io.IOException;

public class TaskUpdateCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
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
    public void execute() throws IOException, Exception_Exception {
        TaskDTO newTask = new TaskDTO();
        String userId = serviceLocator.getUserEndpoint().getCurrentUser().getId();
        System.out.println("enter task-name for update Task");
        String name = serviceLocator.getTerminalService().nextLine();
        boolean isAccess = userId.equals(serviceLocator.getTaskEndpoint().findTaskByName(name).getUserId());
        if (isAccess) {
            System.out.println("enter new parameters: description, time start, time finish, project ID");
            newTask.setName(name);
            newTask.setDescription(serviceLocator.getTerminalService().nextLine());
            newTask.setTimeStart(serviceLocator.getTerminalService().nextLine());
            newTask.setTimeFinish(serviceLocator.getTerminalService().nextLine());
            newTask.setProjectId(serviceLocator.getTerminalService().nextLine());
            newTask.setUserId(userId);
            boolean isUpdate = serviceLocator.getTaskEndpoint().updateTask(name,
                    newTask.getName(),
                    newTask.getDescription(),
                    newTask.getTimeStart(),
                    newTask.getTimeFinish(),
                    newTask.getProjectId(),
                    userId);
            if (isUpdate) {
                System.out.println("task успешно обновлен");
            } else {
                System.out.println("не удалось обновить Task. пустое или несуществующее имя");
            }
        } else {
            System.out.println("задача Task не доступна для данного профиля");
        }

    }
}
