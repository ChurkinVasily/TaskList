package ru.churkin.tm.ui;

import ru.churkin.tm.endpoint.Exception_Exception;
import ru.churkin.tm.endpoint.Session;
import ru.churkin.tm.endpoint.TaskDTO;

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
        Session currentSession = serviceLocator.getCurrentSession();
        validateSession(currentSession);

        TaskDTO newTask = new TaskDTO();
        String userId = serviceLocator.getCurrentSession().getUserId();
        System.out.println("enter task-name for update Task");
        String name = serviceLocator.getTerminalService().nextLine();
        boolean isAccess = userId.equals(serviceLocator.getTaskEndpoint().findTaskByName(name).getUserId());
        if (!isAccess) {
            System.out.println("задача Task не доступна для данного профиля");
            return;
        }
        System.out.println("enter new parameters: description, time start, time finish, project name");
        newTask.setName(name);
        newTask.setDescription(serviceLocator.getTerminalService().nextLine());
        newTask.setTimeStart(serviceLocator.getTerminalService().nextLine());
        newTask.setTimeFinish(serviceLocator.getTerminalService().nextLine());
        newTask.setProjectId(serviceLocator.getProjectEndpoint().findProjectByName(serviceLocator.getTerminalService().nextLine()).getId());
        newTask.setUserId(userId);
        boolean isUpdate = serviceLocator.getTaskEndpoint().updateTask(name,
                newTask.getName(),
                newTask.getDescription(),
                newTask.getTimeStart(),
                newTask.getTimeFinish(),
                newTask.getProjectId());
        if (!isUpdate) {
            System.out.println("не удалось обновить Task. пустое или несуществующее имя");
            return;
        }
        System.out.println("task успешно обновлен");
    }
}
