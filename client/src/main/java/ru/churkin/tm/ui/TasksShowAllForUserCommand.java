package ru.churkin.tm.ui;

import ru.churkin.tm.endpoint.*;

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
        Session currentSession = serviceLocator.getCurrentSession();
        validateSession(currentSession);

        String userId = serviceLocator.getCurrentSession().getUserId();
        List<TaskDTO> tasks = serviceLocator.getTaskEndpoint().findTaskByUserId(userId);
        if (!tasks.isEmpty()) {
            for (TaskDTO currentTask : tasks) {
                String projectId = currentTask.getProjectId();
                System.out.println("Task{" +
                        "id='" + currentTask.getId() + '\'' +
                        ", name='" + currentTask.getName() + '\'' +
                        ", description='" + currentTask.getDescription() + '\'' +
                        ", timeStart='" + currentTask.getTimeStart() + '\'' +
                        ", timeFinish='" + currentTask.getTimeFinish() + '\'' +
                        ", project='" + serviceLocator.getProjectEndpoint().findProjectById(projectId).getName() + '\'' +
                        ", userName='" + serviceLocator.getUserEndpoint().findUserById(userId).getName() +
                        '}');
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
