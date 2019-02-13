package ru.churkin.ui;

import java.io.IOException;

public class TaskReadByName extends CommandAbstract {

    @Override
    public String name() {
        return "tf";
    }

    @Override
    public String description() {
        return "Task Find by name";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("для просмотра нужной задачи (task) введите ее имя");
        String name = serviceLocator.getTerminalService().nextLine();
        try {
            System.out.println(serviceLocator.getTaskService().findTaskByName(name).toString());
        } catch (NullPointerException e) {
            System.out.println("нет задачи с таким именем");
        }
    }
}
