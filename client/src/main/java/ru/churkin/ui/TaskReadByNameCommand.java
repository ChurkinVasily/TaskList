package ru.churkin.ui;

import ru.churkin.endpoint.Exception_Exception;
import ru.churkin.endpoint.TaskDTO;

import java.io.IOException;

public class TaskReadByNameCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
    }

    @Override
    public String name() {
        return "tfn";
    }

    @Override
    public String description() {
        return "Task Find by Name";
    }

    @Override
    public void execute() throws IOException, Exception_Exception {
        String userId = serviceLocator.getUserEndpoint().getCurrentUser().getId();
        System.out.println("для просмотра нужной задачи (task) введите ее имя");
        String name = serviceLocator.getTerminalService().nextLine();
        TaskDTO task = serviceLocator.getTaskEndpoint().findTaskByName(name);
        try {
            if (task.getUserId().equals(userId)) {
                TaskDTO currentTask = serviceLocator.getTaskEndpoint().findTaskByName(name);
                System.out.println("Task{" +
                        "id='" + currentTask.getId() + '\'' +
                        ", name='" + currentTask.getName() + '\'' +
                        ", description='" + currentTask.getDescription() + '\'' +
                        ", timeStart='" + currentTask.getTimeStart() + '\'' +
                        ", timeFinish='" + currentTask.getTimeFinish() + '\'' +
                        ", projectId='" + currentTask.getProjectId() + '\'' +
                        ", userId='" + currentTask.getUserId() + '\'' +
                        '}');
            } else {
                System.out.println("Этот Task невозможно посмотреть из вашего профиля");
            }
        } catch (NullPointerException e) {
            System.out.println("нет задачи с таким именем");
        }


    }
}
