package ru.churkin.tm.ui;


import ru.churkin.tm.endpoint.Exception_Exception;
import ru.churkin.tm.endpoint.Session;
import ru.churkin.tm.endpoint.TaskDTO;

import java.io.IOException;


public class TaskCreateCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
    }

    @Override
    public String name() {
        return "tc";
    }

    @Override
    public String description() {
        return "Task Creation";
    }

    @Override
    public void execute() throws IOException, Exception_Exception {
        TaskDTO newTask = new TaskDTO();

        Session currentSession = serviceLocator.getCurrentSession();
        if (!serviceLocator.getSessionEndpoint().validate(currentSession)) {
            System.out.println("сессия не валидирована");
            return;
        }
        newTask.setUserId(currentSession.getUserId());
        System.out.println("enter new task parameters: name");
        newTask.setName(serviceLocator.getTerminalService().nextLine());
        System.out.println("enter new task parameters: project name");
        String projectName = serviceLocator.getTerminalService().nextLine();
        String projectId = serviceLocator.getProjectEndpoint().findProjectByName(projectName).getId();
        newTask.setProjectId(projectId);
        System.out.println(newTask.getProjectId());

        boolean isCreate = false;
        try {
            isCreate = serviceLocator.getTaskEndpoint().createTask(newTask.getName(), newTask.getProjectId());
        } catch (Exception_Exception e) {
            e.printStackTrace();
        }

        if (isCreate) {
            System.out.println("задача (Task) успешно создана");
        } else System.out.println("вы задали существующее или пустое имя");
    }
}

///// --- СТАРАЯ ВЕРСИЯ (БЕЗ СЕССИИ)

//    public void execute() throws IOException, Exception_Exception {
//        TaskDTO newTask = new TaskDTO();
//        newTask.setUserId(serviceLocator.getUserEndpoint().getCurrentUser().getId());
//        System.out.println("enter new task parameters: name");
//        newTask.setName(serviceLocator.getTerminalService().nextLine());
//        System.out.println("enter new task parameters: project name");
//        String projectName = serviceLocator.getTerminalService().nextLine();
//        String projectId = serviceLocator.getProjectEndpoint().findProjectByName(projectName).getId();
//        newTask.setProjectId(projectId);
//        System.out.println(newTask.getProjectId());
//
//        boolean isCreate = false;
//        try {
//            isCreate = serviceLocator.getTaskEndpoint().createTask(newTask.getName(), newTask.getProjectId());
//        } catch (Exception_Exception e) {
//            e.printStackTrace();
//        }
//
//        if (isCreate) {
//            System.out.println("задача (Task) успешно создана");
//        } else System.out.println("вы задали существующее или пустое имя");
//    }