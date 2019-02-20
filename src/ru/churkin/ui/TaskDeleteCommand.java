package ru.churkin.ui;

import java.io.IOException;

public class TaskDeleteCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
    }

    @Override
    public String name() {
        return "td";
    }

    @Override
    public String description() {
        return "Task Deleting";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("введите имя задачи (task) для удаления");
        String name = serviceLocator.getTerminalService().nextLine();
        boolean isDelete = serviceLocator.getTaskService().deleteTask(name);
        if (isDelete) System.out.println("успешно удалено");
        else System.out.println("ошибка удаления. введено пустое или не существующее имя");
    }
}
