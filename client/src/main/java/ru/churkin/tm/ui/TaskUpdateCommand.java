package ru.churkin.tm.ui;

import ru.churkin.tm.endpoint.*;

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

        String projectName = serviceLocator.getTerminalService().nextLine();
        ProjectDTO project = serviceLocator.getProjectEndpoint().findProjectByName(projectName);
        if (project == null) {
            System.out.println("несуществующее имя проекта");
            return;
        }

        newTask.setProjectId(project.getId());
        newTask.setUserId(userId);
        boolean isUpdate = serviceLocator.getTaskEndpoint().updateTask(name,
                newTask.getName(),
                newTask.getDescription(),
                newTask.getTimeStart(),
                newTask.getTimeFinish(),
                newTask.getProjectId(),
                newTask.getUserId());
        if (!isUpdate) {
            System.out.println("не удалось обновить Task. пустое или несуществующее имя");
            return;
        }
        System.out.println("task успешно обновлен");
    }
}
