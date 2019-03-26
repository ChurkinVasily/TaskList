package ru.churkin.tm.ui;

import ru.churkin.tm.endpoint.Exception_Exception;
import ru.churkin.tm.endpoint.ProjectDTO;
import ru.churkin.tm.endpoint.Session;
import ru.churkin.tm.endpoint.TaskDTO;

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
        Session currentSession = serviceLocator.getCurrentSession();
        validateSession(currentSession);

        String userId = serviceLocator.getCurrentSession().getUserId();
        System.out.println("для просмотра нужной задачи (task) введите ее имя");
        String name = serviceLocator.getTerminalService().nextLine();
        TaskDTO task = serviceLocator.getTaskEndpoint().findTaskByName(name);
        if (task == null) {
            System.out.println("нет задачи с таким именем");
            return;
        }
        if (!task.getUserId().equals(userId)) {
            System.out.println("Этот Task невозможно посмотреть из вашего профиля");
            return;
        }
        TaskDTO currentTask = serviceLocator.getTaskEndpoint().findTaskByName(name);
        String projectId = currentTask.getProjectId();
        ProjectDTO projectDTO = serviceLocator.getProjectEndpoint().findProjectById(projectId);
        System.out.println("Task{" +
                "id='" + currentTask.getId() + '\'' +
                ", name='" + currentTask.getName() + '\'' +
                ", description='" + currentTask.getDescription() + '\'' +
                ", timeStart='" + currentTask.getTimeStart() + '\'' +
                ", timeFinish='" + currentTask.getTimeFinish() + '\'' +
                ", project='" + serviceLocator.getProjectEndpoint().findProjectById(currentTask.getProjectId()).getName() + '\'' +
                ", userName='" + serviceLocator.getUserEndpoint().findUserById(currentTask.getUserId()).getName() + '\'' +
                '}');
    }
}
