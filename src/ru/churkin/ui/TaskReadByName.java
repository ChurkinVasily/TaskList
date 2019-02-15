package ru.churkin.ui;

import ru.churkin.entity.Task;

import java.io.IOException;

public class TaskReadByName extends CommandAbstract {

    @Override
    public String name() {
        return "tfn";
    }

    @Override
    public String description() {
        return "Task Find by Name";
    }

    @Override
    public void execute() throws IOException {
        String userId = serviceLocator.getUserService().currentUser.getId();
        System.out.println("для просмотра нужной задачи (task) введите ее имя");
        String name = serviceLocator.getTerminalService().nextLine();
        Task task = serviceLocator.getTaskService().findTaskByName(name);
        try {
            if (task.getUserId().equals(userId)) {
                System.out.println(serviceLocator.getTaskService().findTaskByName(name));
            } else {
                System.out.println("Этот Task невозможно посмотреть из вашего профиля");
            }
        } catch (NullPointerException e) {
            System.out.println("нет задачи с таким именем");
        }


    }
}
